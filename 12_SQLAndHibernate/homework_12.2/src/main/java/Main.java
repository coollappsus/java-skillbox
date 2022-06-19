import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        Session session = connection.openSession(connection.createSessionFactory());

        Course course = session.get(Course.class, 3);
        System.out.println("Назвение курса \"" + course.getName() + "\", количество студентов - " +
                course.getStudentsCount());

        connection.closeSession(session);
    }
}
