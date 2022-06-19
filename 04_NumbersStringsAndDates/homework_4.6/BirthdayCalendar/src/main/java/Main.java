import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 4;
        int month = 11;
        int year = 1995;

            System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.US);
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        Date testDate = new Date();
        String returnString = "";

        for (int i = 0; i < 1000; i++) {
            Date date = calendar.getTime();
            if (testDate.before(date)){
                break;
            }
            returnString += i  + " - " + dateFormat.format(date) + "\n";
            calendar.add(Calendar.YEAR, 1);
        }
        return returnString;
    }
}
