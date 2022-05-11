package errorsExceptionsDebug.task4_1_8;

/*
        Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

        Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод.
        Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.

        Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
 */

public class Solution {

    public static void main(String[] args) {
        m1();
    } // null

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    } // myClass#main

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    } // myClass#m1

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    } // myClass#m2

    public static String getCallerClassAndMethodName() {
        try {
            StackTraceElement element = new Throwable().getStackTrace()[2];
            StringBuilder strB = new StringBuilder();
            return strB.append(element.getClassName()).append("#").append(element.getMethodName()).toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }

//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        StringBuilder strB = new StringBuilder();
//        if (stackTraceElements.length <= 3) {
//            return null;
//        }
//        return strB.append(stackTraceElements[3].getClassName()).append("#")
//                .append(stackTraceElements[3].getMethodName()).toString();

    }
}

