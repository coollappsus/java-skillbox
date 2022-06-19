import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path){
        long size = 0;
        try(Stream<Path> walk = Files.walk(Path.of(path))) {
            size = walk.filter(Files::isRegularFile).mapToLong(p -> {
                try {
                    return Files.size(p);
                }
                catch (IOException e) {
                    System.out.println("Невозможно получить размер файла");
                    return 0L;
                }
            }).sum();
        }
        catch (IOException e) {
            System.out.println("Ошибка при подсчёте размера директории");;
        }
        return size;
    }
}
