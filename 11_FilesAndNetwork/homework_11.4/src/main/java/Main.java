import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        parseFile();
    }

    private static void parseFile() {
        try {
            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements links = doc.select("img");
            links.forEach(element -> {
                try {
                    String urlString = element.absUrl("src");
                    URL url = new URL(urlString);
                    int indexof = urlString.lastIndexOf("/");
                    String pathName = "images/" + urlString.substring(indexof + 1);
                    FileUtils.copyURLToFile(url, new File(pathName));
                    System.out.println("Файл создан: " + pathName);
                } catch (Exception ex) {
                    System.out.println("Что-то пошло не так: " + ex);
                    ex.printStackTrace();
                }
            });
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так: " + ex);
            ex.printStackTrace();
        }
    }
}
