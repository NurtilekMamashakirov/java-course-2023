package edu.hw5.Task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPassword {

    private final static Pattern PATTERN = Pattern.compile(".*[~!@#$%^&*|].*");

    public static boolean checkForSymbols(String password) {
        Matcher matcher = PATTERN.matcher(password);
        return matcher.matches();
    }

}
