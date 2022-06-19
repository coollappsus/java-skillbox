import java.nio.file.Path;

public class Main {

    private static final Path directory = Path.of("/Users/x-cube/Downloads/mongo.csv");

    public static void main(String[] args) {
        Database.collection.drop();
        WorkWithFile.readFile(directory);
        Database.countStudent();
        Database.studentOver40year();
        Database.youngStudent();
        Database.listCoursesOldStudent();
    }
}
