package edu.hw5.Task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabetZeroOne {

    private AlphabetZeroOne() {}

    private final static Pattern PATTERN_ONE = Pattern.compile("^[01]{2}0[01]+$");
    private final static Pattern PATTERN_TWO = Pattern.compile("^(.).*\\1$");
    private final static Pattern PATTERN_THREE = Pattern.compile("^[01]{1,3}$");

    public static Boolean checkPatternOne(String string) {
        Matcher matcher = PATTERN_ONE.matcher(string);
        return matcher.matches();
    }

    public static Boolean checkPatternTwo(String string) {
        Matcher matcher = PATTERN_TWO.matcher(string);
        return matcher.matches();
    }

    public static Boolean checkPatternThree(String string) {
        Matcher matcher = PATTERN_THREE.matcher(string);
        return matcher.matches();
    }
}
