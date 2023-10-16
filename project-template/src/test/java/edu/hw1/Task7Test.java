package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void rotateRight() {
        int expected = 4;
        int actual = Task7.rotateRight(8,1);
        assertEquals(expected, actual);
    }

    @Test
    void rotateLeft() {
        int expected = 1;
        int actual = Task7.rotateLeft(16,1);
        assertEquals(expected, actual);
    }
}
