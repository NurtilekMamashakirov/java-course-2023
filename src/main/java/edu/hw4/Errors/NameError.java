package edu.hw4.Errors;

import edu.hw4.Animal;

public class NameError extends Error {
    public NameError(Animal animal) {
        Boolean checkForSymbols = true;
        for (char symbol : animal.name().toCharArray()) {
            if (!((symbol <= 122 && symbol >= 97) || (symbol >= 65 && symbol <= 90) || (symbol == 32))) {
                checkForSymbols = false;
            }
        }
        if (checkForSymbols) {
            super.setMessage("No name error.");
        } else {
            super.setMessage("Used illegal symbols!");
        }
    }

}
