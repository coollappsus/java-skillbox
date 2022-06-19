import java.util.Map;
import java.util.Random;

public class Bank extends Thread {

    private final Map<String, Account> accounts;
    private final Random random = new Random();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     * реализована проверка на блокировку
     */


    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        int checkSum = 5000;
        if (amount > checkSum) {
            if (isFraud(fromAccountNum, toAccountNum, amount)){
                blockingAccount(fromAccountNum, toAccountNum);
            }
        }
        if (!accounts.get(fromAccountNum).isBlock() && !accounts.get(toAccountNum).isBlock()) {
                creditProcessing(fromAccountNum, amount);
                debitProcessing(toAccountNum, amount);
        } else {
            System.out.println(accounts.get(fromAccountNum).getAccNumber() + " or " +
                            accounts.get(toAccountNum).getAccNumber() + "are accounts is blocked");
            unblockingAccount(fromAccountNum, toAccountNum);
        }
    }

    /**
     *  метод, который возвращает остаток на счёте.
     */

    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<String,Account> entry: accounts.entrySet()) {
            sum = sum + entry.getValue().getMoney();
        }
        return sum;
    }

    /**
     * блокировка банковского акк
     */
    public void blockingAccount(String fromAccountNum, String toAccountNum) {
        accounts.get(fromAccountNum).setBlock(true);
        accounts.get(toAccountNum).setBlock(true);
    }

    /**
     * разблокировка банковского акк
     */
    public void unblockingAccount(String fromAccountNum, String toAccountNum) {
        accounts.get(fromAccountNum).setBlock(false);
        accounts.get(toAccountNum).setBlock(false);
    }

    /**
     * снятие нужной суммы с акк
     */
    private void creditProcessing(String fromAccountNum, long amount) {
        accounts.get(fromAccountNum).setMoney((getBalance(fromAccountNum) - amount));
    }

    /**
     * пополнение акк на нужную сумму
     */
    private void debitProcessing(String toAccountNum, long amount) {
        accounts.get(toAccountNum).setMoney((getBalance(toAccountNum) + amount));
    }
}
