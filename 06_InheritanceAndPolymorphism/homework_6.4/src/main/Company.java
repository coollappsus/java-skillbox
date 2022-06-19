import java.util.*;

public class Company {
    private ArrayList<Employee> employeeList;
    private final double income;

    protected Company() {
        income = (Math.random() * 5000000) + 8000000;
        employeeList = new ArrayList<>();
    }

    protected void hire(Employee type) {
        employeeList.add(type);
    }

    protected void hireAll(int count, Employee type) {
        if (count > 0) {
            for (int i = 0; i < count; i++){
                employeeList.add(type);
            }
        }else {
            System.out.println("Введено несуществующее количество");
        }
    }

    protected void fire(int count, Employee type) {
        if (count > 0) {
            for(int i = 0; i < count; i++) {
                employeeList.remove(type);
            }
        }else {
            System.out.println("Введено несуществующее количество");
        }
    }

    protected double getIncome(){
        return income;
    }

    protected List<Employee> getTopSalaryStaff(int count) {
        Comparator<Employee> comparator = (o1, o2) -> {
            if (o1.getMonthSalary() > o2.getMonthSalary()) {
                return -1;
            }
            if (o1.getMonthSalary() < o2.getMonthSalary()) {
                return 1;
            }
            return 0;
        };
        ArrayList<Employee> topSalaryStaff = new ArrayList<>(employeeList);
        topSalaryStaff.sort(comparator);
        return topSalaryStaff.subList(0, count);
    }

    protected List<Employee> getLowSalaryStaff(int count) {
        Comparator<Employee> comparator = (o1, o2) -> {
            if (o1.getMonthSalary() > o2.getMonthSalary()) {
                return 1;
            }
            if (o1.getMonthSalary() < o2.getMonthSalary()) {
                return -1;
            }
            return 0;
        };
        ArrayList<Employee> lowSalaryStaff = new ArrayList<>(employeeList);
        lowSalaryStaff.sort(comparator);
        return lowSalaryStaff.subList(0, count);
    }
}
