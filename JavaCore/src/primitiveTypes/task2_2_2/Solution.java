package primitiveTypes.task2_2_2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(charExpression(15));
    }
    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
