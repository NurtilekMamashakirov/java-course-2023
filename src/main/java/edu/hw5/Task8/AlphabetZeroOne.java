package edu.hw5.Task8;

import java.util.regex.Pattern;

public class AlphabetZeroOne {

    private AlphabetZeroOne() {}

    public final static Pattern PATTERN_NOT_EVEN =
        Pattern.compile("^(00|01|10|11)*[01]$");

    public final static Pattern PATTERN_START_ONE_OR_TWO =
        Pattern.compile("^(0(00|11|01|10)*|1(00|11|01|10)*[01])$");

    public final static Pattern PATTERN_THREE_OF_ZERO =
        Pattern.compile("^(1*01*01*01*)*$");

    public final static Pattern PATTERN_EXCEPT =
        Pattern.compile("^(?!11$|111$)[01]*$");
}
