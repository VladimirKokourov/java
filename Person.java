package geekbrains.homework.lesson5;

public class Person {
    String name;
    String position;
    String email;
    String telnum;
    int salary;
    int age;

    public void info() {
        System.out.println("ФИО: " + name + "; Должность: " + position + "; Эл.почта: " + email + "; Телефон:" + telnum
                + "; Зарплата: " + salary + "; Возраст: " + age);
    }

    public Person(String name, String position, String email, String telnum, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.telnum = telnum;
        this.salary = salary;
        this.age = age;
    }
}
