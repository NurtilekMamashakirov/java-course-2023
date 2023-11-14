package edu.hw5.Task5;

import edu.hw5.Task4.CheckPassword;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class CarNumberCheckerTest {

    static Arguments[] examplesAndExpected() {
        return new Arguments[]{
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123ВГ77", false),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpected")
    void checkForSymbolsTest(String example, boolean expected) {
        boolean actual = CarNumberChecker.checkCarNumber(example);
        assertThat(actual).isEqualTo(expected);
    }

}
