package edu.project4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Coefficients {

    private static final int NUM_OF_COEFFICIENTS = 30;
    private static final double MIN = -1.0;
    private static final double MAX = 1.0;
    private static final double MAX_C_F = 3;
    private static final double MIN_C_F = -3;
    private static final int COLOUR_MAX = 255;
    private final List<Coefficient> coefficientList;

    public Coefficients() {
        this.coefficientList = new ArrayList<>();
        generateCoefficients();
    }

    private void generateCoefficients() {
        for (int i = 0; i < NUM_OF_COEFFICIENTS; i++) {
            boolean areCoefficientsCorrect = false;
            double a = 0;
            double b = 0;
            double d = 0;
            double e = 0;
            while (!areCoefficientsCorrect) {
                a = ThreadLocalRandom.current().nextDouble(MIN, MAX);
                b = ThreadLocalRandom.current().nextDouble(MIN, MAX);
                e = ThreadLocalRandom.current().nextDouble(MIN, MAX);
                d = ThreadLocalRandom.current().nextDouble(MIN, MAX);
                areCoefficientsCorrect = checkConditions(a, b, d, e);
            }
            double c = ThreadLocalRandom.current().nextDouble(MIN_C_F, MAX_C_F);
            double f = ThreadLocalRandom.current().nextDouble(MIN_C_F, MAX_C_F);
            int red = ThreadLocalRandom.current().nextInt(0, COLOUR_MAX);
            int green = ThreadLocalRandom.current().nextInt(0, COLOUR_MAX);
            int blue = ThreadLocalRandom.current().nextInt(0, COLOUR_MAX);
            Coefficient coefficient = new Coefficient(a, b, c, d, e, f, red, green, blue);
            coefficientList.add(coefficient);
        }
    }

    private boolean checkConditions(double a, double b, double d, double e) {
        boolean condition1 = a * a + d * d < 1;
        boolean condition2 = b * b + e * e < 1;
        boolean condition3 = a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d);
        return condition1 && condition2 && condition3;
    }

    public List<Coefficient> getCoefficients() {
        return coefficientList;
    }

}
