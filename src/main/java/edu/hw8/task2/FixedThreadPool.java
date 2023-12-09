package edu.hw8.task2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedThreadPool implements ThreadPool {

    private final BlockingDeque<Runnable> tasks;
    private final Thread[] threads;
    private final AtomicBoolean isStopped;

    private FixedThreadPool(Thread[] threads) {
        this.threads = threads;
        tasks = new LinkedBlockingDeque<>();
        isStopped = new AtomicBoolean(false);
    }

    public static FixedThreadPool create(int threadsCount) {
        if (threadsCount <= 0) {
            throw new IllegalArgumentException("Thread's number must be > 0!");
        }
        return new FixedThreadPool(new Thread[threadsCount]);
    }

    @Override
    public void start() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                if (!isStopped.get()) {
                    Runnable runnable;
                    while ((runnable = tasks.poll()) != null) {
                        runnable.run();
                        runnable = tasks.poll();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        if (!isStopped.get()) {
            try {
                tasks.put(runnable);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void close() {
        isStopped.set(true);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

}
