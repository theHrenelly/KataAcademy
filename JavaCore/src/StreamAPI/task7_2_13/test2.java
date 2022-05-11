package StreamAPI.task7_2_13;

import java.util.HashMap;
import java.util.Map;

public class test2 {
    private static Map<String, Long> numbersMap = new HashMap<>();

    public static Long stringToLong(String str) {
        return numbersMap.computeIfAbsent(str, key -> {
            System.out.println("parsing: " + key);
            return Long.parseLong(key) + 10L;
        });
    }

    public static void main(String[] args) {

        // will print:
        // > parsing: 10
        // > parsing: 25
        // > 10+25=35
        System.out.println("10+25=" + (stringToLong("10") + stringToLong("25")));
        System.out.println("---------");
        System.out.println(numbersMap);
        System.out.println("---------");
        // will print:
        // > parsing: 20
        // > 10+25=45
        // only "20" will be parsed this time, since "25" was already parsed and placed into `numbersMap` map before
        System.out.println("20+25=" + (stringToLong("20") + stringToLong("25")));
        System.out.println("---------");
        System.out.println(numbersMap);
        System.out.println("---------");
        // will print:
        // > 10+20=30
        // no parsing will occur, since both "10" and "20" were already parsed and placed into `numbersMap` map before
        System.out.println("10+20=" + (stringToLong("10") + stringToLong("20")));
        System.out.println("---------");
        System.out.println(numbersMap);
        System.out.println("---------");
    }

}

