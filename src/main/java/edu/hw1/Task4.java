package edu.hw1;

public class Task4 {
    public static String fixStrings(String str) {
        String fixedString = "";
        if (str.length() % 2 == 0) {
            for (int i = 0; i < str.length() - 1; i = i + 2) {
                fixedString = fixedString + str.charAt(i + 1) + str.charAt(i);
            }
        } else {
            for (int i = 0; i < str.length() - 2; i = i + 2) {
                fixedString = fixedString + str.charAt(i + 1) + str.charAt(i);
            }
            fixedString += str.charAt(str.length() - 1);
        }
        return fixedString;
    }
}
