package Generics_Collections.task7_1_7;

    /*
    TODO Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
         который принимает целое число(тип int) и возвращает его квадрат.

Требования:
1. Должен быть метод public UnaryOperator sqrt()
2. Метод должен возвращать реализацию интерфейса UnaryOperator.
3. Реализация должна соответствовать условию*/

import java.util.function.UnaryOperator;

public class Solution {
    public static void main(String[] args) {
        Integer num = 10;
        System.out.println(sqrt().apply(num));
    }

    public static UnaryOperator<Integer> sqrt() {
    return x -> x * x;
    }
}
