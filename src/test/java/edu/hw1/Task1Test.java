package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    @Test
    void minutesToSeconds() {
        assertAll(
            () -> assertEquals(Task1.minutesToSeconds("1:00"), 60),
            () -> assertEquals(Task1.minutesToSeconds("13:56"), 836),
            () -> assertEquals(Task1.minutesToSeconds("10:60"), -1)
            );

    }
}
