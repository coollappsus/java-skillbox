public class LegalPerson extends Client {

    @Override
    public void take(double amountToTake) {
        if (amountToTake < amount) {
            amount = amount - amountToTake - amountToTake * 0.01;
            System.out.println("Выполнено!");
        } else {
            System.out.println("Недостаточно денег на счету");
        }
    }

    protected void conditions(){
        System.out.println("Вы являетесь юридическим лицом. Пополнение происходит без комиссии, снятие с комиссией 1%");
    }
}
