package edu.hw8.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    final static int NUMBER_OF_THREADS = 3;
    final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) throws InterruptedException {
        FixedThreadPool threadPool = FixedThreadPool.create(NUMBER_OF_THREADS);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            int num = 0;
            if (i == 0) {
                num = 30;
            }
            if (i == 1) {
                num = 15;
            }
            if (i == 2) {
                num = 5;
            }
            final int numFinal = num;
            threadPool.execute(() ->
                LOGGER.info(
                    "Поток №" + Thread.currentThread().threadId() + " посчитал " + Fibonacci.getFibonacci(numFinal))
            );
        }
        threadPool.start();
        Thread.sleep(10000);
        threadPool.close();
    }
}
