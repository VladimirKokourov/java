package geekbrains.homework.lesson3;

public class MainDZ3_3 {
    public static void main(String[] args) {
        String str1 = " Предложение один    Теперь предложение два     Предложение три";
        System.out.println(str1);

        String str2 = str1.replaceAll(" +", " ");
        System.out.println(str2);

        StringBuilder stringBuilder = new StringBuilder(str2);

        for(int i = str2.length()-1; i >= 0; i--) { // Цикл идет с конца строки, чтобы правильно сработал insert
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Я') {
                stringBuilder.setCharAt(i-1, '.'); // Ставится точка перед заглавной
                stringBuilder.insert(i, ' '); // Добавляется пробел перед заглавной
            }
        }
        stringBuilder.delete(0, 2); // Удаляются ". "
        stringBuilder.append('.'); // Присоединяется '.'

        System.out.println(stringBuilder);
    }
}
