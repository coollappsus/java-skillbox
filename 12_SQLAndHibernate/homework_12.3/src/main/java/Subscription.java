import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    private Key id;
    private Date subscriptionDate;
    private Student student;
    private Course course;

    @EmbeddedId
    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    @Column(name = "subscription_date", columnDefinition = "datetime")
    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
