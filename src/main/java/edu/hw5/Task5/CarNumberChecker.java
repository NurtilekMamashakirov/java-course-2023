package edu.hw5.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumberChecker {

    private CarNumberChecker() {}

    private final static Pattern PATTERN =
        Pattern.compile("^([АВЕКМНОРСТУХ])\\d{3}([АВЕКМНОРСТУХ]){2}\\d{2,3}$");

    public static boolean checkCarNumber(String carNumber) {
        Matcher matcher = PATTERN.matcher(carNumber);
        return matcher.matches();
    }

}
