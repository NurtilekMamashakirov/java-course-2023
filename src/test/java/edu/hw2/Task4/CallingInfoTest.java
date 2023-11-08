package edu.hw2.Task4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CallingInfoTest {

    @Test
    void callingInfoTest() {
        assertEquals(new CallingInfo("CallingInfoTest", "callingInfoTest"), CallingInfo.callingInfo());
    }
}
