package edu.hw4.Errors;

import edu.hw4.Animal;

public class HeightError extends Error {

    public HeightError(Animal animal) {

        final int DOG_MAX_HEIGHT = 120;
        final int DOG_MIN_HEIGHT = 10;
        final int CAT_MAX_HEIGHT = 50;
        final int CAT_MIN_HEIGHT = 5;
        final int FISH_MAX_HEIGHT = 4000;
        final int FISH_MIN_HEIGHT = 0;
        final int BIRD_MAX_HEIGHT = 400;
        final int BIRD_MIN_HEIGHT = 0;
        final int SPIDER_MAX_HEIGHT = 30;
        final int SPIDER_MIN_HEIGHT = 0;



        Boolean legalHeight = true;
        switch (animal.type()) {
            case DOG -> {
                if (!(animal.height() <= DOG_MAX_HEIGHT && animal.height() >= DOG_MIN_HEIGHT)) {
                    legalHeight = false;
                }
            }
            case CAT -> {
                if (!(animal.height() <= CAT_MAX_HEIGHT && animal.height() >= CAT_MIN_HEIGHT)) {
                    legalHeight = false;
                }
            }
            case FISH -> {
                if (!(animal.height() <= FISH_MAX_HEIGHT && animal.height() >= FISH_MIN_HEIGHT)) {
                    legalHeight = false;
                }
            }
            case BIRD -> {
                if (!(animal.height() <= BIRD_MAX_HEIGHT && animal.height() >= BIRD_MIN_HEIGHT)) {
                    legalHeight = false;
                }
            }
            case SPIDER -> {
                if (!(animal.height() <= SPIDER_MAX_HEIGHT && animal.height() >= SPIDER_MIN_HEIGHT)) {
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
