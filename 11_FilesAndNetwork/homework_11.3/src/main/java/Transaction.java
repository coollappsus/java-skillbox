import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private String name;
    private double income;
    private double expense;

    public Transaction(String name, double income, double expense) {
        this.name = name;
        this.income = income;
        this.expense = expense;
    }

    public static List<Transaction> loadTransactionFromFile(String path) {
        List<Transaction> transactionList = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (int i = 1; i < lines.size(); i++) {
                String[] fragments = lines.get(i).split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*(?![^\\\"]*\\\"))");
                String[] name = fragments[5].split("\\s{2}");
                int str;
                str = name[3].lastIndexOf("\\");
                if (str == -1) {
                    str = 0;
                }
                if (!name[3].isEmpty()) {
                    name[3] = name[3].substring(str + 1);
                }
                transactionList.add(new Transaction(
                        name[3],
                        Double.parseDouble(fragments[6].replaceAll(",", ".")
                                .replaceAll("\"", "").trim()),
                        Double.parseDouble(fragments[7].replaceAll(",", ".")
                                .replaceAll("\"", "").trim())
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return transactionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
