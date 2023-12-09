package edu.hw5.Task4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckPasswordTest {

    static Arguments[] examplesAndExpected() {
        return new Arguments[]{
            Arguments.of("fewer", false),
            Arguments.of("fewer.fwernnvlwhqlw", false),
            Arguments.of("8342fhu3&dek", true),
            Arguments.of("~*&jnnd3", true),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpected")
    void checkForSymbolsTest(String example, boolean expected) {
        boolean actual = CheckPassword.checkForSymbols(example);
        assertThat(actual).isEqualTo(expected);
    }
}
