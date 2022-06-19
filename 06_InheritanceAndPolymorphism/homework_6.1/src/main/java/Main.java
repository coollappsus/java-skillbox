import java.util.Scanner;

public class Main {
    protected static Scanner scanner = new Scanner(System.in);
    protected static BankAccount bankAccount = new BankAccount();
    protected static CardAccount cardAccount = new CardAccount();
    protected static DepositAccount depositAccount = new DepositAccount();
    private static String operation;
    private static double amount;

    public static void main(String[] args) {
        System.out.println("Вас приветствует программа для рыботы со счетами. Выберете счёт для работы:\n-\"Расчетный\"\n" +
                "-\"Карточный\"\n-\"Депозитный\"\nДля выхода введите 0");

        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("0")) {
                break;
            }
            if (input.equals("")){
                continue;
            }

            switch (input) {
                case ("расчетный"):
                    workBankAccount();
                    break;
                case ("карточный"):
                    workCardAccount();
                    break;
                case ("депозитный"):
                    workDepositAccount();
                    break;
                default:
                    System.out.println("Введена неверная команда!");
                    break;
            }
        }
    }

    private static void workBankAccount() {
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Перевести\n-Баланс");
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                bankAccount.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                bankAccount.put(amount);
                break;
            case ("баланс"):
                bankAccount.getAmount();
                break;
            case ("перевести"):
                send();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

    private static void workCardAccount() {
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Баланс");
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                cardAccount.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                cardAccount.put(amount);
                break;
            case ("баланс"):
                cardAccount.getAmount();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

    private static void workDepositAccount() {
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Баланс");
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                depositAccount.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                depositAccount.put(amount);
                break;
            case ("баланс"):
                depositAccount.getAmount();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

    private static void send() {
        System.out.println("На какой счёт желаете сделать перевод?\n-Карта\n-Депозит");
        operation = scanner.nextLine().toLowerCase();
        System.out.println("Какую сумму желаете перевести?");
        amount = scanner.nextDouble();

        switch (operation) {
            case ("карта"):
                bankAccount.send(cardAccount, amount);
                break;
            case ("депозит"):
                bankAccount.send(depositAccount, amount);
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }
}
