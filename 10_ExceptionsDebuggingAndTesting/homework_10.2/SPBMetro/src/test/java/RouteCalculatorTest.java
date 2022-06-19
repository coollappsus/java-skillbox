import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    ArrayList<Station> station;
    ArrayList<Station> connectStation;
    List<Station> route;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {
        station = new ArrayList<>();
        stationIndex = new StationIndex();
        connectStation = new ArrayList<>();

        Line line1 = new Line(1, "Первая фруктовая");
        Line line2 = new Line(2, "Вторая овощная");
        Line line3 = new Line(3, "Третья мясная");
        Line line4 = new Line(4, "Четвертая рыбная");

        station.add(new Station("Ананасовая", line1));
        station.add(new Station("Арбузная", line1));
        station.add(new Station("Гранатовая, переход на линию 4", line1));
        station.add(new Station("Гуавовая", line1));
        station.add(new Station("Джекфруктовая", line1));
        station.add(new Station("Дуриановая", line1));
        station.add(new Station("Картофельная", line2));
        station.add(new Station("Помидорная", line2));
        station.add(new Station("Огуречная, переход на линию 4", line2));
        station.add(new Station("Луковая", line2));
        station.add(new Station("Чесночная", line2));
        station.add(new Station("Свинная", line3));
        station.add(new Station("Говяжья", line3));
        station.add(new Station("Баранья, переход на линию 4", line3));
        station.add(new Station("Куриная", line3));
        station.add(new Station("Кроличья", line3));
        station.add(new Station("Лососёвая, переходи на линию 1", line4));
        station.add(new Station("Икорная", line4));
        station.add(new Station("Форелевая, переход на линию 2", line4));
        station.add(new Station("Щуковая", line4));
        station.add(new Station("Судаковая, переход на линию 3", line4));
        station.add(new Station("Лещёвая", line4));

        //Станции по линиям
        line1.addStation(station.get(0));
        line1.addStation(station.get(1));
        line1.addStation(station.get(2));
        line1.addStation(station.get(3));
        line1.addStation(station.get(4));
        line1.addStation(station.get(5));
        line2.addStation(station.get(6));
        line2.addStation(station.get(7));
        line2.addStation(station.get(8));
        line2.addStation(station.get(9));
        line2.addStation(station.get(10));
        line3.addStation(station.get(11));
        line3.addStation(station.get(12));
        line3.addStation(station.get(13));
        line3.addStation(station.get(14));
        line3.addStation(station.get(15));
        line4.addStation(station.get(16));
        line4.addStation(station.get(17));
        line4.addStation(station.get(18));
        line4.addStation(station.get(19));
        line4.addStation(station.get(20));
        line4.addStation(station.get(21));

        //линии
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addLine(line4);

        //станции
        stationIndex.addStation(station.get(0));
        stationIndex.addStation(station.get(1));
        stationIndex.addStation(station.get(2));//переход на линию 4
        stationIndex.addStation(station.get(3));
        stationIndex.addStation(station.get(4));
        stationIndex.addStation(station.get(5));
        stationIndex.addStation(station.get(6));
        stationIndex.addStation(station.get(7));
        stationIndex.addStation(station.get(8));//переход на линию 4
        stationIndex.addStation(station.get(9));
        stationIndex.addStation(station.get(10));
        stationIndex.addStation(station.get(11));
        stationIndex.addStation(station.get(12));
        stationIndex.addStation(station.get(13));//переход на линию 4
        stationIndex.addStation(station.get(14));
        stationIndex.addStation(station.get(15));
        stationIndex.addStation(station.get(16));//переходи на линию 1
        stationIndex.addStation(station.get(17));
        stationIndex.addStation(station.get(18));//переход на линию 2
        stationIndex.addStation(station.get(19));
        stationIndex.addStation(station.get(20));//переход на линию 3
        stationIndex.addStation(station.get(21));

        //переходы
        connectStation.add(station.get(2));
        connectStation.add(station.get(16));
        stationIndex.addConnection(connectStation);
        connectStation.clear();
        connectStation.add(station.get(8));
        connectStation.add(station.get(18));
        stationIndex.addConnection(connectStation);
        connectStation.clear();
        connectStation.add(station.get(13));
        connectStation.add(station.get(20));
        stationIndex.addConnection(connectStation);
    }

    public void testCalculateDuration(){
        route = new ArrayList<>();
        route.add(stationIndex.getStation("Дуриановая"));
        route.add(stationIndex.getStation("Джекфруктовая"));
        route.add(stationIndex.getStation("Гуавовая"));
        route.add(stationIndex.getStation("Икорная"));

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheLine() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Дуриановая");
        Station to = stationIndex.getStation("Гуавовая");

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        int expected = 3;
        assertEquals(actual.size(), expected);
    }

    public void testGetShortestRouteWithOneConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Дуриановая");
        Station to = stationIndex.getStation("Икорная");

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        int expected = 6;
        assertEquals(actual.size(), expected);
    }

    public void testGetShortestRouteWithTwoConnection() {
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        Station from = stationIndex.getStation("Дуриановая");
        Station to = stationIndex.getStation("Чесночная");

        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        int expected = 10;
        assertEquals(actual.size(), expected);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
