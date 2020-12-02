package ru.geekbrains.lesson1;

public class Main {
        // 1
    public static void main(String[] args) {
        // 2
        byte bt = 10;
        short sh = 32000;
        int i = -15;
        long l = 333333333L;
        float f = 1654.0f;
        double d1 = 78.99;
	boolean bool = true;
	char ch = 's';
	String str = "java";

        // 3
        System.out.println("3) " + calcNumbers(1,2,6,3));

        // 4
        System.out.println("4) " + sumNumbers(15,5));

        //5
        compNumbers(-5);

        //6
        System.out.println("6) " + negNumbers(-8));

        //7
        sayHello("Артём");

        //8
        compYear(400);
    }
    // 3
    public static int calcNumbers(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // 4
    public static boolean sumNumbers(int a, int b) {
        int sum = a + b;
        if(sum <= 20 && sum >= 10) {
            return true;
        } else
            return false;
    }

    // 5
    public static void compNumbers(int a) {
        if(a >= 0) {
            System.out.println("5) Положительное");
        } else
            System.out.println("5) Положительное");
    }

    // 6
    public static boolean negNumbers(int a) {
        if(a < 0) {
                return true;
            } else
                return false;
    }

    //7
    public static void sayHello(String name) {
        System.out.println("7) Привет, " + name);
    }

    // 8
    public static void compYear(int year) {
        int a = year / 4;
        int b = a * 4;
        if(year == b) {
            a = year / 100;
            b = a * 100;
            if(year == b) {
                a = year / 400;
                b = a * 400;
                if(year == b) {
                    System.out.println("8) Високосный");
                } else System.out.println("8) Невисокосный");
            } else System.out.println("8) Високосный");
        } else System.out.println("8) Невисокосный");
    }
}
