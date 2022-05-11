package IO_FileSystemAccess.task5_3_9;

    /*
Какими байтами представляется символ 'Ы' в кодировке UTF-8?
Введите десятичные беззнаковые значения байт через пробел, например, 10 34 254.*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream bS = new ByteArrayInputStream("Ы".getBytes());
        int b = 0;
        while ((b = bS.read()) != -1)
            System.out.print(b + " ");

//        for (byte c : "Ы".getBytes())
//            System.out.print((c^-1 << 8)   " ");
    }
}
