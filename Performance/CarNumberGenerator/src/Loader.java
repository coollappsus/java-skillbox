import java.io.IOException;
import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        StringBuffer carNumber = new StringBuffer();

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        carNumber.append(firstLetter)
                                 .append(padNumber(number, 3))
                                 .append(secondLetter)
                                 .append(thirdLetter)
                                 .append(padNumber(regionCode, 2))
                                 .append("\n");
                    }
                }
            }
        }
        thread(carNumber);
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static StringBuffer padNumber(int number, int numberLength) {
        StringBuffer numberStr = new StringBuffer();
        numberStr.append(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, 0);
        }

        return numberStr;
    }

    private static void thread(StringBuffer carNumber) {
        Runnable task = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    PrintWriter writer = new PrintWriter("res/numbers" + i + ".txt");
                    writer.write(carNumber.toString());
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}
