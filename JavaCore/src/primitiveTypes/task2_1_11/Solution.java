package primitiveTypes.task2_1_11;

public class Solution {
    public static void main(String[] args) {
        System.out.println(drawisMonitorsCounter(17, 7));
    }
    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }
}
