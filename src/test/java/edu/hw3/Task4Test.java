package edu.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    static Arguments[] exampleAndExpected() {
        return new Arguments[] {
           Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI"),
            Arguments.of(97, "XCVII"),
            Arguments.of(146, "CXLVI"),
            Arguments.of(533, "DXXXIII")
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void convertToRomanTest(Integer num, String roman) {
        Task4 task4 = new Task4();
        assertThat(task4.convertToRoman(num)).isEqualTo(roman);
    }

}
