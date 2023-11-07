package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    Boolean bites
) {

    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }

    public int paws() {
        final int CATS_AND_DOGS_PAWS = 4;
        final int BIRD_PAWS = 2;
        final int FISH_PAWS = 0;
        final int SPIDER_PAWS = 8;

        return switch (type) {
            case CAT, DOG -> CATS_AND_DOGS_PAWS;
            case BIRD -> BIRD_PAWS;
            case FISH -> FISH_PAWS;
            case SPIDER -> SPIDER_PAWS;
        };
    }
}
