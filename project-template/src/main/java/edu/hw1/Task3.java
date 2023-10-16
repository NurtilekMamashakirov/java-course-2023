package edu.hw1;

public class Task3 {

    public static boolean arrayInArray(int[] a1, int[] a2) {
        int minA1 = 100000000;
        int maxA1 = -100000000;
        int minA2 = 1000000000;
        int maxA2 = -1000000000;
        for (int i = 0; i < a1.length; i++) {
            minA1 = (minA1 > a1[i]) ? a1[i] : minA1;
            maxA1 = (maxA1 < a1[i]) ? a1[i] : maxA1;
        }
        for (int i = 0; i < a2.length; i++) {
            minA2 = (minA2 > a2[i]) ? a2[i] : minA2;
            maxA2 = (maxA2 < a2[i]) ? a2[i] : maxA2;
        }
        if (minA1 > minA2 && maxA1 < maxA2)
            return true;
        else
            return false;
    }
}
