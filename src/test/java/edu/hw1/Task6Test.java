package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {
    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of(6621, 5),
            Arguments.of(6554, 4),
            Arguments.of(1234, 3)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void countK(Integer example, Integer expected) {
        assertThat(Task6.countK(example,1)).isEqualTo(expected);
    }
}
