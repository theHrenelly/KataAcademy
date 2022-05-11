package Generics_Collections.task6_2_13;

    /*
    TODO Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств.
         Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

    Пример ввода: [1, 2, 3} и {0, 1, 2]
    Пример вывода: [0, 3]

    Требования:
    1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
    2. метод symmetricDifference не должен изменять исходные множества
    3. метод symmetricDifference должен возвращать корректный результат
*/

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String[] args) {
        Set<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(1);
        treeSet1.add(2);
        treeSet1.add(3);

        Set<Integer> treeSet2 = new TreeSet<>();
        treeSet2.add(0);
        treeSet2.add(1);
        treeSet2.add(2);

        System.out.println(symmetricDifference(treeSet1, treeSet2));
    }



    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
//        Set<T> union = new HashSet<>(set1);
//        union.addAll(set2);
//        Set<T> intersact = new HashSet<>(set1);
//        intersact.retainAll(set2);
//        Set<T> difference = new HashSet<>(union);
//        difference.removeAll(intersact);

        Set<T> difference = new HashSet<>(set1);
        difference.addAll(set2);
        difference.removeIf(n -> set1.contains(n) && set2.contains(n));

        return difference;
    }
}
