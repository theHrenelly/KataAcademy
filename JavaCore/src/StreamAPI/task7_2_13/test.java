package StreamAPI.task7_2_13;

import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("awesome key", "cool value");

        map.computeIfAbsent("awesome key", key -> key + ", " + "amazing value");

        System.out.println(map.get("awesome key")); //output: cool value
    }
}
