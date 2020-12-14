package geekbrains.homework.lesson_2;

public class HomeWork2 {

    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        findNumb();
        
        System.out.println("6. ");
        int[] arr = {1, 2, 1, 3, 1, 0};
        System.out.println(sumLine(arr));

        int[] mass = {1, 2, 3, 4, 5, 6, 7, 8};
        moving(mass, -5);

    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void invertArray() {
        System.out.println("1.");
        int[] change = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i : change) {
            i = i > 0 ? 0 : 1;
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        System.out.println("2.");
        int[] plusThree = new int[8];
        for (int i = 0, j = 0; i < plusThree.length; i++, j += 3) {
            plusThree[i] = j;
            System.out.print(plusThree[i] + " ");
        }
        System.out.println();
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void changeArray() {
        System.out.println("3.");
        int[] less6Double = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i : less6Double) {
            if (i < 6) {
                i = i * 2;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonal() {
        System.out.println("4.");
        int[][] square = new int[7][7];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                int sum = i + j;
                if (i == j || sum == 6) {
                    square[i][j] = 1;
                }
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void findNumb() {
        System.out.println("5.");
        int[] findNumber = {5, -4, -11, 2, -1, -10, 15, -5, -7};
        int greatest = -2147483648;
        for (int i : findNumber) {
            for (int j : findNumber) {
                if (i >= j) {
                    if (greatest < i) {
                        greatest = i;
                    }
                } else break;
            }
        }
        System.out.println("Наибольшее: " + greatest);

        int smallest = greatest;
        for (int i : findNumber) {
            for (int j : findNumber) {
                if (i <= j) {
                    if (smallest > i) {
                        smallest = i;
                    }
                } else break;
            }
        }
        System.out.println("Наименьшее: " + smallest);
    }

    // 6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean sumLine(int[] arr) {
        int length = arr.length - 1;
        int inc = length - 1;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = arr[0];
        right[3] = arr[4];
        for (int i = 0; i < inc; i++) {
            left[i + 1] = left[i] + arr[i + 1];
        }
        for (int i = 3; i > 0; i--) {
            right[i - 1] = right[i] + arr[i];
        }
        for (int i = 0; i < inc; i++) {
            if (left[i] == right[i]) {
                return true;
            }
        }
        return false;
    }

    //7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
    //отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
    //нельзя пользоваться вспомогательными массивами.
    public static void moving(int[] mass, int n) {
        System.out.println("7.");
        int length = mass.length - 1;
        if(n > 0) {
            for (int i = 0; i < n; i++) {
                int last = mass[length];
                for (int j = length; j > 0; j--) {
                    mass[j] = mass[j - 1];
                }
                mass[0] = last;
            }
            for (int i = 0; i < mass.length; i++) {
                System.out.print(mass[i] + " ");
            }
        } else {
            n = n * (-1);
            for (int i = 0; i < n; i++) {
                int first = mass[0];
                for (int j = 0; j < length; j++) {
                    mass[j] = mass[j + 1];
                }
                mass[length] = first;
            }
            for (int i = 0; i < mass.length; i++) {
                System.out.print(mass[i] + " ");
            }
        }
    }
}
