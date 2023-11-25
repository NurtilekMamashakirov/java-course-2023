package edu.hw7.task4;

import edu.hw7.task4.forSingle.SinglePiGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class SinglePiGeneratorTest {

    @Test
    void generatePiTest() {
        SinglePiGenerator singlePiGenerator = new SinglePiGenerator();
        assertThat(Math.abs(singlePiGenerator.generatePi(1000000) - Math.PI) < 0.1).isTrue();
    }

}
