
public class Loader {
    public static void main(String[] args) {
        //Создаём 6 кошек
        Cat Murka = new Cat();
        Cat Tisha = new Cat();
        Cat Zima = new Cat();
        Cat Barsik = new Cat();
        Cat Tima = new Cat();
        Cat Tayson = new Cat();

        /////////////TEST FOR LESSON 7///////////////
        Murka.setColorCat(Color.TABBY);
        Murka.setName("Мурка");
        Cat.copyCat(Murka);
        /////////////TEST FOR LESSON 7///////////////

        //Выводим их вес
        System.out.println("Вес Мурки - " + Murka.getWeight());
        System.out.println("Вес Тиши - " + Tisha.getWeight());
        System.out.println("Вес Зимы - " + Zima.getWeight());
        System.out.println("Вес Барсика - " + Barsik.getWeight());
        System.out.println("Вес Тимы - " + Tima.getWeight());
        System.out.println("Вес Тайсона - " + Tayson.getWeight());

        System.out.println("Количество кошек - " + Cat.getCount());

        //Бесконечно кормим кошку, пока она не лопнет
        while (true) {
            Murka.feed(1.0);
            if (Murka.getStatus().equals("Exploded")) {
                System.out.println("Вес Мурки - " + Murka.getWeight());
                System.out.println("Статус Мурки - " + Murka.getStatus());
                break;
            }
        }

        //Замяукиваем кошку до смерти
        while (true) {
            Tisha.meow();
            if (Tisha.getStatus().equals("Dead")) {
                System.out.println("Вес Тиши - " + Tisha.getWeight());
                System.out.println("Статус Тиши - " + Tisha.getStatus());
                break;
            }
        }

        //Создаём три котёнка
        Cat Baby = getKitten();
        Cat Baby2 = getKitten();
        Cat Baby3 = getKitten();
    }

    private static Cat getKitten() {
        Cat cat = new Cat(1100.0);
        return cat;
    }
}