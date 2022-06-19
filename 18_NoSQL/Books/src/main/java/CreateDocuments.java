import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class CreateDocuments {

    public static void create() {
        Document firstDocument = new Document()
                .append("name", "The Lord of the Rings")
                .append("nameAuthor", "J. R. R. Tolkien")
                .append("year", 1954);
        Main.collection.insertOne(firstDocument);

        Document secondDocument = new Document()
                .append("name", "Pride and Prejudice")
                .append("nameAuthor", "Jane Austen")
                .append("year", 1813);
        Main.collection.insertOne(secondDocument);

        Document thirdDocument = new Document()
                .append("name", "His Dark Materials")
                .append("nameAuthor", "Philip Pullman")
                .append("year", 1995);
        Main.collection.insertOne(thirdDocument);

        Document fourthDocument = new Document()
                .append("name", "Harry Potter and the Goblet of Fire")
                .append("nameAuthor", "J. K. Rowling")
                .append("year", 2000);
        Main.collection.insertOne(fourthDocument);

        Document fifthDocument = new Document()
                .append("name", "Harry Potter and the Order of the Phoenix")
                .append("nameAuthor", "J. K. Rowling")
                .append("year", 2003);
        Main.collection.insertOne(fifthDocument);
    }
}
