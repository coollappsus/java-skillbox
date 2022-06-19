import org.json.simple.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    private static Elements nameOfLine;
    private static Elements lineStations;
    private static JSONObject jsonObjectGeneral = new JSONObject();


    public static void main(String[] args) {
        try {
            File file = new File("data/", "map.json");
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            createNewJsonStation(doc);
            createNewJsonLine(doc);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void createNewJsonStation(Document doc) {
        try {
            FileWriter fileWriter = new FileWriter("data/map.json");
            JSONObject jsonObjectStation = new JSONObject();
            lineStations = doc.select("div#metrodata").select("div.js-metro-stations");

                lineStations.forEach(element -> {
                    String number = element.attr("data-line");
                    JSONArray jsonArray = new JSONArray();
                    element.childNodes().forEach(node -> {
                        String name = ((Element) node).select("span.name").text();
                        jsonArray.add(name);
                    });
                    jsonObjectStation.put(number, jsonArray);
                    System.out.println("Номер линии " + number + ":" + " Количество станций - " + jsonArray.size());
                });
            jsonObjectGeneral.put(NameOfMetroAttributes.STATIONS, jsonObjectStation);
            fileWriter.write(jsonObjectGeneral.toJSONString());
            fileWriter.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void createNewJsonLine(Document doc) {
        try {
            FileWriter fileWriter = new FileWriter("data/map.json");
            JSONArray jsonArrayLines = new JSONArray();
            nameOfLine = doc.select("div#metrodata").select("span.js-metro-line");
            nameOfLine.forEach(element -> {
                String number = element.attr("data-line");
                String nameLine = element.select("span").text();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(NameOfMetroAttributes.NAME, nameLine);
                jsonObject.put(NameOfMetroAttributes.NUMBER, number);
                jsonArrayLines.add(jsonObject);
            });
            jsonObjectGeneral.put(NameOfMetroAttributes.LINES, jsonArrayLines);
            fileWriter.write(jsonObjectGeneral.toJSONString());
            fileWriter.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
