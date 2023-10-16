package edu.hw1;

public class Task5 {

    public static boolean palindrom(int number) {
        String numberStr = String.valueOf(number);
        while (true) {
            if (numberStr.length() % 2 == 1)
                return false;
            else {
                int j = numberStr.length() - 1;
                boolean flag = true;
                for (int i = 0; i < numberStr.length(); i++) {
                    if (numberStr.charAt(i) != numberStr.charAt(j))
                        flag = false;
                }
                if (flag)
                    return true;

                String newNumberStr = "";
                for (int i = 0; i < newNumberStr.length(); i = i + 2) {
                    newNumberStr += String.valueOf(Integer.parseInt(String.valueOf(numberStr.charAt(i))) + Integer.parseInt(String.valueOf(numberStr.charAt(i + 1))));
                }
                numberStr = newNumberStr;
            }
        }
    }
}
