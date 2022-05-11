package primitiveTypes.task2_4_13_Factorial;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial2(4));
    }

    public static BigInteger factorial(int value) {
        BigInteger a = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            a = a.multiply(BigInteger.valueOf(i));
        }
        return a;
    }

    public static BigInteger factorial2(int value) {
        return IntStream.rangeClosed(1, value)
                .mapToObj(BigInteger::valueOf)
              //.mapToObj(i -> BigInteger.valueOf(i))
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
