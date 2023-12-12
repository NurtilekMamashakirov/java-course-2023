package edu.hw7.task2;

import java.util.stream.IntStream;

public class FactorialWithThreads {

    private FactorialWithThreads() {
    }

    public static int factorial(int number) {
        int sum = IntStream.rangeClosed(1, number).reduce(1, (a, b) -> a * b);
        return sum;
    }

}
