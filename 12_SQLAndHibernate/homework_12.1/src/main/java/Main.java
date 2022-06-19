import java.sql.*;
import java.util.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/skillbox?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "9511040801";
    private static Course course;
    private static List<String> nameCourses = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSetNameOfCourses = statement.executeQuery("SELECT name FROM Courses");
            while (resultSetNameOfCourses.next()) {
                nameCourses.add(resultSetNameOfCourses.getNString("name"));
            }
            for (int i = 0; i < nameCourses.size(); i++) {
                List<String> name = new ArrayList<>();
                List<Integer> counterMonth = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery(
                                "SELECT pl.course_name, pl.subscription_date, " +
                                "MONTH(pl.subscription_date) AS month " +
                                "FROM PurchaseList pl " +
                                "WHERE pl.course_name = \"" + nameCourses.get(i) + "\" " +
                                "ORDER BY pl.subscription_date");
                while (resultSet.next()) {
                    name.add(resultSet.getNString("pl.course_name"));
                    counterMonth.add(resultSet.getInt("month"));
                }
                if (!counterMonth.isEmpty()) {
                    course = new Course(name, counterMonth);
                    System.out.println(course);
                } else {
                    System.out.println("Курс \"" + nameCourses.get(i) + "\" ни разу " +
                            "не покупался");
                }
            }
            connection.close();
            statement.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
