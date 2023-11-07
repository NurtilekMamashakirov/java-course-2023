package edu.hw4.Errors;

import edu.hw4.Animal;

public class AgeError extends Error {
    public AgeError(Animal animal) {
        Boolean legalAge = true;

        final int DOG_AND_CAT_MAX_AGE = 40;
        final int FISH_MAX_AGE = 500;
        final int BIRD_MAX_AGE = 75;
        final int SPIDER_MAX_AGE = 30;
        final int ANIMAL_MIN_AGE = 0;

        switch (animal.type()) {
            case DOG, CAT -> {
                if (!(animal.age() <= DOG_AND_CAT_MAX_AGE && animal.age() >= ANIMAL_MIN_AGE)) {
                    legalAge = false;
                }
            }
            case FISH -> {
                if (!(animal.age() <= FISH_MAX_AGE && animal.age() >= ANIMAL_MIN_AGE)) {
                    legalAge = false;
                }
            }
            case BIRD -> {
                if (!(animal.age() <= BIRD_MAX_AGE && animal.age() >= ANIMAL_MIN_AGE)) {
                    legalAge = false;
                }
            }
            case SPIDER -> {
                if (!(animal.age() <= SPIDER_MAX_AGE && animal.age() >= ANIMAL_MIN_AGE)) {
                    legalAge = false;
                }
            }
            default -> {

            }
        }
        if (legalAge) {
            super.setMessage("No age error.");
        } else {
            super.setMessage("This type of animal can't live " + animal.age() + " years!");
        }
    }

}
