import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriting {

    private static final String MAP_NAME = "data/sitemap.txt";

    public void write (List<String> results) {
        try {
            Files.deleteIfExists(Path.of(MAP_NAME));
            Files.write(Path.of(MAP_NAME),results, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
