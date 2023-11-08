package edu.hw3;

import java.util.List;

public class Task4 {

    public String convertToRoman(Integer num) {
        List<Integer> values = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        List<String> romanLetters = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            while (num >= values.get(i)) {
                num = num - values.get(i);
                roman.append(romanLetters.get(i));
            }
        }
        return roman.toString();
    }
}
