package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void countNumbers() {
        assertAll(
            () -> assertEquals(Task2.countDigits(4666), 4),
            () -> assertEquals(Task2.countDigits(544), 3),
            () -> assertEquals(Task2.countDigits(0), 1)
        );
    }
}
