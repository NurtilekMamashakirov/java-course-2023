package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void countK() {
        assertAll(
            () -> assertEquals(Task6.countK(6621, 1), 5),
            () -> assertEquals(Task6.countK(6554, 1), 4),
            () -> assertEquals(Task6.countK(1234, 1), 3)
        );
    }
}
