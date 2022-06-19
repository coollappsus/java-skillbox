public class IndividualBusinessman extends Client {

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0 && amountToPut < 1000) {
            amount = amount + (amountToPut - amountToPut * 0.01);
            System.out.println("Выполнено!");
        }
        if (amountToPut > 0 && amountToPut >= 1000) {
            amount = amount + (amountToPut - amountToPut * 0.005);
            System.out.println("Выполнено!");
        }
    }

    protected void conditions(){
        System.out.println("Вы являетесь индивидуальным предпринимателем. Снятие происходит без комиссии. " +
                "Условия пополнения:\n-Сумма пополнения менее 1000 рублей, комиссия 1%\n-Сумма пополнения 1000 рублей" +
                "и более, комиссия 0,5%");
    }
}
