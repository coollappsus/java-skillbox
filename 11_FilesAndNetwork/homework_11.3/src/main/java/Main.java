import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String path = "src/test/resources/movementList.csv";
    private static Movements movements = new Movements(path);

    public static void main(String[] args) {
        System.out.println("Сумма расходов: " + movements.getExpenseSum()
                + "\nСумма дохода: "  + movements.getIncomeSum()
                + "\n\tСуммы расходов по организациям:");
        movements.ExpenseGroupedByOrganization();
        for (Map.Entry<String, Double> entry: movements.expenseByOrg.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

//        movements.ExpenseGroupedByOrganization();
    }
}
