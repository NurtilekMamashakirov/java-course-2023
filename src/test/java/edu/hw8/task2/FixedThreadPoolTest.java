package edu.hw8.task2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FixedThreadPoolTest {
    @Test
    void test() throws Exception {
        List<Long> expected = List.of(8L, 13L);
        List<Long> actual = new CopyOnWriteArrayList<>();
        FixedThreadPool threadPool = FixedThreadPool.create(10);
        for (int i = 6; i < 8; i++) {
            final int numFinal = i;
            threadPool.execute(() -> {
                    actual.add(Fibonacci.getFibonacci(numFinal));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            );
        }
        threadPool.start();
        Thread.sleep(1000);
        threadPool.close();
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);

    }

}
