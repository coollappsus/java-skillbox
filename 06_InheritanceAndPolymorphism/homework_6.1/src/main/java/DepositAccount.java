import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private double depositAmount = 0;
    private LocalDate lastIncome;

    @Override
    protected double getAmount() {
        System.out.println("Ваш баланс депозитного счёта составляет " + depositAmount + " руб.");
        return depositAmount;
    }

    @Override
    protected void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Внесена отрицательная сумма. Внесите положительную сумму");
        } else {
            depositAmount = depositAmount + amountToPut;
            lastIncome = LocalDate.now();
            System.out.println("Выполнено!");
        }
    }

    @Override
    protected void take(double amountToTake) {
        if (depositAmount < amountToTake) {
            System.out.println("Недостаточно денег на расчётном счету");
        } else {
            if (isMonthAgo(lastIncome)) {
                depositAmount = depositAmount - amountToTake;
                System.out.println("Выполнено!");
            } else {
                System.out.println("Денежные средства вносились менее месяца назад");
            }
        }
    }

    private boolean isMonthAgo(LocalDate lastIncome) {
        LocalDate monthAgo = lastIncome.plusMonths(1);
        return LocalDate.now().isAfter(monthAgo);
    }
}
