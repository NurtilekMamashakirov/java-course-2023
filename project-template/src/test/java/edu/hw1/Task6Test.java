package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void countK() {
        int expected = 5;
        int actual = Task6.countK(6621, 1);
        assertEquals(expected, actual);
    }
}
