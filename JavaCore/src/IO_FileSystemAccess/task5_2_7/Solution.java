package IO_FileSystemAccess.task5_2_7;

    /*
Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его элементов.

Пример ввода: 1, 2, 4, 10

Пример вывода: 17

    TODO Требования:
         1. Метод должен быть публичным.
         2. Параметр должен иметь тип InputStream.
         3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)*/


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 4, 10, -1};
        InputStream inputStream = new ByteArrayInputStream(input);
        int result = sumOfStream(inputStream);
        System.out.println(result);
    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
//        int sum = 0;
//        try (InputStream inputStreamL = inputStream) {
//            int i;
//            while ((i = inputStreamL.read()) != -1) {
//                sum +=(byte) i;
//            }
//        }
//        return sum;
        int sum = 0;
        int i;
        while ((i = inputStream.read()) != -1) {
            sum += (byte) i;
        }
        return sum;
    }
}
