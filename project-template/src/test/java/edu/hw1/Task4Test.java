package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void fixStrings() {
        String expected = "This is a mixed up string.";
        String actual = Task4.fixStrings("hTsii  s aimex dpus rtni.g");
        assertEquals(expected, actual);
    }
}
