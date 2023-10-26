package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of(11211230, true),
            Arguments.of(13001120, true),
            Arguments.of(23336014, true),
            Arguments.of(11, true)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void isPalindromeDescendant(Integer example, Boolean expected) {
        assertThat(Task5.isPalindromeDescendant(example)).isEqualTo(expected);
    }
}
