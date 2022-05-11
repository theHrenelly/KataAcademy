package StreamAPI.task7_2_11;

    /*
    TODO Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком,
         заданным Comparator'ом.

    Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

    minMaxConsumer.accept(min, max);
    Если стрим не содержит элементов, то вызовите:

    minMaxConsumer.accept(null, null);
    Требования:
    1. Должен быть метод public <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order,
                                                        BiConsumer<? super T, ? super T> minMaxConsumer)
    2. Метод должен находить минимум и максимум в потоке, с помощью order.
    3. Полученные данные должны быть записаны minMaxConsumer, согласно условию
*/

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.sorted().collect(Collectors.toList());

        T min = list.stream().min(order).orElse(null);
        T max = list.stream().max(order).orElse(null);

        minMaxConsumer.accept(min, max);
    }

    public static <T> void findMinMax2(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        class customConsumer implements Consumer<T> {
            T min = null, max = null;

            @Override
            public void accept(T o) {
                if (min == null || order.compare(min, o) > 0) {
                    min = o;
                }
                if (max == null || order.compare(o, max) > 0) {
                    max = o;
                }
            }
        }

        customConsumer cc = new customConsumer();
        stream.forEach(cc);
        minMaxConsumer.accept(cc.min, cc.max);
    }

    public static <T> void findMinMax3(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Deque<T> list = stream.sorted(order).collect(Collectors.toCollection(LinkedList::new));

        minMaxConsumer.accept(list.peekFirst(), list.peekLast());
    }

    public static <T> void findMinMax4(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());

        minMaxConsumer.accept(list.isEmpty() ? null : list.get(0),
                list.isEmpty() ? null : list.get(list.size() - 1));
    }
}