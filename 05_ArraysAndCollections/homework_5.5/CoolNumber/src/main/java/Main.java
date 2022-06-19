import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
//    public static HashSet<String> coolNumbersHashSet = new HashSet<>(CoolNumbers.coolNumbers);
//    public static TreeSet<String> coolNumbersTreeSet = new TreeSet<>(CoolNumbers.coolNumbers);

    public static void main(String[] args) {
        CoolNumbers.generateCoolNumbers();
        String search = "номер не найден";
        System.out.println("Введите гос.номер");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        long start = System.nanoTime();
        boolean bruteForceSearchInList = CoolNumbers.bruteForceSearchInList(CoolNumbers.coolNumbers, number);
        long end = System.nanoTime();
        if (bruteForceSearchInList) {
            search = "номер найден";
        }
        System.out.println("Поиск перебором: " + search + ", поиск занял " + (end - start) + "нс");
        search = "номер не найден";

        Collections.sort(CoolNumbers.coolNumbers);
        start = System.nanoTime();
        boolean binarySearchInList = CoolNumbers.binarySearchInList(CoolNumbers.coolNumbers, number);
        end = System.nanoTime();
        if (binarySearchInList) {
            search = "номер найден";
        }
        System.out.println("Бинарный поиск: " + search + ", поиск занял " + (end - start) + "нс");
        search = "номер не найден";

        start = System.nanoTime();
        boolean searchInHashSet = CoolNumbers.searchInHashSet(CoolNumbers.coolNumbersHashSet, number);
        end = System.nanoTime();
        if (searchInHashSet) {
            search = "номер найден";
        }
        System.out.println("Поиск в HashSet: " + search + ", поиск занял " + (end - start) + "нс");
        search = "номер не найден";

        start = System.nanoTime();
        boolean searchInTreeSet = CoolNumbers.searchInTreeSet(CoolNumbers.coolNumbersTreeSet, number);
        end = System.nanoTime();
        if (searchInTreeSet) {
            search = "номер найден";
        }
        System.out.println("Поиск в TreeSet: " + search + ", поиск занял " + (end - start) + "нс");
    }
}
