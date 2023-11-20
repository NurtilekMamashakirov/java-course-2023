package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static edu.hw6.task3.AbstractFilter.globMatches;
import static edu.hw6.task3.AbstractFilter.largerThan;
import static org.assertj.core.api.Assertions.assertThat;

public class AbstractFilterTest {

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;

    @Test
    void test() {
        Set<Path> expected = Set.of(
            Path.of("src/test/java/edu/hw6/task3/recourses/example3.txt"),
            Path.of("src/test/java/edu/hw6/task3/recourses/example4.txt")
        );

        DirectoryStream.Filter<Path> filter = regularFile
            .and(regularFile)
            .and(largerThan(0))
            .and(readable)
            .and(globMatches("*.txt"));

        Set<Path> actual = new HashSet<>();

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get(
            "src/test/java/edu/hw6/task3/recourses"), filter)) {
            Iterator<Path> iterator = entries.iterator();
            while (iterator.hasNext()) {
                actual.add(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertThat(expected).isEqualTo(actual);

    }
}
