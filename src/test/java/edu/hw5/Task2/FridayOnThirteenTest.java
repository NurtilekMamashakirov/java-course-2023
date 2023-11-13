package edu.hw5.Task2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FridayOnThirteenTest {

    @Test
    public void testFindFridayThe13ths() {
        List<LocalDate> fridayThe13ths = FridayOnThirteen.findFridayThe13ths(2024);
        assertEquals(2, fridayThe13ths.size());
        assertEquals(LocalDate.of(2024, 9, 13),
            fridayThe13ths.get(0));
        assertEquals(LocalDate.of(2024, 12, 13),
            fridayThe13ths.get(1));
    }

    @Test
    public void testFindNextFridayThe13th() {
        LocalDate nextFridayThe13th =
            FridayOnThirteen.findNextFridayThe13th();
        assertEquals(LocalDate.of(2024, 9, 13), nextFridayThe13th);

    }
}
