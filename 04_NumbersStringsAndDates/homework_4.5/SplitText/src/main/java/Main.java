import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Введите текст. Будут распечатаны все слова на отдельной строчке.\nЛибо введите 0 для выхода.");
      String text = scanner.nextLine();

      if (text.equals("0")) {
        break;
      }
      System.out.println(splitTextInToWords(text));
    }
  }

  public static String splitTextInToWords(String text) {
    String newTextAfterReplace = text.replaceAll("([^A-Za-z’])", " ");
    String returnText = newTextAfterReplace.replaceAll("\\s+\\b", "\n");
    if (text.length() > 0) {
      returnText = returnText.substring(0, returnText.length() - 1);
    }
    return returnText;
  }

}