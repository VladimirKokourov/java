package geekbrains.homework.lesson7;

public class MainClass {
    public static void main(String[] args) {
        String yes = "Yes";
        String no = "No";
        int needMoreFood = 0;
        Cat[] cats = {new Cat("Barsik", 10), new Cat("Mirka", 10),
                new Cat("Dirich", 80), new Cat("Shastun", 50),
                new Cat("Raketa", 20)};

        Plate plate = new Plate(130);
        // инфо о тарелке
        plate.info();
        // по очереди кормим котов(кошек)
        for (Cat c: cats) {
            c.eat(plate);
            System.out.println(c.getName() + " full? " + (c.getIsFull() == true ? yes : no));
            System.out.println(c.getName() + " Appetite: " + c.getAppetite());
        }
        // вычисляем сколько еды не хватило
        for (Cat c: cats) {
            needMoreFood += c.getAppetite();
        }
        // накладываем в тарелку необходимое количество
        plate.info();
        plate.addFood(needMoreFood);
        plate.info();
        // кормим не наевшихся котов(кошек)
        for (Cat c: cats) {
            if(!c.getIsFull()){
                c.eat(plate);
                System.out.println(c.getName() + " full? " + (c.getIsFull() == true ? yes : no));
                System.out.println(c.getName() + " Appetite: " + c.getAppetite());
            }
        }
        // наконец-то идем спать, говорящие коты(кошки) не к добру)
        System.out.println("Now you can get some sleep)");

    }
}
