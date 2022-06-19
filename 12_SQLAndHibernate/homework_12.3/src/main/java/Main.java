import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        Session session = connection.openSession(connection.createSessionFactory());
        Transaction transaction = connection.openTransaction(session);

        Course course = session.get(Course.class, 3);
        System.out.println("Name of course \"" + course.getName() + "\", count student - " +
                course.getStudentsCount());
        System.out.println("Teacher of course - " + course.getTeacher().getName());
        Subscription subscription = session.get(Subscription.class, new Key(1, 2));

        List<PurchaseList> purchaseLists = session.createCriteria(PurchaseList.class).list();

//        PurchaseList purchaseList = session
//                .get(PurchaseList.class, new PurchaseListKey(subscription.getStudent().getName(),
//                        subscription.getCourse().getName()));
        purchaseLists.forEach(System.out::println);

        connection.closeTransaction(transaction);
        connection.closeSession(session);
    }
}
