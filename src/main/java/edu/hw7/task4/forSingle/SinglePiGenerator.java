package edu.hw7.task4.forSingle;

import edu.hw7.task4.PiGenerator;

public class SinglePiGenerator implements PiGenerator {

    private final SquareWithCircle squareWithCircle = new SquareWithCircle();
    private final static int COEFFICIENT = 4;

    @Override
    public double generatePi(int simulations) {
        for (int i = 0; i < simulations; i++) {
            squareWithCircle.addPoint();
        }
        return COEFFICIENT * (double) squareWithCircle.getCircleCount() / (double) squareWithCircle.getTotalCount();
    }

}
