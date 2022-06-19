public class BankAccount {
    private double amount = 0;

    protected double getAmount() {
        System.out.println("Ваш баланс на расчётном счету составляет: " + amount + " руб.");
        return amount;
    }

    protected void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Внесена отрицательная сумма. Внесите положительную сумму");
        } else {
            amount = amount + amountToPut;
            System.out.println("Выполнено!");
        }
    }

    protected void take(double amountToTake) {
        if (amount < amountToTake) {
            System.out.println("Недостаточно денег на расчётном счету");
        } else {
            amount = amount - amountToTake;
            System.out.println("Выполнено!");
        }
    }

    protected boolean send(BankAccount receiver, double amount) {
        double checkSend = this.amount - amount;
        take(amount);
        if (checkSend == this.amount) {
            receiver.put(amount);
            System.out.println("Перевод выполнен успешно!");
            return true;
        } else {
            System.out.println("Перевод не выполнен!");
            return false;
        }
    }
}
