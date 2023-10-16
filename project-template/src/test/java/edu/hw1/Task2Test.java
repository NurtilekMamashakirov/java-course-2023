package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void countNumbers() {
        int expected = 5;
        int actual = Task2.countNumbers(57432);
        assertEquals(expected, actual);
    }
}
