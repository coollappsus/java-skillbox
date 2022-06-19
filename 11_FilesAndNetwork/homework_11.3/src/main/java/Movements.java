import java.util.*;
import java.util.stream.Collectors;

public class Movements {
    List<Transaction> transactionList;
    TreeMap<String, Double> expenseByOrg = new TreeMap<>(Comparator.reverseOrder());

    public Movements(String pathMovementsCsv) {
        transactionList = Transaction.loadTransactionFromFile(pathMovementsCsv);
    }

    public double getExpenseSum() {
        double expenseSum = 0;
        for (Transaction transaction : transactionList) {
            expenseSum += transaction.getExpense();
        }
        return expenseSum;
    }

    public double getIncomeSum() {
        double incomeSum = 0;
        for (Transaction transaction: transactionList) {
            incomeSum += transaction.getIncome();
        }
        return incomeSum;
    }

    public TreeMap<String, Double> ExpenseGroupedByOrganization() {
        if (transactionList.isEmpty()) {
            System.out.println("Transaction list is empty :(");
            return null;
        }

        transactionList.stream().filter(t -> t.getExpense() != 0)
                .collect(Collectors.groupingBy(Transaction::getName))
                .forEach(((s, t) -> {
                    double sum = 0;
                    for (Transaction transaction: t) {
                        sum += transaction.getExpense();
                    }
                    expenseByOrg.put(s, sum);
                }));
        return expenseByOrg;
    }

}
