package edu.project1;

import org.jetbrains.annotations.NotNull;

interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    record Defeat() implements GuessResult {
        @Override
        public char[] state() {
            return new char[0];
        }

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return null;
        }
    }
    record Win() implements GuessResult {
        @Override
        public char[] state() {
            return new char[0];
        }

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return null;
        }
    }
    record SuccessfulGuess() implements GuessResult {
        @Override
        public char[] state() {
            return new char[0];
        }

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return null;
        }
    }
    record FailedGuess() implements GuessResult {
        @Override
        public char[] state() {
            return new char[0];
        }

        @Override
        public int attempt() {
            return 0;
        }

        @Override
        public int maxAttempts() {
            return 0;
        }

        @Override
        public @NotNull String message() {
            return null;
        }
    }
}
