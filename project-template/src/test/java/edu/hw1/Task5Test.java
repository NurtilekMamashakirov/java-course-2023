package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void isPalindromeDescendant() {
        assertAll(
            () -> assertEquals(Task5.isPalindromeDescendant(11211230), true),
            () -> assertEquals(Task5.isPalindromeDescendant(13001120), true),
            () -> assertEquals(Task5.isPalindromeDescendant(23336014), true),
            () -> assertEquals(Task5.isPalindromeDescendant(11), true)
        );
    }
}
