import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {

    //private static final String URL_NAME = "https://lenta.ru/";
    private static final String URL_NAME = "https://skillbox.ru";

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();

        CopyOnWriteArrayList workedLink = new CopyOnWriteArrayList();
        workedLink.add(URL_NAME);
        Connect processor = new Connect(URL_NAME,0, workedLink);
        pool.execute(processor);
        pool.shutdown();

        processor.join();
        List<String> results = processor.getWorkedLinks();
        results.forEach(System.out::println);

        FileWriting fileWriting = new FileWriting();
        fileWriting.write(results);

        long end = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (end - start));
    }
}
