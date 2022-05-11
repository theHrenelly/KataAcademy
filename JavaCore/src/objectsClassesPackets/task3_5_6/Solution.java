package objectsClassesPackets.task3_5_6;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        byte[] byteArray = {80, 65, 78, 75, 65, 74};
        AsciiCharSequence ascii = new AsciiCharSequence(byteArray);
        System.out.println(ascii.length());
        System.out.println(ascii.charAt(3));
        System.out.println(ascii.subSequence(1, 4));
        System.out.println(ascii.toString());
    }

    public static class AsciiCharSequence implements CharSequence {
        private byte[] byteArray;

        public AsciiCharSequence(byte[] byteArray) {
            this.byteArray = byteArray;
        }

        @Override
        public int length() {
            return byteArray.length;
        }

        @Override
        public char charAt(int index) {
            return (char) byteArray[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(byteArray, start, end));
        }

        @Override
        public String toString() {
            return new String(byteArray);
        }
    }
}
