package objectsClassesPackets.task3_3_13;

public class Solution {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
        StringBuilder strB = new StringBuilder();
        System.out.println(strB.append("OX: " + robot.getX()).append("  ").append("OY: " +robot.getY()));
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int lengthByX = robot.getX() - toX;
        int lengthByY = robot.getY() - toY;
        Direction directionX = lengthByX > 0 ? Direction.LEFT : Direction.RIGHT;
        Direction directionY = lengthByY > 0 ? Direction.DOWN : Direction.UP;
        lengthByX = Math.abs(lengthByX);
        lengthByY = Math.abs(lengthByY);

        while (robot.getDirection() != directionX) {
            robot.turnRight();
        }
        while (lengthByX-- > 0) {
            robot.stepForward();
        }
        while (robot.getDirection() != directionY) {
            robot.turnLeft();
        }
        while (lengthByY-- > 0) {
            robot.stepForward();
        }
    }
}

