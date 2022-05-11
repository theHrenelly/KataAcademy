package primitiveTypes.task2_4_17;

public class Solution {
    public static void main(String[] args) {

    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] a3 = new int[a1.length + a2.length];
        int i = 0, j = 0, k = 0; // Array
        while (i < a1.length && j < a2.length) {
            a3[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }
        if (i < a1.length) {
            System.arraycopy(a1, i, a3, k, a1.length - i);
        } else if (j < a2.length) {
            System.arraycopy(a2, j, a3, k, a2.length - j);
        }
        return a3;
    }
}
