package edu.hw6.task2;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;

public class FileClonerTest {

    @Test
    void cloneFileTest() {
        FileCloner.cloneFile(Paths.get("src/test/java/edu/hw6/task2/resources/lo.txt"));
    }

}
