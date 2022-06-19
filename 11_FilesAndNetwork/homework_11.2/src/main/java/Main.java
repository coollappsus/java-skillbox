import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String WELCOME_MESSAGE = "Добро пожаловать!\n" +
            "Введите путь к папке, которую необходимо скопировать:";
    private static final String SECOND_MESSAGE = "Введите путь, куда необходимо скопировать папку:";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WELCOME_MESSAGE);
        String sourceDirectory = scanner.nextLine();
        System.out.println(SECOND_MESSAGE);
        String destinationDirectory = scanner.nextLine();
        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
