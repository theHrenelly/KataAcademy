package StreamAPI.task7_2_10;

    /*
    TODO Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
         Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
         Первый элемент последовательности устанавливается равным этому числу.
         Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2), где mid — это функция, выделяющая второй,
         третий и четвертый разряд переданного числа. Например, mid(123456)=345.
         Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)

    Пример ввода: 13
    Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

    Требования:
    1. Должен быть метод public static IntStream pseudoRandomStream(int seed)
    2. Метод должен возвращать поток, удовлетворяющий условию
*/

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(15).mapToObj(x -> x + " ").forEach(System.out::print);
        System.out.println();
        pseudoRandomStream(13).limit(15).forEach(x -> System.out.format("%d, ", x));
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> x = x * x / 10 % 1000);
    }
}