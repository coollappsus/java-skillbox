import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();
    private static final char space = ' ';
    private static final String help = "Перечень команд для работы со списком:\n" +
            "\tADD - добавляет задачу\n" +
            "\tEDIT - изменяет задачу\n" +
            "\tDELETE - удаляет задачу\n" +
            "\tLIST - показывает список задач";

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        System.out.println("Вас приветствует программа для работы со списком. Введите команду, " +
                "либо HELP для отображения справки. Для выхода введите 0");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("HELP")){
                System.out.println(help);
                continue;
            }
            if (input.equals("0")) {
                break;
            }

            switch(getCommand(input)) {
                case ("ADD"):
                    if (getNumber(input) != -1){
                        todoList.add(getNumber(input), getBody(input));
                        break;
                    }
                    todoList.add(getBody(input));
                    break;
                case ("EDIT"):
                    todoList.edit(getBody(input), getNumber(input));
                    break;
                case ("DELETE"):
                    todoList.delete(getNumber(input));
                    break;
                case ("LIST"):
                    todoList.getTodos();
                    break;
                default:
                    System.out.println("Введена неверная команда\n" + help);
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

    public static int getNumber(String input) {
        int number = -1;
        String stringNumber = input.replaceAll("[^0-9]", "");
        boolean isEmptyNumber = !stringNumber.equals("");

        if (isEmptyNumber) {
            number = Integer.parseInt(stringNumber.trim());
        }
        return number;
    }

    public static String getBody(String input) {
        String body = input.replaceAll("[0-9LISTADDEDITDELETE]", "");
        body = body.trim();
        return body;
    }
}
