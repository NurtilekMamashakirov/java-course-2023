package edu.hw7.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ThreadsStarterTest {

    @Test
    void startPlussingTest() {
        assertThat(new ThreadStarter().startThreads()).isEqualTo(3000);
    }

}
