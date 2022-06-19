import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите текст. Будут замаскированы символы между <>.\nЛибо введите 0 для выхода.");
            String text = scanner.nextLine();

            if (text.equals("0")) {
                break;
            }

            System.out.println(searchAndReplaceDiamonds(text, "***"));
        }

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        String newTextAfterReplace = text.replaceAll("<.+?>", placeholder);
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
        return newTextAfterReplace;
    }

}