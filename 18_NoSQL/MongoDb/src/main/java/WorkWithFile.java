import org.bson.Document;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkWithFile {

    public static List readFile(Path path) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        for (int i = 0; i < 99; i++) {
            List<String> onePerson = Arrays.stream(lines.get(i).split(",")).toList();
            newDoc(onePerson);
        }
        return lines;
    }

    public static void newDoc(List onePerson) {
        String courses = null;
        switch (onePerson.size()) {
            case 5 -> courses = onePerson.get(2).toString() + ", " +
                        onePerson.get(3).toString() + ", " +
                        onePerson.get(4).toString();
            case 4 -> courses = onePerson.get(2).toString() + ", " +
                        onePerson.get(3).toString();
            case 3 -> courses = onePerson.get(2).toString();
            default -> System.out.println("Что-то пошло не так");
        }
        Document document = new Document()
                .append("name", onePerson.get(0))
                .append("year", onePerson.get(1))
                .append("courses", courses.substring(1, courses.length() - 1));
        Database.collection.insertOne(document);
    }
}
