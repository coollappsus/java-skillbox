import java.nio.file.Path;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {
            org.apache.commons.io.FileUtils
                    .copyDirectory(Path.of(sourceDirectory).toFile(), Path.of(destinationDirectory).toFile());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
