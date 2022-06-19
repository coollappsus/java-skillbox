import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(database, scanner);


        System.out.println("Введите команду или \"HELP\" ");
        while (true) {
            String input = scanner.nextLine().trim();
            switch (input.toUpperCase()) {
                case "HELP" -> System.out.println("""
                        * Введите команду из списка ниже, затем следуйте инструкциям:
                        + "ДОБАВИТЬ_МАГАЗИН" или "ADD_SHOP" - добавление магазина в базу данных
                        + "ДОБАВИТЬ_ТОВАР" или "ADD_PRODUCT" - добавление товара на склад
                        + "ВЫСТАВИТЬ_ТОВАР" или "PLACE_PRODUCT" - выставляем товар со склада в магазин
                        + "СТАТИСТИКА" - показать статистику по товарам
                        """);
                case "ДОБАВИТЬ_МАГАЗИН" -> controller.addShop();
                case "ДОБАВИТЬ_ТОВАР" -> controller.addProduct();
                case "ВЫСТАВИТЬ_ТОВАР" -> controller.addProductToShop();
                case "СТАТИСТИКА" -> controller.showStatistics();
                case "RESET" -> database.resetDataBase();
            }
        }
    }
}
