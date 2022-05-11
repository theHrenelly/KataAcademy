package objectsClassesPackets.task3_4_8;

public class Solution {
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());


    }

    public static class ComplexNumber {
        private double re;
        private double im;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber that = (ComplexNumber) o;
            return re == that.re && im == that.im;//Double.compare(that.getRe(), getRe()) == 0 && Double.compare(that.getIm(), getIm()) == 0;
        }

        @Override
        public int hashCode() {
            int result = 31;
            long lnum = Double.doubleToLongBits(re);
            long lnum2 = Double.doubleToLongBits(im);
            result = result * 17 + (int) (lnum ^ (lnum >>> 32));
            result = result * 17 + (int) (lnum2 ^ (lnum2 >>> 32));
            return result;
        }

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }
    }
}
