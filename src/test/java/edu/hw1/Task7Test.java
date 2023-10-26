package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void rotateRight() {
        assertEquals(Task7.rotateRight(8,1), 4);
    }

    @Test
    void rotateLeft() {
        assertAll(
            () -> assertEquals(Task7.rotateLeft(16,1), 1),
            () -> assertEquals(Task7.rotateLeft(17,2), 6)
            );
    }
}
