package edu.hw3.Task7;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorTest {

    @Test
    void comparatorTest() {
        TreeMap<String, String> tree = new TreeMap<>(new Comparator());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
