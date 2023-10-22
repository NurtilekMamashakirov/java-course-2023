package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void fixStrings() {
        assertAll(
            () -> assertEquals(Task4.fixStrings("123456"), "214365"),
            () -> assertEquals(Task4.fixStrings("hTsii  s aimex dpus rtni.g"), "This is a mixed up string."),
            () -> assertEquals(Task4.fixStrings("badce"), "abcde")
        );
    }
}
