import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

public class BankTest extends TestCase {
    private static final int AMOUNT_ACCOUNTS = 20;
    private static final int AMOUNT_TRANSACTIONS = 100;
    private static final int AMOUNT_THREAD = 30;
    private static final int ACCOUNT_SUM = 100000;
    private static final String START = "-00";
    private static final String END = "00-";

    Map<String, Account> accounts = new TreeMap<>();
    Bank bank = new Bank(accounts);
    ArrayList<Thread> threads = new ArrayList<>();

    @Override
    public void setUp() {
        for(int i = 0; i < AMOUNT_ACCOUNTS; i++) {
            Account account = new Account(ACCOUNT_SUM, START + i + END, false);
            accounts.put(account.getAccNumber(), account);
        }

    }

    public void testTransfer() {
        AtomicLong allMoneyBeforeTransfer = new AtomicLong();
        AtomicLong allMoneyAfterTransfer = new AtomicLong();
        for (int i = 0; i < AMOUNT_THREAD; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 1; j < AMOUNT_TRANSACTIONS; j++) {
                    int idFrom = (int) ((accounts.size() - 1) * Math.random());
                    int idTo = (accounts.size() - 1) - idFrom;
                    allMoneyBeforeTransfer.set(bank.getSumAllAccounts());
                    try {
                        bank.transfer(accounts.get(START + idFrom + END).getAccNumber(),
                                accounts.get(START + idTo + END).getAccNumber(),
                                Math.round(10000 * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    allMoneyAfterTransfer.set(bank.getSumAllAccounts());
                }
            });
            threads.add(thread);
        }
        threads.forEach(Thread::run);
        assertEquals(allMoneyBeforeTransfer.intValue(), allMoneyAfterTransfer.intValue());
    }

    public void testGetSumAllAccounts() {
        long expected = bank.getSumAllAccounts();
        try {
            bank.transfer(START + "1" + END, START + "2" + END, 409);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);
    }

    public void testBlockingAccount() {
        bank.blockingAccount(START + "1" + END, START + "2" + END);
        boolean actual1 = accounts.get(START + "1" + END).isBlock();
        boolean actual2 = accounts.get(START + "2" + END).isBlock();
        assertTrue(actual1 && actual2);
    }
}
