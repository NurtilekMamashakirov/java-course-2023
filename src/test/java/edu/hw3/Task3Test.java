package edu.hw3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    static Arguments[] exampleAndExpected() {
        HashMap<String, Integer> dict1 = new HashMap<>();
        dict1.put("bb", 2);
        dict1.put("a", 2);
        HashMap<String, Integer> dict2 = new HashMap<>();
        dict2.put("that", 1);
        dict2.put("and", 2);
        dict2.put("this", 1);
        HashMap<String, Integer> dict3 = new HashMap<>();
        dict3.put("код", 3);
        dict3.put("bug", 1);
        HashMap<Integer, Integer> dict4 = new HashMap<>();
        dict4.put(1, 2);
        dict4.put(2, 2);

        return new Arguments[]{
            Arguments.of(List.of("a", "bb", "a", "bb"), dict1),
            Arguments.of(List.of("this", "and", "that", "and"), dict2),
            Arguments.of(List.of("код", "код", "код", "bug"), dict3),
            Arguments.of(List.of(1, 1, 2, 2), dict4)
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void freqDictTest(List dict, Map freqDict) {
        Task3 task3 = new Task3();
        assertThat(task3.freqDict(dict)).isEqualTo(freqDict);
    }
}
