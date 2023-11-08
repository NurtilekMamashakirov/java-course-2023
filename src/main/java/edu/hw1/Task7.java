package edu.hw1;

public class Task7 {

    private Task7() {

    }

    public static int rotateRight(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int[] binary2 = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            binary2[(i + shift) % binary.length()] = Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        int c = binary2.length - 1;
        int ans = 0;
        for (int i = 0; i < binary2.length; i++) {
            ans += binary2[i] * Math.pow(2, c);
            c--;
        }
        return ans;
    }

    public static int rotateLeft(int n, int shift) {
        String binary = Integer.toBinaryString(n);
        int[] binary2 = new int[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            binary2[((i - shift + 100000 * binary2.length) % binary2.length) % binary.length()] = Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        int c = binary2.length - 1;
        int ans = 0;
        for (int i = 0; i < binary2.length; i++) {
            ans += binary2[i] * Math.pow(2, c);
            c--;
        }
        return ans;
    }
}
