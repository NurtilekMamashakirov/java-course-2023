package edu.hw1;

public class Task1 {

    private Task1() {

    }

    public static int minutesToSeconds(String minutesAndSeconds) {
        int minutes = Integer.parseInt(minutesAndSeconds.split(":")[0]);
        int seconds = Integer.parseInt(minutesAndSeconds.split(":")[1]);
        if (seconds >= 60)
            return -1;
        int result = 60 * minutes + seconds;
        return result;
    }
}
