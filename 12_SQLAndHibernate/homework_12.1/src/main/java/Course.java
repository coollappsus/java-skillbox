import java.util.Collections;
import java.util.List;

public class Course {
    private List<String> name;
    private Integer num;
    private List<Integer> month;
    private Double average;

    public Course(List<String> name, List<Integer> month) {
        this.name = name;
        this.num = month.size();
        this.month = month;
        average = averagePayInMonth(num, month);
    }

    public Double averagePayInMonth(Integer num, List<Integer> month) {
        double firstMonth = month.get(0);
        double lastMonth = month.get(month.size() - 1);
        return num / (lastMonth - (firstMonth - 1));
    }

    @Override
    public String toString() {
            return "Курс \"" + name.get(0) + "\", среднее количество покупок в месяц = " + average;
    }
}