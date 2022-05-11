package primitiveTypes.task2_4_16;

//Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него, через запятую.
//        Конец вывода должен перевести курсор на новую строку.
//
//        Пример ввода: [3,5,20,8,7,3,100]
//
//        Пример вывода: 3,5,7,3

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int[] tmp = {3,5,20,8,7,3,100};
        printOddNumbers(tmp);
    }

    public static void printOddNumbers(int[] arr) {
        if (arr != null && arr.length != 0) {
            StringBuilder str = new StringBuilder();
            for (int i : arr) {
                if (i % 2 != 0) {
                    str.append(i).append(",");
                }
            }
            if (str.length() != 0) {
                System.out.println(str.deleteCharAt(str.length() - 1));
                // System.out.println(str.substring(0, str.length() - 1));
            }
        }
    }
}
