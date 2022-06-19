import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.function.Consumer;

public class Database {
    private static final MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
    private static final MongoDatabase database = mongoClient.getDatabase("local");

    public static MongoCollection<Document> collection = database.getCollection("Student");

    public static void countStudent() {
        System.out.println("Общее количество студентов в базе - " + collection.countDocuments());
    }

    public static void studentOver40year() {
        BsonDocument query = BsonDocument.parse("{year: {$gte: '40'}}");
        System.out.println("Общее количество студентов в базе, которым больше 40 лет - " +
                collection.countDocuments(query));
    }

    public static void youngStudent() {
        Document documentSort = new Document().append("year", 1);
        collection.find().sort(documentSort).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println("Имя самого молодого студента - " + document.get("name"));
        });
    }

    public static void listCoursesOldStudent() {
        Document documentSort = new Document().append("year", -1);
        collection.find().sort(documentSort).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println("Курсы самого старого студента - " + document.get("courses"));
        });
    }
}
