package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void rotateRight() {
        Task7 task = new Task7();
        assertThat(task.rotateRight(8, 1)).isEqualTo(4);
    }

    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of(16, 1, 1),
            Arguments.of(17,2,6)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void rotateLeft(Integer num, Integer shift, Integer expected) {
        Task7 task = new Task7();
        assertThat(task.rotateLeft(num, shift)).isEqualTo(expected);
    }
}
