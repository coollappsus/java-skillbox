import java.io.File;

public class Main {
    private static final int newWidth = 300;
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String srcFolder = "/Users/X-cube/Documents/Learning/Module4/java_basics/13_Multithreading/ImageResizer/data/src";
        String dstFolder = "/Users/X-cube/Documents/Learning/Module4/java_basics/13_Multithreading/ImageResizer/data/dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int processorsCount = Runtime.getRuntime().availableProcessors();
        int partOfFolder = (files.length / processorsCount) / 2;
        int startArray = 0;
        for (int i = 0; i < processorsCount; i++) {
            File[] files1 = new File[partOfFolder];
            System.arraycopy(files, startArray, files1, 0, files1.length);
            ImageResizer imageResizer = new ImageResizer(files1, newWidth, dstFolder, start);
            startArray = startArray + partOfFolder;
            imageResizer.start();
        }
    }
}
