package edu.hw9.task2;

import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesTreeWalkerTest {

    @Test
    void findDirectoriesWithMore1000FilesTest() {
        Path path = Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023");
        List<Path> expected =
            List.of(Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023/src/test/resources/1000 файлов"));
        List<Path> actual = FilesTreeWalker.findDirectoriesWithMore1000Files(path);
        assertThat(actual).containsAll(expected);
    }

    @Test
    void findByFileSizeTest() {
        Path path = Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023");
        List<Path> expected = List.of(Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023/.git/COMMIT_EDITMSG"));
        List<Path> actual = FilesTreeWalker.findByFileSize(path, 1L, 15L);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findByFileExtensionTest() {
        Path path = Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023");
        assertThat(FilesTreeWalker.findByFileExtension(path, ".xml")).contains(Path.of(
            "/Users/nurtilekm/IdeaProjects/java-course-2023/checkstyle.xml"),
            Path.of("/Users/nurtilekm/IdeaProjects/java-course-2023/pom.xml"));
    }

}
