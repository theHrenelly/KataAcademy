package Generics_Collections.task6_2_15;

    /*
    TODO Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
         затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность
         в обратном порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

Все import объявлены за вас.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль
*/

import java.io.ByteArrayInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

//        System.setIn(new ByteArrayInputStream("1 2 3 4 5 6 7 8 9 10".getBytes()));
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        while (scan.hasNextInt()) {
            scan.next();
            if (scan.hasNextInt()) {
                ad.addFirst(scan.nextInt());
            }
        }
        for (int a : ad) {
            System.out.printf("%2s", a);
        }
    }
}
