package edu.hw6.task6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PortCheckerTest {

    @Test
    void checkPortTest() {
        assertThrows(IllegalArgumentException.class, () -> PortChecker.checkPort(1, "wrong protocol"));
    }

    @SuppressWarnings("MagicNumber")
    static Arguments[] examplesAndExpected() {
        return new Arguments[] {
            Arguments.of(1, ""),
            Arguments.of(135, "EPMAP"),
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpected")
    void checkGetServiceName(int port, String name) {
        assertThat(PortChecker.getServiceName(port)).isEqualTo(name);
    }

}
