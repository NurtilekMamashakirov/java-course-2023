package edu.hw3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    Task2 task2 = new Task2();

    static Arguments[] exampleAndExpected() {
        return new Arguments[] {
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void clusterizeTest(String example, List<String> expected) {
        assertThat(task2.clusterize(example)).isEqualTo(expected);
    }
}
