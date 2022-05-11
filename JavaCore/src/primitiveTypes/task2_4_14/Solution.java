package primitiveTypes.task2_4_14;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        System.out.println(factorial(4));
    }

    public static BigInteger factorial(int value) {
        BigInteger a = BigInteger.valueOf(value);
        if (value == 1 || value == 0) {
            return a = BigInteger.ONE;
        } else {
            return a.multiply(factorial(--value));
        }
    }
}
