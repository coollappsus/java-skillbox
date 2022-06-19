import java.text.DecimalFormat;

public class Main {
    static private Company company = new Company();
    static private Manager manager = new Manager();
    static private TopManager topManager = new TopManager();
    static private Operator operator = new Operator();
    static private DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void main(String[] args) {


        company.hireAll(80, manager);
        company.hireAll(10, topManager);
        company.hireAll(180, operator);


        for (Employee employee : company.getLowSalaryStaff(30)) {
            System.out.println(employee.getMonthSalary());
        }
    }
}
