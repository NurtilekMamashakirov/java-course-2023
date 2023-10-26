package edu.project1;

import java.util.Scanner;

public class NoOOP {
    public static void run() {
        Dictionary dictionary = new Dictionary.RandomWord(new String[] {"Hello", "Rockstar", "Laptop", "Building"});
        char[] word = dictionary.randomWord().toCharArray();
        char[] wordForOutput = new char[word.length];
        for (int i = 0; i < word.length; i++) {
            wordForOutput[i] = '*';
        }
        int attempts = 0;
        int maxAttempts = 7;
        boolean gameIsOn = true;
        while (gameIsOn) {
            System.out.println("Guess a letter.");
            char guessedLetter = new Scanner(System.in).next().charAt(0);
            boolean successfulGuess = false;
            for (char symbol : word) {
                if (symbol == guessedLetter)
                    successfulGuess = true;
            }
            if (successfulGuess) {
                System.out.println("Hit!");
                for (int i = 0; i < wordForOutput.length; i++) {
                    if (word[i] == guessedLetter)
                        wordForOutput[i] = word[i];
                }
            } else {

            }

            
        }
    }

    public static void main(String[] args) {
        run();
    }
}
