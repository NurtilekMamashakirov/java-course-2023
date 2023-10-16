package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @Test
    void palindrom() {
        boolean expected = true;
        boolean actual = Task5.palindrom(11211230);
        assertEquals(expected, actual);
    }
}
