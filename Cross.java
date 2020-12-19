package geekbrains.homework.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Cross {

        static int SIZE_X = 5;
        static int SIZE_Y = 5;
        static int SIZE_WIN = 4;

        static char[][] field = new char[SIZE_X][SIZE_Y];
        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();

        static char PLAYER_DOT = 'X';
        static char AI_DOT = 'O';
        static char EMPTY_DOT = '.';

        static void initField() {
            for (int i = 0; i < SIZE_Y; i++) {
                for (int j = 0 ; j < SIZE_X; j++) {
                    field[i][j] = EMPTY_DOT;
                }

            }
        }

        static void printField() {
            System.out.println("________");
            for (int i = 0; i < SIZE_Y; i++) {
                System.out.print("|");
                for (int j = 0; j < SIZE_X; j++) {
                    System.out.print(field[i][j] + "|");
                }
                System.out.println();
            }
            System.out.println("________");
        }

        static boolean isCellValid(int y, int x) {
            if (y < 0 || x < 0  || y > SIZE_Y || x > SIZE_X) {
                return false;
            }
            return field[y][x] == EMPTY_DOT;
        }

        static boolean isFieldFull() {
            for (int i = 0; i < SIZE_Y; i++) {
                for (int j = 0; j < SIZE_X; j++) {
                    if (field[i][j] == EMPTY_DOT) {
                        return false;
                    }
                }
            }
            return true;
        }

        static void setSym(int y, int x, char sym) {
            field[y][x] = sym;
        }

        static void playerStep() {
            int x, y;
            do {
                System.out.println("Введите координаты X Y (1-3)");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(y,x));
            setSym(y,x,PLAYER_DOT);
        }

        static void aiStep() {
            int x, y;
            System.out.println("Ходит компьютер");
            do {
                x = random.nextInt(SIZE_X);
                y = random.nextInt(SIZE_Y);
            } while (!isCellValid(y,x));
            setSym(y,x,AI_DOT);
        }

    private static boolean checkWin(char dot) {
        for (int v = 0; v < SIZE_Y; v++) {
            for (int h = 0; h < SIZE_X; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE_X) {
                    //по горизонтале
                    if (checkLineHorizontal(v, h, dot) >= SIZE_WIN) return true;

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, dot) >= SIZE_WIN) return true;
                    }
                    if (v + SIZE_WIN <= SIZE_Y) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, dot) >= SIZE_WIN) return true;
                    }
                }
                if (v + SIZE_WIN <= SIZE_Y) {                       //по вертикале
                    if (checkLineVertical(v, h, dot) >= SIZE_WIN) return true;
                }
            }
        }
        return false;
    }

    private static int checkDiaUp(int v, int h, char dot) {
        int count = 0;
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((field[v + i][h + j] == dot)) count++;
        }
        return count;
    }

    private static int checkDiaDown(int v, int h, char dot) {
        int count = 0;
        for (int i = 0; i < SIZE_WIN; i++) {
            if ((field[i + v][i + h] == dot)) count++;
        }
        return count;
    }

    private static int checkLineHorizontal(int v, int h, char dot) {
        int count = 0;
        for (int j = h; j < SIZE_WIN + h; j++) {
            if ((field[v][j] == dot)) count++;
        }
        return count;
    }

    private static int checkLineVertical(int v, int h, char dot) {
        int count = 0;
        for (int i = v; i < SIZE_WIN + v; i++) {
            if ((field[i][h] == dot)) count++;
        }
        return count;
    }

        public static void main(String[] args) {
            initField();
            printField();
            do {
                playerStep();
                printField();
                if (checkWin(PLAYER_DOT)) {
                    System.out.println("Вы выиграли");
                    break;
                } else if (isFieldFull()) break;
                aiStep();
                printField();
                if (checkWin(AI_DOT)) {
                    System.out.println("Выйграл Компьютер");
                    break;
                } else if (isFieldFull()) break;
            } while (true);
            System.out.println("Конец игры!");
        }
}


