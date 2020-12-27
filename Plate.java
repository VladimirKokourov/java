package geekbrains.homework.lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    int getFood(){
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    void addFood(int addFood){
        food += addFood;
    }
}
