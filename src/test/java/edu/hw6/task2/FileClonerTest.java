package edu.hw6.task2;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;

public class FileClonerTest {

    @Test
    void cloneFileTest() {
        FileCloner.cloneFile(Paths.get("/Users/nurtilekm/Desktop/Презентации по лекцимя тинькофф/лекция 6.pdf"));
    }

}
