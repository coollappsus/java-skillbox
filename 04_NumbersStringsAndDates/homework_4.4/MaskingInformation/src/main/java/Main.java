import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите текст. Для скрытия части текста внесите её в <>.\nЛибо введите 0 для выхода.");
            String text = scanner.nextLine();

            if (text.equals("0")) {
                break;
            }

            System.out.println(searchAndReplaceDiamonds(text, "***"));

        }
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        // TODO: реализовать метод, если в строке нет <> - вернуть строку без изменений
            StringBuffer newText = new StringBuffer(text);
            String firstDiamond = "<";
            String secondDiamond = ">";

            int firstDiamondIndex = newText.indexOf(firstDiamond);
            int secondDiamondIndex = newText.indexOf(secondDiamond, firstDiamondIndex);

            if (firstDiamondIndex != -1 && secondDiamondIndex != -1) {
                newText.replace(firstDiamondIndex, secondDiamondIndex + 1, placeholder);
            }

            int thirdDiamondIndex = newText.indexOf(firstDiamond, secondDiamondIndex);
            int fourthDiamondIndex = newText.indexOf(secondDiamond, thirdDiamondIndex);

            if (thirdDiamondIndex != -1 && fourthDiamondIndex != -1) {
                newText.replace(thirdDiamondIndex, fourthDiamondIndex + 1, placeholder);
            }
        String replaceText = new String(newText);
        return replaceText;
    }

}