package edu.project4.single;

import edu.project4.Coefficient;
import edu.project4.Coefficients;
import edu.project4.Pixel;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PixelFireGenerator implements PixelsGenerator {

    private static final int NUM_OF_COEFFICIENTS = 30;
    private static final double X_MIN = -1.777;
    private static final double X_MAX = 1.777;
    private static final double Y_MIN = -1;
    private static final double Y_MAX = 1;
    private Pixel[][] pixels;
    private final int xRes;
    private final int yRes;

    public PixelFireGenerator(int xRes, int yRes) {
        this.xRes = xRes;
        this.yRes = yRes;
        pixels = new Pixel[xRes][yRes];
        for (int i = 0; i < xRes; i++) {
            for (int j = 0; j < yRes; j++) {
                pixels[i][j] = new Pixel();
            }
        }
    }

    @Override
    public Pixel[][] generate(int n, int it) {
        List<Coefficient> coefficients = new Coefficients().getCoefficients();
        for (int num = 0; num < n; num++) {
            double newX = ThreadLocalRandom.current().nextDouble(X_MIN, X_MAX);
            double newY = ThreadLocalRandom.current().nextDouble(Y_MIN, Y_MAX);
            for (int step = -20; step < it; step++) {
                Coefficient coefficient = coefficients.get(ThreadLocalRandom.current().nextInt(NUM_OF_COEFFICIENTS));
                double x = coefficient.a() * newX + coefficient.b() * newY + coefficient.c();
                double y = coefficient.d() * newX + coefficient.e() * newY + coefficient.f();
                if (ThreadLocalRandom.current().nextInt(0, 2) == 0) {
                    newX = nonLineForX(x, y);
                    newY = nonLineForY(x, y);
                } else {
                    newX = x;
                    newY = y;
                }

                if (step >= 0 && newX <= X_MAX && newX >= X_MIN && newY <= Y_MAX && newY >= Y_MIN) {
                    int x1 = xRes - (int) ((X_MAX - newX) / (X_MAX - X_MIN) * xRes);
                    int y1 = yRes - (int) ((Y_MAX - newY) / (Y_MAX - Y_MIN) * yRes);
                    if (x1 < xRes && y1 < yRes) {
                        if (pixels[x1][y1].getCounter() == 0) {
                            pixels[x1][y1].setRed(coefficient.red());
                            pixels[x1][y1].setGreen(coefficient.green());
                            pixels[x1][y1].setBlue(coefficient.blue());
                        } else {
                            pixels[x1][y1].setRed((pixels[x1][y1].getRed() + coefficient.red()) / 2);
                            pixels[x1][y1].setGreen((pixels[x1][y1].getGreen() + coefficient.green()) / 2);
                            pixels[x1][y1].setBlue((pixels[x1][y1].getBlue() + coefficient.blue()) / 2);
                        }
                        pixels[x1][y1].incrementCounter();
                    }
                }
            }
        }
        return pixels;
    }

    private double nonLineForX(double x, double y) {
        return (Math.atan(y / x) / Math.PI);
    }

    private double nonLineForY(double x, double y) {
        return y / (x * x + y * y);
    }

}
