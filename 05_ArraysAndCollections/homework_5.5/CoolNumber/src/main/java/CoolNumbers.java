import java.util.*;

public class CoolNumbers {
    public static ArrayList<String> coolNumbers = new ArrayList<>();
    public static HashSet<String> coolNumbersHashSet = new HashSet<>();
    public static TreeSet<String> coolNumbersTreeSet = new TreeSet<>();

    public static List<String> generateCoolNumbers() {
        String[] chars = new String[]{"А", "В","Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        String number;

        for (int i = 0; i < 1000000; i++) {
            for (int j = 1; j < 10; j++) {
                int regionNumber = (int) (Math.random() * 198) + 1;
                String region = Integer.toString(regionNumber);
                if (region.length() == 1) {
                    region = 0 + region;
                }
                number = chars[(int) Math.round(Math.random() * 11)] + j + j + j +
                        chars[(int) Math.round(Math.random() * 11)] +
                        chars[(int) Math.round(Math.random() * 11)] + region;
                coolNumbers.add(number);
                coolNumbersHashSet.add(number);
                coolNumbersTreeSet.add(number);
            }
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
