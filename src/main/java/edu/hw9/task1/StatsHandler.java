package edu.hw9.task1;

import java.util.concurrent.Callable;
import java.util.stream.DoubleStream;

public class StatsHandler implements Callable<Metric> {

    private final String metricName;
    private final double[] numbers;

    public StatsHandler(String metricName, double[] numbers) {
        this.metricName = metricName;
        this.numbers = numbers;
    }

    @Override
    public Metric call() throws Exception {
        Double sum = sum();
        Double average = average();
        Double max = max();
        Double min = min();
        return new Metric(metricName, sum, average, max, min);
    }

    private Double sum() {
        return DoubleStream.of(numbers).sum();
    }

    private Double average() {
        return DoubleStream.of(numbers).average().getAsDouble();
    }

    private Double max() {
        return DoubleStream.of(numbers).max().getAsDouble();
    }

    private Double min() {
        return DoubleStream.of(numbers).min().getAsDouble();
    }
}
