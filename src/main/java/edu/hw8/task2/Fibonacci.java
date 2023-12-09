package edu.hw8.task2;

public class Fibonacci {

    private Fibonacci() {}

    public static long getFibonacci(int n) {
        long num1 = 0;
        long num2 = 1;
        if (n == 0) {
            return num1;
        }
        if (n == 1) {
            return num2;
        }
        for (int i = 2; i <= n; i++) {
            if (num1 >= num2) {
                num2 = num1 + num2;
            } else {
                num1 = num1 + num2;
            }
        }
        return Math.max(num1, num2);
    }

}
