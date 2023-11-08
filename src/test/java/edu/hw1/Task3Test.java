package edu.hw1;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

class Task3Test {

    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0}, true),
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3}, false)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void arrayInArray(int[] firstArray, int[] secondArray, boolean expected) {
        Task3 task = new Task3();
        assertThat(task.isNestable(firstArray, secondArray)).isEqualTo(expected);
    }
}
