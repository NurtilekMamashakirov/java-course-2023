package edu.hw6.task5;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class HackerNewsTest {

    @Test
    void hackerNewsTopStoriesTest() {
        System.out.println(Arrays.toString(HackerNews.hackerNewsTopStories()));
    }

    @Test
    void newsTest() {
        for (long id: HackerNews.hackerNewsTopStories()) {
            System.out.println(HackerNews.news(id));
        }
    }

}
