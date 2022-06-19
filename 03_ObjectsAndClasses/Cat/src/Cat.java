public class Cat
{
    public static final int EYES_COUNT = 2;
    public static final int MIN_WEIGHT = 1000;
    public static final int MAX_WEIGHT = 9000;

    private double originWeight;
    private double weight;
    private double summaAmount;
    private double minWeight;
    private double maxWeight;
    private boolean isAlive;
    private String name;

    private static int count;
    private Color colorCat;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        newLife();
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        System.out.println("Вес котика - " + weight);
        newLife();
    }

    public static Cat copyCat(Cat newCopyCat) {
        Cat vasya= new Cat();
        vasya.setColorCat(newCopyCat.colorCat);
        vasya.setName(newCopyCat.getName());
        vasya.setWeight(newCopyCat.getWeight());
        System.out.println("Вес новой кошки - " + vasya.getWeight());
        System.out.println("Цвет новой кошки - " + vasya.getColorCat());
        System.out.println("Имя новой кошки - " + vasya.getName());
        return vasya;
    }

    public void setName(String name) { this.name = name;}

    public String getName() { return this.name;}

    public void setColorCat(Color color) {
        this.colorCat = color;
    }

    public Color getColorCat() {
        return this.colorCat;
    }

    static public int getCount() {
        return count;
    }

    public boolean isWeightNormal() {
        return weight >= minWeight && weight <= maxWeight;
    }

    public void meow()
    {
        if(isAlive) {
            weight = weight - 1;
            System.out.println("Meow");
            if (!isWeightNormal()) { dead(); }
        }
        else {
            System.out.println("Не могу мяукнуть, мне кирдык!");
        }
    }

    public void feed(Double amount)
    {
        if(isAlive) {
            weight = weight + amount;
            summaAmount += amount;
            if (!isWeightNormal()) { dead(); }
        }
        else {
            System.out.println("Не могу поесть, мне кирдык!");
        }
    }

    public Double summaFeed() {
        return summaAmount;
    }

    public void drink(Double amount)
    {
        if(isAlive) {
            weight = weight + amount;
            if (!isWeightNormal()) {dead(); }
        }
        else {
            System.out.println("Не могу попить, мне кирдык!");
        }
    }

    public void setWeight(Double weight) { this.weight = weight;}

    public Double getWeight()
    {
        return weight;
    }

    public void pee() {
        if(isAlive) {
            weight = weight - 3;
            System.out.println("Ура, я сходил(а) в туалет!");
            if (!isWeightNormal()) { dead(); }
        }
        else {
            System.out.println("Не могу сходить в туалет, мне кирдык!");
        }
    }

    public void newLife() {
        if(isWeightNormal()) {
            isAlive = true;
            count++;
        }
        else {
            System.out.println("Создалась мёртвая кошка :(");
        }
    }
    public void dead() {
        isAlive = false;
        count--;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}