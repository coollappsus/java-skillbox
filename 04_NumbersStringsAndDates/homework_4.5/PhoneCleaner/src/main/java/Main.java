import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      System.out.println(phoneCleaner(input));
    }
  }

  public static String phoneCleaner(String phone){
    String notFormat = "Неверный формат номера";
    StringBuffer phoneAfterReplace = new StringBuffer(phone.replaceAll("[^0-9]", ""));
    if (phoneAfterReplace.charAt(0) == '8') {
      phoneAfterReplace.replace(0, 1, "7");
    }
    if (phoneAfterReplace.length() == 10) {
      phoneAfterReplace.insert(0, "7");
    }
    if (phoneAfterReplace.charAt(0) == '9' && phoneAfterReplace.length() == 11) {
      return notFormat;
    }
    if (phoneAfterReplace.length() != 11) {
      return notFormat;
    }
    String returnString = phoneAfterReplace.toString();
    return returnString;
  }

}
