public class Operator implements Employee{

    private final double salary;

    public Operator() {
        salary = 40000;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
