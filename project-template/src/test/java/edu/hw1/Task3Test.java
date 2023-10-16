package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @Test
    void arrayInArray() {
        boolean expected = true;
        boolean actual = Task3.arrayInArray(new int[]{1,2,3}, new int[]{-1,4,5});
        assertEquals(expected, actual);
    }
}
