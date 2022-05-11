package IO_FileSystemAccess.task5_4_7;

    /*
TODO Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
     Массив байт устроен следующим образом. Сначала идет число типа int, записанное при помощи
     ObjectOutputStream.writeInt(size). Далее подряд записано указанное количество объектов типа Animal,
     сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
то метод должен бросить исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
Если что-то забудете, то проверяющая система подскажет. Главное не глотать никаких исключений,
т.е. не оставлять нигде пустой catch.

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: Animal[] deserializeAnimalArray(byte[] data).
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeInt(3);
        objectOutputStream.writeObject(new Animal("Fox"));
        objectOutputStream.writeObject(new Animal("Wolf"));
        objectOutputStream.writeObject(new Animal("Dog"));
        objectOutputStream.close();
        System.out.println(Arrays.toString(deserializeAnimalArray(byteArrayOutputStream.toByteArray())));
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {

            Animal[] animals = new Animal[ois.readInt()];

            for (int i = 0; i < animals.length; i++) {
                animals[i] = (Animal) ois.readObject();
            }

            return animals;
        } catch (ClassNotFoundException | ClassCastException | NegativeArraySizeException | IOException e) {
            throw new IllegalArgumentException(e);
        }


//        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
//            Animal [] animals = (Animal[]) ois.readObject();
//            System.out.println(Arrays.toString(animals));
//            return animals;
//
//        } catch (ClassNotFoundException | ClassCastException | NegativeArraySizeException | IOException e) {
//            throw new IllegalArgumentException(e);
//        }
    }
}




