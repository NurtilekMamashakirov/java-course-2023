package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void minutesToSeconds() {
        int expected = 93;
        int actual = Task1.minutesToSeconds("1:33");
        assertEquals(expected, actual);

    }
}
