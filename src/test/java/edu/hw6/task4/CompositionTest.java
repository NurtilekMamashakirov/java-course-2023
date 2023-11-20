package edu.hw6.task4;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

public class CompositionTest {

    @Test
    void composeTest() throws IOException {
        Composition.compose("src/test/java/edu/hw6/task4/resources/ForTest");

        String expectedMessage = "Programming is learned by writing programs. ― Brian Kernighan";

        Path file = Path.of("src/test/java/edu/hw6/task4/resources/ForTest");
        assertThat(expectedMessage).isEqualTo(Files.readString(file));
    }

}
