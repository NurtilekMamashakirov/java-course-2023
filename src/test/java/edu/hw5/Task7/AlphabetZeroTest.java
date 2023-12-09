package edu.hw5.Task7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class AlphabetZeroTest {

    static Arguments[] examplesAndExpectedForOne() {
        return new Arguments[] {
            Arguments.of("10001", true),
            Arguments.of("0010101", false),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpectedForOne")
    void checkPatternOneTest(String example, boolean expected) {
        boolean actual = AlphabetZeroOne.checkPatternOne(example);
        assertThat(actual).isEqualTo(expected);
    }

    static Arguments[] examplesAndExpectedForTwo() {
        return new Arguments[] {
            Arguments.of("10001", true),
            Arguments.of("010101", false),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpectedForTwo")
    void checkPatternTwoTest(String example, boolean expected) {
        boolean actual = AlphabetZeroOne.checkPatternTwo(example);
        assertThat(actual).isEqualTo(expected);
    }

    static Arguments[] examplesAndExpectedForThree() {
        return new Arguments[] {
            Arguments.of("100", true),
            Arguments.of("010101", false),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpectedForThree")
    void checkPatternThreeTest(String example, boolean expected) {
        boolean actual = AlphabetZeroOne.checkPatternThree(example);
        assertThat(actual).isEqualTo(expected);
    }

}
