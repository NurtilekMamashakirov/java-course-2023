package edu.hw9.task1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StatsCollector {

    private final static Integer MAX_THREADS = Runtime.getRuntime().availableProcessors();
    private ExecutorService executor;
    private List<Metric> metrics;

    public StatsCollector() {
        executor = Executors.newFixedThreadPool(MAX_THREADS);
        metrics = new CopyOnWriteArrayList<>();
    }

    public void push(String metricName, double[] numbers) {
        StatsHandler handler = new StatsHandler(metricName, numbers);
        Future<Metric> metric = executor.submit(handler);
        try {
            metrics.add(metric.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Metric> stats() {
        return metrics;
    }

}
