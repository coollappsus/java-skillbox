import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    char space = ' ';

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();

      if (input.equals("0")) {
        break;
      }

      int length = input.length();
      int indexSpace = input.indexOf(space);
      int secondIndexSpace = input.indexOf(space, indexSpace + 1);
      int lastIndexSpace = input.lastIndexOf(space);

      if (indexSpace == -1 || indexSpace == secondIndexSpace || secondIndexSpace != lastIndexSpace) {
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      String surName = input.substring(0, indexSpace);
      String name = input.substring(indexSpace + 1, secondIndexSpace);
      String middleName = input.substring(secondIndexSpace + 1, length);

      if (checkString(surName, name, middleName)) {
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      System.out.println("Фамилия: " + surName + "\n" + "Имя: " + name + "\n" + "Отчество: " + middleName);
    }
  }

  public static boolean checkString(String surName, String name, String middleName) {
    for (int i = 0; i < 10; i++) {
      return (surName.indexOf(i) != -1 || name.indexOf(i) != -1 || middleName.indexOf(i) != -1);
    }
    return true;
  }

}