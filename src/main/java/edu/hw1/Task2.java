package edu.hw1;

public class Task2 {

    public static int countDigits(int number) {
        int count = 1;
        while ((number / 10) != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }
}
