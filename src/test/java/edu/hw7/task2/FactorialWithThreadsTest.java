package edu.hw7.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FactorialWithThreadsTest {

    static Arguments[] exampleAndExpected() {
        return new Arguments[] {
            Arguments.of(3, 6),
            Arguments.of(4, 24),
            Arguments.of(5, 120),
            Arguments.of(1, 1),
            Arguments.of(0, 1)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void factorialTest(int example, int expected) {
        int actual = FactorialWithThreads.factorial(example);
        assertThat(actual).isEqualTo(expected);
    }

}
