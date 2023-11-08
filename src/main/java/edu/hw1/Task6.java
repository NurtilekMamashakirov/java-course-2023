package edu.hw1;

import java.util.Arrays;

public class Task6 {

    public static int countK(int number, int count) {
        String numberStr = String.valueOf(number);
        int[] arrayOfNumber = new int[numberStr.length()];
        for (int i = 0; i < arrayOfNumber.length; i++) {
            arrayOfNumber[i] = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        int[] progressNumber = arrayOfNumber;
        Arrays.sort(progressNumber);
        int[] regressNumber = new int[numberStr.length()];
        for (int i = progressNumber.length - 1; i >= 0; i--) {
            regressNumber[i] = progressNumber[Math.abs(i + 1 - progressNumber.length)];
        }
        int number1 = 0;
        String number1Str = "";
        int number2 = 0;
        String number2Str = "";
        for (int i = 0; i < progressNumber.length; i++) {
            number1Str += String.valueOf(progressNumber[i]);
            number2Str += String.valueOf(regressNumber[i]);
        }
        number1 = Integer.parseInt(number1Str);
        number2 = Integer.parseInt(number2Str);

        int ans = number2 - number1;

        if (ans == 6174)
            return count;
        else
            return countK(ans, count + 1);
    }
}
