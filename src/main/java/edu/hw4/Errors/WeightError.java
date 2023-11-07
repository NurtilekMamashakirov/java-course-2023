package edu.hw4.Errors;

import edu.hw4.Animal;

public class WeightError extends Error {
    public WeightError(Animal animal) {

        final int DOG_AND_BIRD_MAX_WEIGHT = 200;
        final int DOG_AND_BIRD_MIN_WEIGHT = 0;
        final int CAT_MAX_WEIGHT = 50;
        final int CAT_MIN_WEIGHT = 0;
        final int FISH_MAX_WEIGHT = 30000;
        final int FISH_MIN_WEIGHT = 0;
        final int SPIDER_MAX_WEIGHT = 2;
        final int SPIDER_MIN_WEIGHT = 0;

        Boolean legalWeight = true;
        switch (animal.type()) {
            case DOG, BIRD -> {
                if (!(animal.weight() <= DOG_AND_BIRD_MAX_WEIGHT && animal.weight() > DOG_AND_BIRD_MIN_WEIGHT)) {
                    legalWeight = false;
                }
            }
            case CAT -> {
                if (!(animal.weight() <= CAT_MAX_WEIGHT && animal.weight() > CAT_MIN_WEIGHT)) {
                    legalWeight = false;
                }
            }
            case FISH -> {
                if (!(animal.weight() <= FISH_MAX_WEIGHT && animal.weight() > FISH_MIN_WEIGHT)) {
                    legalWeight = false;
                }
            }
            case SPIDER -> {
                if (!(animal.weight() <= SPIDER_MAX_WEIGHT && animal.weight() >= SPIDER_MIN_WEIGHT)) {
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

