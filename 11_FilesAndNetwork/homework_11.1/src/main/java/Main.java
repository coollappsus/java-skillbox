import java.util.Scanner;

public class Main {
    private static final String WELCOME_MESSAGE = "Добро пожаловать!\nВведите путь к файлу:";
    private static final int DIVISOR = 1024;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        long longSize = FileUtils.calculateFolderSize(path);
        String size = conversationSize(longSize);
        System.out.println(size);
    }

    private static String conversationSize(long longSize) {
        String size = "";
        int i = 0;

        while (true) {
            if (longSize < DIVISOR) {
                break;
            }
            longSize = longSize / DIVISOR;
            i++;
        }

        switch (i){
            case(0):
                size = Long.toString(longSize) + " байт";
                break;
            case(1):
                size = Long.toString(longSize) + " Килобайт";
                break;
            case(2):
                size = Long.toString(longSize) + " Мегабайт";
                break;
            case(3):
                size = Long.toString(longSize) + " Гигабайт";
                break;
            case(4):
                size = Long.toString(longSize) + " Терабайт";
                break;
            default:
                System.out.println("Что-то пошло не так :(");
        }
        return size;
    }
}
