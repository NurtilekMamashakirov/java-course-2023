package edu.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    Task1 task1 = new Task1();

    static Arguments[] exampleAndExpected() {
        return new Arguments[]{
            Arguments.of("Hello world!", "Svool dliow!"),
            Arguments.of("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler",
                "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi")
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void atbashTest(String example, String expected) {
        assertThat(task1.atbash(example)).isEqualTo(expected);
    }
}
