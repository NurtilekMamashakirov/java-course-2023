package edu.hw1;

public class Task3 {

    public boolean isNestable(int[] a1, int[] a2) {
        final int BIG_NUMBER = 1000000000;
        final int SMALL_NUMBER = -1000000000;

        int minA1 = BIG_NUMBER;
        int maxA1 = SMALL_NUMBER;
        int minA2 = BIG_NUMBER;
        int maxA2 = SMALL_NUMBER;
        for (int k : a1) {
            minA1 = Math.min(minA1, k);
            maxA1 = Math.max(maxA1, k);
        }
        for (int j : a2) {
            minA2 = Math.min(minA2, j);
            maxA2 = Math.max(maxA2, j);
        }
        return minA1 > minA2 && maxA1 < maxA2;
    }
}
