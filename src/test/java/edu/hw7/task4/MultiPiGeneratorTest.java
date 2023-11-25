package edu.hw7.task4;

import edu.hw7.task4.forMulti.MultiPiGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiPiGeneratorTest {

    @Test
    void generatePiTest() {
        MultiPiGenerator multiPiGenerator = new MultiPiGenerator();
        assertThat(Math.abs(multiPiGenerator.generatePi(1000000) - Math.PI) < 0.1).isTrue();
    }

}
