package edu.hw4.Errors;

import edu.hw4.Animal;

public class HeightError extends Error {
    public HeightError(Animal animal) {
        Boolean legalHeight = true;
        switch (animal.type()) {
            case DOG -> {
                if (!(animal.height() <= 120 && animal.height() >= 10)) {
                    legalHeight = false;
                }
            }
            case CAT -> {
                if (!(animal.height() <= 50 && animal.height() >= 5)) {
                    legalHeight = false;
                }
            }
            case FISH -> {
                if (!(animal.height() <= 4000 && animal.height() > 0)) {
                    legalHeight = false;
                }
            }
            case BIRD -> {
                if (!(animal.height() <= 400 && animal.height() > 0)) {
                    legalHeight = false;
                }
            }
            case SPIDER -> {
                if (!(animal.height() <= 30 && animal.height() >= 0)) {
                    legalHeight = false;
                }
            }
            default -> {
            }
        }
        if (legalHeight) {
            super.setMessage("No height error.");
        } else {
            super.setMessage("This type of animal can't have height " + animal.height() + "!");
        }
    }
}
