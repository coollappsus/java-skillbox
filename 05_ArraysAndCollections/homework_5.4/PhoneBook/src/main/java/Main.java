import java.util.Scanner;

public class Main {
    private static PhoneBook phoneBook = new PhoneBook();
    private static final String help = "Перечень команд для работы с телефонной книгой:\n" +
            "-Введите имя\n" +
            "-Введите номер\n" +
            "-LIST для вывода контактов телефонной книги\n" +
            "-\"0\" для выхода";

    public static void main(String[] args) {
        System.out.println("Вас приветствует телефонная книга. Введите номер, имя или команду " +
                "либо HELP для отображения справки. Для выхода введите 0");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            if (input.equalsIgnoreCase("HELP")) {
                System.out.println(help);
                continue;
            }

            String name;
            String phone;

            switch (getCommand(input)) {
                case ("LIST"):
                    for (String list : phoneBook.getAllContacts()) {
                        System.out.println(list);
                    }
                    break;
                case ("name"):
                    name = input;
                    if (phoneBook.getPhonesByName(name).isEmpty()) {
                        notNameInPhoneBook(name);
                    } else {
                        yesNameInPhoneBook(name);
                        addPhoneForName(name);
                    }
                    break;
                case ("phone"):
                    phone = input;
                    if (phoneBook.getNameByPhone(phone).isEmpty()) {
                        notPhoneInPhoneBook(phone);
                    } else {
                        yesPhoneInPhoneBookAndReplace(phone);
                    }
                    break;
                default:
                    System.out.println("Неверный формат ввода");
                    break;
            }
        }

    }

    public static String getCommand(String input) {
        String command = "";
        String regexPhone = "\\d+";
        String regexName = "\\D+";

        if (input.equalsIgnoreCase("LIST")) {
            command = "LIST";
            return command;
        }
        if (input.matches(regexPhone)) {
            command = "phone";
        }
        if (input.matches(regexName)) {
            command = "name";
        }
        return command;
    }

    public static void notNameInPhoneBook(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Такого имени в телефонной книге нет.\n" +
                "Введите номер телефона для абонента " + "\"" + name + "\"");
        String phone = scanner.nextLine();
        phoneBook.addContact(phone, name);
    }

    public static void yesNameInPhoneBook(String name) {
        System.out.print("Такой контакт уже имеется: ");
        for (String contact : phoneBook.getPhonesByName(name)) {
            System.out.println(contact);
        }
    }

    public static void addPhoneForName(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавить дополнительный телефон? (да/нет)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("да")) {
            System.out.println("Введите дополнительный номер телефона для абонента " + "\"" + name + "\"");
            String phone = scanner.nextLine();
            phoneBook.addContact(phone, name);
        } else {
            System.out.println("Хорошо!");
        }
    }

    public static void notPhoneInPhoneBook(String phone) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Такого номера нет в телефонной книге.\n" +
                "Введите имя абонента для номера " + "\"" + phone + "\"");
        String name = scanner.nextLine();
        phoneBook.addContact(phone, name);
    }

    public static void yesPhoneInPhoneBookAndReplace(String phone) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Такой контакт уже имеется: " + phoneBook.getNameByPhone(phone) +
                "\nПерезаписать? (да/нет)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("да")) {
            System.out.println("Введите имя для телефона " + "\"" + phone + "\"");
            String name = scanner.nextLine();
            phoneBook.addContact(phone, name);
        }else {
            System.out.println("Хорошо!");
        }
    }
}
