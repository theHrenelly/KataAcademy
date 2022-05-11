package IO_FileSystemAccess.task5_3_11;

    /*
TODO Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

        Пример:
        InputStream последовательно возвращает четыре байта: 48 49 50 51.
        Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

        Требования:
        1. Метод должен быть публичным.
        2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)*/


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inByte = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        System.out.println(readAsString(inByte, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
//        StringBuilder strB = new StringBuilder();
//        int i;
//        while ((i = inputStreamReader.read()) != -1) {
//            strB.append((char) i);
//        }
//        return strB.toString();

        String result = null;
        try (Scanner scan = new Scanner(inputStream, charset)) {
            result = scan.useDelimiter("\\A").next();
        }
        return result;
    }
}