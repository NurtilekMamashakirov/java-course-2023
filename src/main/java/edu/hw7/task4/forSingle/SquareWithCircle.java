package edu.hw7.task4.forSingle;

import java.util.concurrent.ThreadLocalRandom;

public class SquareWithCircle {

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int SIZE_OF_FIELD = 50001;
    private static final int CENTER_OF_CIRCLE = SIZE_OF_FIELD / 2;
    private static final int RADIUS = SIZE_OF_FIELD / 2;
    private int totalCount = 0;
    private int circleCount = 0;

    public void addPoint() {
        int x = RANDOM.nextInt(SIZE_OF_FIELD);
        int y = RANDOM.nextInt(SIZE_OF_FIELD);
        totalCount++;
        if (isInCircle(x, y)) {
            circleCount++;
        }

    }

    public boolean isInCircle(int x, int y) {
        int xDistance = Math.abs(CENTER_OF_CIRCLE - x);
        int yDistance = Math.abs(CENTER_OF_CIRCLE - y);
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return distance <= (double) RADIUS;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCircleCount() {
        return circleCount;
    }
}
