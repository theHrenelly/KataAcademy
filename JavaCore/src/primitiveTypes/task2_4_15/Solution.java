package primitiveTypes.task2_4_15;

// 1 - от 7 до 13 лет 2 - от 14 до 17 лет 3 - от 18 до 65 лет

public class Solution {
    public static void main(String[] args) {
        System.out.println(determineGroup(165));
    }

    public static int determineGroup(int age) {
        return age >= 7 & age <= 13 ?
                1 : age >= 14 & age <= 17 ?
                2 : age >= 18 & age <= 65 ?
                3 : -1;
    }
}
