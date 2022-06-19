import com.skillbox.airport.Airport;

public class Main {
    public static int p;

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        p = airport.getAllAircrafts().size();
        System.out.println("Количество самолётов - " + p);
    }
}
