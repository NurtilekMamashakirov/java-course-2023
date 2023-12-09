package edu.hw3.Task8;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BackwardIteratorTest {

    @Test
    void iteratorTest() {
        List<Integer> numbers = List.of(1,2,3);
        List<Integer> expectedReversedList = List.of(3,2,1);
        List<Integer> actualReversedList = new ArrayList<>();
        BackwardIterator<Integer> iterator = new BackwardIterator<>(numbers);
        while(iterator.hasNext()) {
            actualReversedList.add(iterator.next());
        }
        assertThat(actualReversedList).isEqualTo(expectedReversedList);
    }
}
