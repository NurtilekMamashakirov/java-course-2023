package edu.hw1;

public class Task2 {

    private Task2() {

    }

    public static int countDigits(int number) {
        int count = 1;
        final int NUMBER_TEN = 10;
        int numberToCount = number;
        while ((numberToCount / NUMBER_TEN) != 0) {
            numberToCount = numberToCount / NUMBER_TEN;
            count++;
        }
        return count;
    }
}
