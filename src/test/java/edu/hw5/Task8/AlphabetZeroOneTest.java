package edu.hw5.Task8;

import java.util.regex.Matcher;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class AlphabetZeroOneTest {

    static Arguments[] exampleAndExpected1() {
        return new Arguments[] {
            Arguments.of("10010", true),
            Arguments.of("100100", false)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected1")
    void patternEvenTest(String example, boolean expected) {
        Matcher matcher = AlphabetZeroOne.PATTERN_NOT_EVEN.matcher(example);
        assertThat(matcher.matches()).isEqualTo(expected);
    }

    static Arguments[] exampleAndExpected2() {
        return new Arguments[] {
            Arguments.of("00010", true),
            Arguments.of("100100", true),
            Arguments.of("000100", false),
            Arguments.of("1000100", false),
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected2")
    void patternStartOneOrTwoTest(String example, boolean expected) {
        Matcher matcher = AlphabetZeroOne.PATTERN_START_ONE_OR_TWO.matcher(example);
        assertThat(matcher.matches()).isEqualTo(expected);
    }

    static Arguments[] exampleAndExpected3() {
        return new Arguments[] {
            Arguments.of("00010", false),
            Arguments.of("10010000", true),
            Arguments.of("000100", false),
            Arguments.of("10001", true),
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected3")
    void patternThreeOfZeroTest(String example, boolean expected) {
        Matcher matcher = AlphabetZeroOne.PATTERN_THREE_OF_ZERO.matcher(example);
        assertThat(matcher.matches()).isEqualTo(expected);
    }

    static Arguments[] exampleAndExpected4() {
        return new Arguments[] {
            Arguments.of("11", false),
            Arguments.of("111", false),
            Arguments.of("000100", true),
            Arguments.of("10001", true),
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected4")
    void patternExceptTest(String example, boolean expected) {
        Matcher matcher = AlphabetZeroOne.PATTERN_EXCEPT.matcher(example);
        assertThat(matcher.matches()).isEqualTo(expected);
    }

}
