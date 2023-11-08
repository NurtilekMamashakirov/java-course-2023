package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of("123456", "214365"),
            Arguments.of("hTsii  s aimex dpus rtni.g", "This is a mixed up string."),
            Arguments.of("badce", "abcde")
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void fixStrings(String example, String expected) {
        Task4 task = new Task4();
        assertThat(task.fixStrings(example)).isEqualTo(expected);
    }
}
