package edu.hw1;

public class Task1 {

    public int minutesToSeconds(String minutesAndSeconds) {
        int minutes = Integer.parseInt(minutesAndSeconds.split(":")[0]);
        int seconds = Integer.parseInt(minutesAndSeconds.split(":")[1]);
        final int SECONDS_IN_MINUTE = 60;
        if (seconds >= SECONDS_IN_MINUTE) {
            return -1;
        }
        int result = SECONDS_IN_MINUTE * minutes + seconds;
        return result;
    }
}
