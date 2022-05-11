package Generics_Collections.task6_1_13;

    /*
    Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение.
    TODO Создайте класс DynamicArray, который хранит в себе массив, и имеет методы для добавления void add(T el),
         void remove(int index) удаления и извлечения T get(int index) из него элементов,
         при переполнении текущего массива, должен создаваться новый, большего размера.

    Для возможности работы с различными классами DynamicArray должен быть дженериком.
    Для решения задачи можно воспользоваться методами из класса java.util.Arrays.
    Импорт этого класса уже объявлен в тестирующей системе. Добавлять его явно не нужно

    Требования:
    1. должен быть класс public static class DynamicArray
    2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
    3. В случае подбора некорректного индекса ожидается, что метод get выбросит ArrayIndexOutOfBoundsException
    4. класс DynamicArray должен  иметь публичный конструктор по умолчанию
    5. работа методов должна соответствовать условию
*/

import java.util.Arrays;

public class Solution {
    public static class DynamicArray<T> {
        private int size = 0;
        private static final double DEFAULT_LOAD = 0.75;
        private T[] array = (T[]) new Object[10];

        public void add(T el) {
            if (size >= array.length * DEFAULT_LOAD) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            array[size++] = el;
        }

        public void remove(int index) {
            if (checkIndex(index)) {
                throw new ArrayIndexOutOfBoundsException();
            }
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            size--;
        }

        public T get(int index) {
            if (checkIndex(index)) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                return array[index];
            }
        }

        private boolean checkIndex(int index) {
            return index >= size || index < 0;
        }
    }
}