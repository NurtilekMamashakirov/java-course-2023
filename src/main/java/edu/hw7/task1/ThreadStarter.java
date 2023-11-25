package edu.hw7.task1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadStarter {

    public int startThreads() {
        AtomicInteger counter = new AtomicInteger();
        Runnable plussing = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.getAndIncrement();
            }
        };
        Thread thread1 = new Thread(plussing);
        Thread thread2 = new Thread(plussing);
        Thread thread3 = new Thread(plussing);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return counter.get();
    }

}
