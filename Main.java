package geekbrains.homework.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuessNumber(10);
        //guessWord();
    }
    // 1.Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать
    // это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    // (1 – повторить, 0 – нет).

    public static void GuessNumber(int x) {
        int play = 1;
        boolean flag;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (play == 1) {
            flag = false;
            System.out.println("Угадайте число от 0 до " + (x - 1) + ". У Вас 3 попытки.");
            int number = random.nextInt(x);

            for (int i = 2; i >= 0 ; i--) {
                int numberIn = scanner.nextInt();
                if (number > numberIn) {
                    System.out.println("Загаданное число больше.");
                } else if (number < numberIn) {
                    System.out.println("Загаданное число меньше.");
                } else {
                    flag = true;
                    break;
                }
                System.out.println("У Вас осталось " + i + " попытки(ка)");
            }

            if (!flag) {
                System.out.println("Вы проиграли. Попробуйте еще раз.");
            } else
                System.out.println("Вы угадали! Поздравляю!");

            do {
                System.out.println("Хотите сыграть еще? 1 – да, 0 – нет");
                play = scanner.nextInt();
            } while (play > 1);
        }
    }

    private static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int rand = random.nextInt(24);
        String answer;
        Boolean win = false;

        System.out.println("Угадайте слово загаданное программой.");


        do {
            System.out.println("Введите ваше слово.");

            answer = sc.next();

            if(words[rand].equals(answer.toLowerCase()))    {
                win = true;
            }

            if(!win) {
                System.out.println("Не угадали, попробуйте ещё раз.");

                for (int i = 0; i < words[rand].length(); i++) {
                    if (answer.length() > i && answer.charAt(i) == words[rand].charAt(i)) {
                        sb.append("(" + answer.charAt(i) + ")");
                    } else sb.append("#");
                }

                System.out.println("Буквы которые вы угадали: " + "#####" + sb.toString() + "#####");
                sb.delete(0, sb.length());
                System.out.println();
            }

        } while (!words[rand].equals(answer.toLowerCase())); {
            System.out.println("Вы угадали слово!");
        }
    }
}