package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    @NotNull
    String randomWord();

    record RandomWord(String[] dictionary) implements Dictionary{
        @Override
        public @NotNull String randomWord() {
            return dictionary[(int)(Math.random() * dictionary.length)];
        }

    }
}
