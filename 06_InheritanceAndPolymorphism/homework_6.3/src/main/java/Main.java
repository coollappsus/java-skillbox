import java.util.Scanner;

public class Main {

    private static final String CHOOSE_ACCOUNT = "Выберете тип счёта для работы:\n-\"Физ.лицо\"\n-\"Юр.лицо\"\n-\"ИП\"" +
            "\nДля выхода введите 0";
    public static PhysicalPerson physicalPerson = new PhysicalPerson();
    public static LegalPerson legalPerson = new LegalPerson();
    public static IndividualBusinessman individualBusinessman = new IndividualBusinessman();
    private static String operation;
    private static double amount;

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас приветствует программа для рыботы со счетами");

        while (true) {
            System.out.println(CHOOSE_ACCOUNT);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("0")) {
                break;
            }

            switch (input) {
                case ("физ.лицо"):
                    workWithPhysicalPerson();
                    break;
                case ("юр.лицо"):
                    workWithLegalPerson();
                    break;
                case ("ип"):
                    workWithIndividualBusinessman();
                    break;
                default:
                    System.out.println("Введена неверная команда!\n");
                    break;
            }
        }
    }

    private static void workWithPhysicalPerson(){
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Баланс\n-Инфо");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                physicalPerson.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                physicalPerson.put(amount);
                break;
            case ("баланс"):
                physicalPerson.getAmount();
                break;
            case ("инфо"):
                physicalPerson.conditions();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

    private static void workWithLegalPerson(){
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Баланс\n-Инфо");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                legalPerson.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                legalPerson.put(amount);
                break;
            case ("баланс"):
                legalPerson.getAmount();
                break;
            case ("инфо"):
                legalPerson.conditions();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }

    private static void workWithIndividualBusinessman(){
        System.out.println("Выберете операцию:\n-Снять\n-Внести\n-Баланс\n-Инфо");
        Scanner scanner = new Scanner(System.in);
        operation = scanner.nextLine().toLowerCase();

        switch (operation) {
            case ("снять"):
                System.out.println("Какую сумму желаете снять?");
                amount = scanner.nextDouble();
                individualBusinessman.take(amount);
                break;
            case ("внести"):
                System.out.println("Какую сумму желаете положить?");
                amount = scanner.nextDouble();
                individualBusinessman.put(amount);
                break;
            case ("баланс"):
                legalPerson.getAmount();
                break;
            case ("инфо"):
                individualBusinessman.conditions();
                break;
            default:
                System.out.println("Введена неверная команда!");
                break;
        }
    }
}
