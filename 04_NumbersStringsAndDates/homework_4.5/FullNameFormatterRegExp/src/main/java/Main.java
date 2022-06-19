import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      String newTextAfterReplace = input.replaceAll("[^А-яА-Я \\-]", "");
      String[] newTextAfterSplit = newTextAfterReplace.split("\\s+");

      if (newTextAfterSplit.length != 3) {
        System.out.println("Введенная строка не является ФИО");
        continue;
      }

      String surName = newTextAfterSplit[0];
      String name = newTextAfterSplit[1];
      String middleName = newTextAfterSplit[2];

      System.out.println("Фамилия: " + surName + "\n" + "Имя: " + name + "\n" + "Отчество: " + middleName);
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
    }
  }

}