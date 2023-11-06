package edu.hw4.Errors;

import edu.hw4.Animal;

public class WeightError extends Error {
    public WeightError(Animal animal) {
        Boolean legalWeight = true;
        switch (animal.type()) {
            case DOG, BIRD -> {
                if (!(animal.weight() <= 200 && animal.weight() > 0)) {
                    legalWeight = false;
                }
            }
            case CAT -> {
                if (!(animal.weight() <= 50 && animal.weight() > 0)) {
                    legalWeight = false;
                }
            }
            case FISH -> {
                if (!(animal.weight() <= 30000 && animal.weight() > 0)) {
                    legalWeight = false;
                }
            }
            case SPIDER -> {
                if (!(animal.weight() <= 2 && animal.weight() >= 0)) {
                    legalWeight = false;
                }
            }
            default -> {
            }
        }
        if (legalWeight) {
            super.setMessage("No weight error.");
        } else {
            super.setMessage("This type of animal can't have weight " + animal.weight() + "!");
        }
    }
}

