public class Manager implements Employee{

    private final double salary;

    public Manager(){
        int moneyForCompany = (int) (Math.random() * 25000 + 115000);
        int fixSalary = 30000;
        salary = fixSalary + 0.05 * moneyForCompany;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
