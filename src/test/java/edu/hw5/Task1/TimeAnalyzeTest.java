package edu.hw5.Task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeAnalyzeTest {

    @Test
    void wrongFormatTest() {
        String wrongFormat = "wvwtwqvrevwce";
        TimeAnalyze timeAnalyze = new TimeAnalyze();
        assertThrows(IllegalArgumentException.class, () -> timeAnalyze.analyzeTime(wrongFormat));
    }

    @Test
    void timeAnalyzeTest() {
        TimeAnalyze timeAnalyze = new TimeAnalyze();
        String expected = "3ч 40м";
        String actual = timeAnalyze.analyzeTime(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );
        assertThat(actual).isEqualTo(expected);
    }
}
