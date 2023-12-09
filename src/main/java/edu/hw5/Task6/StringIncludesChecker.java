package edu.hw5.Task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringIncludesChecker {

    private StringIncludesChecker() {
    }

    public static Boolean stringInclude(String bigString, String smallString) {
        Pattern pattern = Pattern.compile(smallString);
        Matcher matcher = pattern.matcher(bigString);
        return matcher.find();
    }

}
