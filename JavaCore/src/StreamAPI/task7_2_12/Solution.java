package StreamAPI.task7_2_12;

/*
     Пример ввода  1:
     Мама мыла-мыла-мыла раму!

     Пример вывода  1:
     мыла
     мама
     раму

     Пример ввода 2:
     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus.
     Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur.
     Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem.
     Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.

     Пример вывода 2:
     consectetur
     faucibus
     ipsum
     lorem
     adipiscing
     amet
     dolor
     eget
     elit
     mi

     Требования:
     1. Должен быть метод public static void main(String[] args)
     2. Программа должна читать данные с консоли
     2. Программа должна писать данные в консоль
*/

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, "
                + "consectetur 32 adipiscing elit. "
                + "Sed sodales consectetur purus at faucibus."
                + " Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. "
                + "Morbi lacinia velit blandit 32 tincidunt 32 efficitur. "
                + "Vestibulum eget metus imperdiet sapien laoreet faucibus. "
                + "Nunc eget vehicula mauris, ac auctor lorem. 32 Lorem ipsum dolor sit amet,"
                + " consectetur adipiscing elit. Integer vel odio 32 nec mi tempor dignissim.";
        ByteArrayInputStream textInput = new ByteArrayInputStream(text.getBytes());
        System.setIn(textInput);
        countOfWords();
    }

    /*
TODO Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
     и в конце выводящую 10 наиболее часто встречающихся слов.
     Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
     Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
     Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
     Выводите слова в нижнем регистре.
     Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
     Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
     то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
     Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
*/

    private static void countOfWords() {
        new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8).useDelimiter("[^\\p{LD}]+").tokens()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(el -> System.out.println(el.getKey()));
    }

    private static void countOfWords2() {
        new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8).useDelimiter("[^\\p{LD}]+").tokens()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(el -> System.out.println(el.getKey()));
    }

    private static void kek1() {
        new BufferedReader(new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8))
                .lines()
                .map(line -> line.toLowerCase().split("[^\\p{LD}]+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(el -> System.out.println(el.getKey()));
    }

    private static void kek2() {
        HashMap<String, Integer> result = new HashMap<>();

        new BufferedReader(new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8))
                .lines()
                .flatMap(el -> Stream.of(el.split("[^\\p{LD}]+")))
                .map(el -> el.toLowerCase())
                .forEach(el -> {
                    if (result.containsKey(el)) result.put(el, result.get(el) + 1);
                    else result.put(el, 1);
                });

        result.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(el -> System.out.println(el.getKey()));
    }


    //        private static void kek3() {
//        Stream.of(new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8)
//                        .nextLine().replaceAll("\\W", "")
//                        .toLowerCase())
//                .flatMap(el -> Arrays.stream(el.split(" ")))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
//    }
}
