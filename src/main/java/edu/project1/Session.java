package edu.project1;

import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, char[] userAnswer, int maxAttempts, int attempts) {
        this.answer = answer;
        this.userAnswer = userAnswer;
        this.maxAttempts = maxAttempts;
        this.attempts = attempts;
    }

    @NotNull
    GuessResult guess(char guess) {
        boolean successfulGuess = false;
        for (char symbolOfAnswer : answer.toCharArray()) {
            if (symbolOfAnswer == guess) {
                successfulGuess = true;
            }
        }
        return null;
    }

    @NotNull
    GuessResult giveUp() {
        return null;
    }
}
