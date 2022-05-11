package errorsExceptionsDebug.task4_2_9;

/*
    TODO Реши предыдущую задачу с использованием try-with-resources*/

public class Solution {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = (RobotConnection) robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException(e.getMessage(), e);
                }
            }
        }
    }
}
