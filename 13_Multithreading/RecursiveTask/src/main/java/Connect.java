import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

public class Connect extends RecursiveTask<List<String>> implements Node {

    private final String url;

    private final int level;

    private final CopyOnWriteArrayList workedLinks;

    private Document doc = null;


    public Connect(String url, int level, CopyOnWriteArrayList workedLinks) {
        this.url = url;
        this.level = level;
        this.workedLinks = workedLinks;
    }

    public CopyOnWriteArrayList getWorkedLinks() {
        return workedLinks;
    }

    @Override
    public List<String> getChildren() {
        Set<String> linksStr = new HashSet<>();

        try {
            Thread.sleep(150);
            doc = Jsoup.connect(url).get();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }

        if (doc != null) {
            Elements links = doc.select("a[href]"); // a with href

            links.forEach(element -> {
                String link = element.attr("abs:href");
                if (link.contains("courses")) {
                    link = link;
                }
                //if (link.matches(url + ".+[/]$") && (!link.equals(url)) && (!link.contains("#"))) {
                if (link.matches(url + ".+") && (!link.equals(url)) && (!link.contains("#"))) {
                    linksStr.add(link);
                }
            });
        }
        return new ArrayList<>(linksStr);
    }

    @Override
    public String getValue(String link) {
        String tabulation = "\t";
        for (int i = 0; i < level; i++) {
            tabulation += "\t";
        }
        return tabulation + link;
    }

    @Override
    protected List<String> compute() {
        ArrayList<String> linksList = new ArrayList<>();

        List<Connect> tasks = new ArrayList<>();

        List<String> links = getChildren();
        for (String link :links)
        {
            String tabulationLink = getValue(link);

            if(!linksList.contains(tabulationLink) && !workedLinks.contains(tabulationLink)){
                linksList.add(tabulationLink);
                workedLinks.add(tabulationLink);
                Connect task = new Connect(link, level + 1, workedLinks);
                task.invoke();
                tasks.add(task);

                System.out.println("Запущено заданий: " + tasks.size() + " обработка url: " + url + " link: " + link);

            }
        }
        return linksList;
    }
}
