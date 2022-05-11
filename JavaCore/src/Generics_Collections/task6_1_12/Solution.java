package Generics_Collections.task6_1_12;

    /*
    TODO Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов
         и не запрещающий элементам принимать значение null.
         Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
         Конструктор должен быть закрытым (private).

    С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:

    Pair<Integer, String> pair = Pair.of(1, "hello");
    Integer i = pair.getFirst(); // 1
    String s = pair.getSecond(); // "hello"
    Pair<Integer, String> pair2 = Pair.of(1, "hello");
    boolean mustBeTrue = pair.equals(pair2); // true!
    boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.
*/

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        System.out.println(i);
        String s = pair.getSecond(); // "hello"
        System.out.println(s);
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);
    }

    public static class Pair<T1, T2> {
        private final T1 first;
        private final T2 second;

        private Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Pair<?, ?>)) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            int result = 31;

            if (first != null) {
                result = result * 17 + first.hashCode();
            }
            if (second != null) {
                result = result * 17 + second.hashCode();
            } else if (first == null) {
                return 0;
            }
            return result;

//            int result = first != null ? first.hashCode() : 0;
//            result = 31 * result + (second != null ? second.hashCode() : 0);
//            return result;
        }

        public static <T1, T2> Pair<T1, T2> of(T1 value1, T2 value2) {
            return new Pair<>(value1, value2);
        }
    }
}