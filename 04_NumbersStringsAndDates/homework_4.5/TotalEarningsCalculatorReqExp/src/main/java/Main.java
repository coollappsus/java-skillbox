import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Введите текст. Будут подсчитаны все числа во введённой строке.\nЛибо введите 0 для выхода.");
      String text = scanner.nextLine();

      if (text.equals("0")) {
        break;
      }
      System.out.println(calculateSalarySum(text));
    }
  }

    public static int calculateSalarySum (String text){
    int sum = 0;
    String newTextAfterReplace = text.replaceAll("[^0-9]", " ");
    String[] newTextAfterSplit = newTextAfterReplace.split("\\s+");
      for (int i = 1; i < newTextAfterSplit.length; i++) {
      sum += Integer.parseInt(newTextAfterSplit[i]);
      }
    return sum;
    }
}