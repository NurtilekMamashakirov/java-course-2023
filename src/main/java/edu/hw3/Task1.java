package edu.hw3;

import java.util.HashMap;

public class Task1 {

    private final HashMap<Character, Integer> alphabetLowCase = getAlphabetLowCase();
    private final HashMap<Character, Integer> alphabetUpCase = getAlphabetUpCase();

    private HashMap<Character, Integer> getAlphabetLowCase() {
        HashMap<Character, Integer> alphabet = new HashMap<>();
        int lengthOfAlphabet = 26;
        for (int i = 0; i < lengthOfAlphabet; i++) {
            alphabet.put((char) (i + 'a'), i);
        }
        return alphabet;
    }

    private HashMap<Character, Integer> getAlphabetUpCase() {
        int lengthOfAlphabet = 26;
        HashMap<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < lengthOfAlphabet; i++) {
            alphabet.put((char) (i + 'A'), i);
        }
        return alphabet;
    }

    public String atbash(String string) {
        String newString = "";
        int lastSymbolOfFirstPartOfAlphabet = 12;
        int firstSymbolOfSecondPartOfAlphabet = 13;
        for (int i = 0; i < string.length(); i++) {
            Character symbol = string.charAt(i);
            if (symbol <= 'Z' && symbol >= 'A') {
                Integer positionOfSymbol = alphabetUpCase.get(symbol);
                if (positionOfSymbol <= lastSymbolOfFirstPartOfAlphabet) {
                    newString +=
                        (char) (((lastSymbolOfFirstPartOfAlphabet - positionOfSymbol)
                            + firstSymbolOfSecondPartOfAlphabet) + 'A');
                } else {
                    newString += (char) ((lastSymbolOfFirstPartOfAlphabet
                        - (positionOfSymbol - firstSymbolOfSecondPartOfAlphabet)) + 'A');
                }
            } else if (symbol <= 'z' && symbol >= 'a') {
                Integer positionOfSymbol = alphabetLowCase.get(symbol);
                if (positionOfSymbol <= lastSymbolOfFirstPartOfAlphabet) {
                    newString += (char) (((lastSymbolOfFirstPartOfAlphabet
                        - positionOfSymbol) + firstSymbolOfSecondPartOfAlphabet) + 'a');
                } else {
                    newString += (char) ((lastSymbolOfFirstPartOfAlphabet
                        - (positionOfSymbol - firstSymbolOfSecondPartOfAlphabet)) + 'a');
                }
            } else {
                newString += symbol;
            }
        }
        return newString;
    }

}
