import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.HOUR, 2);

        List<Terminal> terminals = airport.getTerminals();

        List<Flight> nextFlightTwoHours = terminals.stream().flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> {
            return
                    flight.getDate().before(calendar1.getTime()) &&
                            flight.getDate().after(calendar.getTime()) &&
                            flight.getType() == Flight.Type.DEPARTURE;
        }).collect(Collectors.toList());

        return nextFlightTwoHours;
    }
}