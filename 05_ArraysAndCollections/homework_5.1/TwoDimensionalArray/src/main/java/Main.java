import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int size = scanner.nextInt();
            if (size == 0) {
                break;
            }
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив

            char[][] krest = TwoDimensionalArray.getTwoDimensionalArray(size);

            for (int i = 0; i < krest.length; i++) {
                for (int j = 0; j < krest[0].length; j++) {
                    System.out.print(krest[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
