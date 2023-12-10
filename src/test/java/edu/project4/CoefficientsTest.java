package edu.project4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CoefficientsTest {

    @Test
    void generateCoefficientsTest() {
        Coefficients coefficients = new Coefficients();
        List<Coefficient> coefficientList = coefficients.getCoefficients();
        for (Coefficient coefficient: coefficientList) {
            double a = coefficient.a();
            double b = coefficient.b();
            double d = coefficient.d();
            double e = coefficient.e();
            boolean condition1 = a * a + d * d < 1;
            boolean condition2 = b * b + e * e < 1;
            boolean condition3 = a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d);
            assertThat(condition1 && condition2 && condition3).isTrue();
        }
    }

}
