package edu.hw3;

import java.util.HashMap;
import java.util.List;

public class Task3<T extends Object> {

    public HashMap<T, Integer> freqDict(List<T> listOfWords) {
        HashMap<T, Integer> freqDictionary = new HashMap<>();
        for (T word: listOfWords) {
            if (freqDictionary.containsKey(word)) {
                freqDictionary.put(word, freqDictionary.get(word) + 1);
            } else {
                freqDictionary.put(word, 1);
            }
        }
        return freqDictionary;
    }

}
