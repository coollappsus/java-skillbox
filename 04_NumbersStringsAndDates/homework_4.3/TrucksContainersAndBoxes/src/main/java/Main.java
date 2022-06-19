import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringBoxes = scanner.nextLine();

        final double CAPACITY_CONTAINERS = 27;
        final double CAPACITY_TRACKS = 12;

        double realBoxes = Double.parseDouble(stringBoxes);
        double realContainers = Math.ceil(realBoxes / CAPACITY_CONTAINERS);
        double realTrucks = Math.ceil(realContainers / CAPACITY_TRACKS);

        int testTrucks = 0;
        int testContainers = 0;
        int testBoxes = 0;

        if(realBoxes > 0) {
            testTrucks++;
            testContainers++;
            System.out.println("Грузовик: " + testTrucks);
            System.out.println("\tКонтейнер: " + testContainers);
        }

        while(realTrucks > 0) {
            testBoxes++;
            System.out.println("\t\tЯщик: " + testBoxes);

            if (testBoxes >= realBoxes) {
                break;
            }

            if(testBoxes % (CAPACITY_TRACKS * CAPACITY_CONTAINERS) == 0) {
                testTrucks++;
                System.out.println("Грузовик: " + testTrucks);
            }
            if(testBoxes % CAPACITY_CONTAINERS == 0) {
                testContainers++;
                System.out.println("\tКонтейнер: " + testContainers);
            }
        }

        System.out.println("Необходимо:\nгрузовиков - " + testTrucks + " шт.\nконтейнеров - " + testContainers + " шт.");

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }
}