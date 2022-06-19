public abstract class Client {
    public double amount = 0;

    public double getAmount() {
        System.out.println("Ваш баланс составляет - " + amount + " руб.");
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount = amount + amountToPut;
            System.out.println("Выполнено!");
        }else {
            System.out.println("Внесена отрицательная сумма. Внесите положительную сумму");
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < amount) {
            amount = amount - amountToTake;
        } else {
            System.out.println("Недостаточно денег на счету");
        }
    }

}
