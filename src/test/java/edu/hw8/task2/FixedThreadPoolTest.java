package edu.hw8.task2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FixedThreadPoolTest {
    @Test
    void test() throws Exception {
        List<Long> expected = List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L);
        List<Long> actual = new CopyOnWriteArrayList<>();
        FixedThreadPool threadPool = FixedThreadPool.create(10);
        for (int i = 0; i < 10; i++) {
            final int numFinal = i;
            threadPool.execute(() ->
                actual.add(Fibonacci.getFibonacci(numFinal))
            );
        }
        threadPool.start();
        Thread.sleep(1000);
        threadPool.close();
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}
