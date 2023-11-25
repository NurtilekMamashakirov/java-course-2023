package edu.hw7.task4.forMulti;

import edu.hw7.task4.PiGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MultiPiGenerator implements PiGenerator {

    // 1 - 5286 2 - 2711 3 - 1879 4 - 1462 5 - 1383 6 - 1379 7 - 1270 8 - 1269
    // (выполнение программы в заивсимости от количества потоков)

    private final static int CORES = Runtime.getRuntime().availableProcessors();
    private final static int COEFFICIENT = 4;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private static final int SIZE_OF_FIELD = 50001;
    private static final int CENTER_OF_CIRCLE = SIZE_OF_FIELD / 2;
    private static final int RADIUS = SIZE_OF_FIELD / 2;
    private int totalCount = 0;
    private int circleCount = 0;

    @Override
    public double generatePi(int simulations) {
        final int simulationForThread = simulations / CORES;
        List<Thread> threads = getThreads(simulationForThread);
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return COEFFICIENT * (double) circleCount / (double) totalCount;
    }

    private List<Thread> getThreads(int simulationForThread) {
        List<Thread> threads = new ArrayList<>();
        Runnable runnable = () -> {
            int localCount = 0;
            int localCircleCount = 0;
            for (int i = 0; i < simulationForThread; i++) {
                int x = RANDOM.nextInt(SIZE_OF_FIELD);
                int y = RANDOM.nextInt(SIZE_OF_FIELD);
                localCount++;
                if (isInCircle(x, y)) {
                    localCircleCount++;
                }
            }
            increaseCircleCount(localCircleCount);
            increaseTotalCount(localCount);
        };
        for (int i = 0; i < CORES; i++) {
            threads.add(new Thread(runnable));
        }
        return threads;
    }

    public static boolean isInCircle(int x, int y) {
        int xDistance = Math.abs(CENTER_OF_CIRCLE - x);
        int yDistance = Math.abs(CENTER_OF_CIRCLE - y);
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return distance <= (double) RADIUS;
    }

    public synchronized void increaseTotalCount(int localCount) {
        totalCount += localCount;
    }

    public synchronized void increaseCircleCount(int localCircleCount) {
        circleCount += localCircleCount;
    }

}
