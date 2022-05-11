package primitiveTypes.task2_1_10;

public class Solution {
    public static void main(String[] args) {
        System.out.println(doubleExpression(15.0, 5.0, 20.00001));
    }
    public static boolean doubleExpression(double a, double b, double c) {
        return Math.abs(a + b - c) < 0.0001;
    }
}
