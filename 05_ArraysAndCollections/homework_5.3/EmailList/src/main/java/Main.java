import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private static final char space = ' ';
    private static EmailList emailList = new EmailList();
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here

            switch (getCommand(input)) {
                case ("ADD"):
                    emailList.add(getBody(input));
                    break;
                case ("LIST"):
                    emailList.getSortedEmails();
                    break;
                default:
                    System.out.println("Введена неверная команда");
            }
            
        }
    }

    public static String getCommand(String input) {
        int indexSpace = input.indexOf(space);
        String command = "";

        if (indexSpace != -1) {
            command = input.substring(0, indexSpace);
        } else {
            command = input;
        }
        return command;
    }

    public static String getBody(String input) {
        String body = input.replaceAll("[ADD LIST]", "");
        body = body.trim();
        return body;
    }
}
