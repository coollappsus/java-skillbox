import java.util.Scanner;

public class Controller {
    private final Database database;
    private final Scanner scanner;
    private int productNumber;

    public Controller(Database database, Scanner scanner) {
        this.database = database;
        this.scanner = scanner;
    }

    public void addShop() {
        System.out.println("Введите название магазина:");
        String shopName = scanner.nextLine().toUpperCase().trim();
        database.addShop(shopName);
        System.out.println("Магазин " + "\"" + shopName + "\"" + " добавлен");
    }

    public void addProduct() {
        System.out.println("Введите название товара:");
        String productName = scanner.nextLine().toUpperCase().trim();
        System.out.println("Введите цену товара:");
        int productPrice = scanner.nextInt();
        System.out.println("Вы можете добавить описание товара:");
        scanner.nextLine();
        String productDescription = scanner.nextLine();

        int thisProductNumber = ++productNumber;
        database.addProduct(thisProductNumber, productName, productPrice, productDescription);
        String confirmation = "Товар " + "\"" + productName + "\"" + " добавлен: "
                + "\nНомер в каталоге: " + thisProductNumber
                + "\nЦена: " + productPrice
                + "\nОписание: " + productDescription;
        System.out.println(confirmation);
    }

    public void addProductToShop() {
        System.out.println("Введите номер товара по каталогу:");
        int productNumber = scanner.nextInt();
        System.out.println("Введите название магазина:");
        scanner.nextLine();
        String shopName = scanner.nextLine().toUpperCase().trim();
        database.addProductToShop(productNumber, shopName);
    }

    public void showStatistics() {
        showStatisticsLabel();
        String confirmation = scanner.nextLine();
        switch (confirmation) {
            case "1" -> database.getProductsCount();
            case "2" -> database.getAveragePrice();
            case "3" -> database.getCheapestItem();
            case "4" -> database.getMostExpensiveItem();
            case "5" -> {
                System.out.println("Дешевле какой суммы вам нужно сосчитать количество продуктов в магазине? " +
                        "Введите значение:");
                long value = scanner.nextLong();
                database.getProductsCountLessThan(value);
            }
            default -> {
                System.out.println("Выберите один из преложенных выраиантов ниже, введите цифру\n");
                showStatistics();
            }
        }
    }

    public void showStatisticsLabel() {
        System.out.println("""
                Какую статистику вы хотите увидеть?
                1. Количество выставленных товаров в магазинах.
                2. Средняя цена товаров в магазине.
                3. Самый дешевый товар в магазине.
                4. Самый дорогой товар в магазине.
                5. Количество товаров дешевле Х рублей.
                """);
    }
}
