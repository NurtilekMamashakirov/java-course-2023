package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void arrayInArray() {
        assertAll(
            () -> assertEquals(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}), true),
            () -> assertEquals(Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}), true),
            () -> assertEquals(Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}), false),
            () -> assertEquals(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}), false)
        );
    }
}
