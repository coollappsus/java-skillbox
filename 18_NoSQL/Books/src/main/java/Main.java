import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;

import java.util.function.Consumer;

public class Main {
    public static MongoClient mongoClient = new MongoClient( "127.0.0.1" , 27017 );
    public static MongoDatabase database = mongoClient.getDatabase("local");

    public static MongoCollection<Document> collection = database.getCollection("Books");

    public static void main(String[] args) {
        collection.drop();

        CreateDocuments.create();

        BsonDocument query = BsonDocument.parse("{nameAuthor: 'J. K. Rowling'}");
        collection.find(query).forEach((Consumer<Document>) document -> {
            System.out.println("Книга с автором J. K. Rowling:\n" + document);
        });

        Document documentSort = new Document().append("year", 1);
        collection.find().sort(documentSort).limit(1).forEach((Consumer<Document>) document -> {
            System.out.println("\n\nСамая старая книга:\n" + document);
        });

    }
}
