package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class HackerNewsTest {

    @Test
    void hackerNewsTopStoriesTest() {
        assertThat(HackerNews.hackerNewsTopStories()).isNotEmpty();
    }

    @Test
    void newsTest() {
        assertThat(HackerNews.news(38352484L)).isEqualTo("After Boeing declines to pay up, ransomware group leaks 45 GB of data");
    }

}
