public class CardAccount extends BankAccount {
    private double cardAmount = 0;

    @Override
    protected double getAmount() {
        System.out.println("Ваш баланс по карте составляет " + cardAmount + " руб.");
        return cardAmount;
    }

    @Override
    protected void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Внесена отрицательная сумма. Внесите положительную сумму");
        } else {
            cardAmount = cardAmount + amountToPut;
            System.out.println("Выполнено!");
        }
    }

    @Override
    protected void take(double amountToTake) {
        if (cardAmount < amountToTake) {
            System.out.println("Недостаточно денег на карте!");
        } else {
            cardAmount = cardAmount - (amountToTake * 0.01 + amountToTake);
            System.out.println("Выполнено!");
        }
    }
}
