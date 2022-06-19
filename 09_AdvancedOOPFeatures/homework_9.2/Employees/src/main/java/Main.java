import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Optional optional = staff.stream().sorted(Comparator.comparing(Employee::getWorkStart)).
                        filter(employee -> LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").
                        format(employee.getWorkStart())).getYear() == year).
                        max(Comparator.comparing(Employee::getSalary));
        return (Employee) optional.get();
    }
}