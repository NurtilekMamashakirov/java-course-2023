package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    static Arguments[] numAndExpected() {
        return new Arguments[]{
            Arguments.of(4666, 4),
            Arguments.of(544, 3),
            Arguments.of(0, 1)
        };
    }

    @ParameterizedTest
    @MethodSource("numAndExpected")
    void countNumbers(Integer num, Integer expected) {
        Task2 task = new Task2();
        assertThat(task.countDigits(num)).isEqualTo(expected);
    }
}
