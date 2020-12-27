package geekbrains.homework.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate p) {
        if(p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            isFull = true;
            appetite = 0;
        } else {
            System.out.println(name + " says: Need more food!");
            isFull = false;
            appetite -= p.getFood();
            p.decreaseFood(p.getFood());
        }
    }

    int getAppetite() {
        return appetite;
    }

    boolean getIsFull() {
        return isFull;
    }

    String getName(){
        return name;
    }
}
