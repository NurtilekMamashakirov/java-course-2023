package edu.hw5.Task6;

import edu.hw5.Task4.CheckPassword;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class StringIncludeCheckerTest {

    static Arguments[] examplesAndExpected() {
        return new Arguments[] {
            Arguments.of("fewer", "ewe", true),
            Arguments.of("fewer.fwernnvlwhqlw", "nnv", true),
            Arguments.of("8342fhu3&dek", "bhvwekhhweb", false),
            Arguments.of("~*&jnnd3", "hrweuy3yfu3hd3u", false)
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpected")
    void stringIncludeTest(String exampleBigString, String exampleSmallString, boolean expected) {
        boolean actual = StringIncludesChecker.stringInclude(exampleBigString, exampleSmallString);
        assertThat(actual).isEqualTo(expected);
    }

}
