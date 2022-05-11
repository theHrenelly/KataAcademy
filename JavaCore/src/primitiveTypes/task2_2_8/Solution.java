package primitiveTypes.task2_2_8;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return Integer.bitCount(value) == 1;
    }
}
