package IO_FileSystemAccess.task5_2_8;

/*
Напишите метод void print(InputStream inputStream, OutputStream outputStream)
который принимает InputStream и OutputStream, считывает все байты из inputStream и
записывает в OutputStream только четные.

Пример ввода: 3, 10, 4, 5, 7

Пример вывода: 10, 4

    TODO Требования:
         1. Метод должен быть публичным.
         2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
         3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        print(inputStream, outputStream);
        byte[] array = outputStream.toByteArray();
        for (byte b : array) {
            System.out.println(b);
        }
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
//        try (InputStream inputStreamL = inputStream;
//             OutputStream outputStreamL = outputStream;) {
//            int i;
//            while ((i = inputStreamL.read()) != -1) {
//                if (i % 2 == 0) {
//                    outputStreamL.write((byte) i);
//                }
//            }
//        }
        int i;
        while ((i = inputStream.read()) != -1) {
            if (i % 2 == 0) {
                outputStream.write((byte) i);
            }
            outputStream.flush();
        }
    }
}
