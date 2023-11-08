package edu.hw3;

import java.util.HashMap;

public class Task1 {

    private final HashMap<Character, Integer> alphabetLowCase = getAlphabetLowCase();
    private final HashMap<Character, Integer> alphabetUpCase = getAlphabetUpCase();

    private HashMap<Character, Integer> getAlphabetLowCase() {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabet.put(Character.valueOf((char) (i + 97)), i);
        }
        return alphabet;
    }

    private HashMap<Character, Integer> getAlphabetUpCase() {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabet.put(Character.valueOf((char) (i + 65)), i);
        }
        return alphabet;
    }

    public String atbash(String string) {
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            Character symbol = string.charAt(i);
            if (symbol <= 90 && symbol >= 65) {
                Integer positionOfSymbol = alphabetUpCase.get(symbol);
                if (positionOfSymbol <= 12) {
                    newString += (char) (((12 - positionOfSymbol) + 13) + 65);
                } else {
                    newString += (char) ((12 - (positionOfSymbol - 13)) + 65);
                }
            } else if (symbol <= 122 && symbol >= 97) {
                Integer positionOfSymbol = alphabetLowCase.get(symbol);
                if (positionOfSymbol <= 12) {
                    newString += (char) (((12 - positionOfSymbol) + 13) + 97);
                } else {
                    newString += (char) ((12 - (positionOfSymbol - 13)) + 97);
                }
            } else {
                newString += symbol;
            }
        }
        return newString;
    }

}
