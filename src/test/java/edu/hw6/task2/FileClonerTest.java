package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FileClonerTest {

    Path pathOfTestFile = Path.of("src/test/java/edu/hw6/task2/resources/lo.txt");
    Path pathOfRecoursesDirectory = Path.of("src/test/java/edu/hw6/task2/resources");

    @Test
    void cloneFileTest() throws IOException {
        FileCloner.cloneFile(pathOfTestFile);
        FileCloner.cloneFile(pathOfTestFile);

        boolean cloneOneExist = false;
        boolean cloneTwoExist = false;

        List<Path> filesInRecourses = Files.list(pathOfRecoursesDirectory).toList();
        for (Path file: filesInRecourses) {
            if (file.getFileName().toString().equals("lo - копия.txt")) {
                cloneOneExist = true;
            }
            if (file.getFileName().toString().equals("lo - копия (2).txt")) {
                cloneTwoExist = true;
            }
        }

        assertThat(cloneOneExist).isTrue();
        assertThat(cloneTwoExist).isTrue();

        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task2/resources/lo - копия.txt"));
        Files.deleteIfExists(Path.of("src/test/java/edu/hw6/task2/resources/lo - копия (2).txt"));
    }

}
