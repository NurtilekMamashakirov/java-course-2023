package edu.hw8.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {

    static Arguments[] examplesAndActual() {
        return new Arguments[]{
            Arguments.of(3, 2L),
            Arguments.of(8, 21L),
            Arguments.of(9, 34L),
            Arguments.of(10, 55L)
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndActual")
    void getFibonacciTest(int example, long expected) {
        assertThat(Fibonacci.getFibonacci(example)).isEqualTo(expected);
    }

}
