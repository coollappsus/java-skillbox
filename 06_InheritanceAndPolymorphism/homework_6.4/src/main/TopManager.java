public class TopManager implements Employee{

    private double salary;

    public TopManager() {
        int fixSalary = 50000;
        if (company.getIncome() > 10000000.0) {
            salary = fixSalary + fixSalary * 1.5;
        }
        if (company.getIncome() < 10000000.0){
            salary = fixSalary;
        }
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
