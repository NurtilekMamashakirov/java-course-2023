package edu.hw4.Errors;

import edu.hw4.Animal;

public class AgeError extends Error {
    public AgeError(Animal animal) {
        Boolean legalAge = true;
        switch (animal.type()) {
            case DOG, CAT -> {
                if (!(animal.age() <= 40 && animal.age() >= 0)) {
                    legalAge = false;
                }
            }
            case FISH -> {
                if (!(animal.age() <= 500 && animal.age() >= 0)) {
                    legalAge = false;
                }
            }
            case BIRD -> {
                if (!(animal.age() <= 75 && animal.age() >= 0)) {
                    legalAge = false;
                }
            }
            case SPIDER -> {
                if (!(animal.age() <= 30 && animal.age() >= 0)) {
                    legalAge = false;
                }
            }
        }
        if (legalAge) {
            super.setMessage("No age error.");
        } else {
            super.setMessage("This type of animal can't live " + animal.age() + " years!");
        }
    }

}
