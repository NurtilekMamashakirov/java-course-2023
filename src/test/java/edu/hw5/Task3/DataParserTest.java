package edu.hw5.Task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class DataParserTest {

    static Arguments[] examplesAndExpected() {
        return new Arguments[] {
            Arguments.of("2020-10-10", LocalDate.of(2020, 10, 10)),
            Arguments.of("1/3/1976", LocalDate.of(1976, 3, 1)),
            Arguments.of("today", LocalDate.now()),
            Arguments.of("yesterday", LocalDate.now().minusDays(1)),
            Arguments.of("40 days ago", LocalDate.now().minusDays(40))
        };
    }

    @ParameterizedTest
    @MethodSource("examplesAndExpected")
    void testParseDate(String stringDate, LocalDate expectedDate) {
        LocalDate actualDate = DateParser.parseDate(stringDate).get();
        assertThat(actualDate).isEqualTo(expectedDate);
    }
}



