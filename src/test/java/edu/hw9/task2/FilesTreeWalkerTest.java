package edu.hw9.task2;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesTreeWalkerTest {

    @Test
    void findDirectoriesWithMore1000FilesTest() {
        Path path = Path.of("src");
        List<Path> expected =
            List.of(Path.of("src/test/resources/1000 файлов"));
        List<Path> actual = FilesTreeWalker.findDirectoriesWithMore1000Files(path);
        assertThat(actual).containsAll(expected);
    }

    @Test
    void findByFileSizeTest() {
        Path path = Path.of("");
        List<Path> expected = List.of(Path.of("src/main/java/edu/project2/Coordinate.java"));
        List<Path> actual = FilesTreeWalker.findByFileSize(path, 1L, 80L);
        assertThat(actual).containsAll(expected);
    }

    @Test
    void findByFileExtensionTest() {
        Path path = Path.of("");
        assertThat(FilesTreeWalker.findByFileExtension(path, ".xml")).contains(
            Path.of(
                "checkstyle.xml"),
            Path.of("pom.xml")
        );
    }

}
