package edu.hw1;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Task1Test {
    static Arguments[] timeAndExpected() {
        return new Arguments[] {
            Arguments.of("01:00", 60),
            Arguments.of("13:56", 836),
            Arguments.of("10:60", -1)
        };
    }

    @ParameterizedTest
    @MethodSource("timeAndExpected")
    void minutesToSeconds(String time, Integer expected) {
        assertThat(Task1.minutesToSeconds(time)).isEqualTo(expected);
    }
}
