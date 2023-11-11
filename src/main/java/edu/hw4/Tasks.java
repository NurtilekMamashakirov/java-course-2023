package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks {

    //task1
    public List<Animal> sortByHeight(List<Animal> animalList) {
        List<Animal> animals = animalList.stream().sorted(Comparator.comparing(Animal::height)).toList();
        return animals;
    }

    //task2
    public List<Animal> reverseSortByWeightAndChooseK(List<Animal> animalList, Integer k) {
        List<Animal> animals =
            animalList.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
        return animals;
    }

    //task3
    public Map<Animal.Type, Long> countTypes(List<Animal> animalList) {
        Map<Animal.Type, Long> types =
            animalList
                .stream()
                .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
        return types;
    }

    //task4
    public Animal longestName(List<Animal> animalList) {
        List<Animal> animals =
            animalList.stream().sorted((Animal o1, Animal o2) ->
                    Integer.compare(o2.name().length(), o1.name().length()))
                .limit(1)
                .toList();
        return animals.get(0);
    }

    //task5
    public Animal.Sex maleOrFemale(List<Animal> animalList) {
        Map<Animal.Sex, Long> sexesCount =
            animalList.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));
        return sexesCount.get(Animal.Sex.M) >= sexesCount.get(Animal.Sex.F) ? Animal.Sex.M : Animal.Sex.F;
    }

    //task6
    public Map<Animal.Type, Animal> heaviestAnimalOfTypes(List<Animal> animalList) {
        return animalList.stream()
            .collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparing(Animal::weight))
            ));
    }

    //task7
    public Animal oldestK(List<Animal> animalList, Integer k) {
        return animalList.stream().sorted(Comparator.comparing(Animal::age).reversed()).toList().get(k - 1);
    }

    //taks8
    public Optional<Animal> heaviestAndBelowK(List<Animal> animalList, Integer k) {
        return animalList.stream().filter(animal -> animal.height() < k)
            .max(Comparator.comparing(Animal::weight));
    }

    //task9
    public Integer countPaws(List<Animal> animalList) {
        return animalList.stream().mapToInt(Animal::paws).sum();
    }

    //task10
    public List<Animal> animalsWithAgeNotEqualsPaws(List<Animal> animalList) {
        List<Animal> animals = animalList.stream().filter(animal -> animal.age() != animal.paws()).toList();
        return animals;
    }

    //task11
    public List<Animal> canBiteAndHigher100(List<Animal> animalList) {
        final int HEIGHT_100 = 100;
        return animalList.stream().filter(animal -> animal.bites() && animal.height() > HEIGHT_100).toList();
    }

    //taks12
    public Integer weightMoreThanHeight(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.weight() > animal.height()).toList().size();
    }

    //task13
    public List<Animal> nameWithMoreTwoWords(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.name().split(" ").length > 2).toList();
    }

    //task14
    public Boolean dogHigherThanK(List<Animal> animalList, Integer k) {
        return !(animalList.stream().filter(animal -> animal.type().equals(Animal.Type.DOG) && animal.height() > k)
            .toList().isEmpty());
    }

    //taks15
    public Map<Animal.Type, Integer> summarizeWeightWithCondition(List<Animal> animalList, Integer k, Integer i) {
        return animalList.stream().filter(animal -> animal.age() >= k && animal.age() <= i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    //task16
    public List<Animal> sortTypeSexName(List<Animal> animalList) {
        return animalList.stream().sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex)
            .thenComparing(Animal::name)).toList();
    }

    //task17
    public Boolean spiderBitesMoreThanDog(List<Animal> animalList) {
        long spiderQuantity = animalList.stream()
            .filter(a -> a.type().equals(Animal.Type.SPIDER))
            .count();
        long spiderBiteQuantity = animalList.stream()
            .filter(a -> a.type().equals(Animal.Type.SPIDER) && a.bites())
            .count();
        long dogQuantity = animalList.stream()
            .filter(a -> a.type().equals(Animal.Type.DOG))
            .count();
        long dogBiteQuantity = animalList.stream()
            .filter(a -> a.type().equals(Animal.Type.DOG) && a.bites())
            .count();
        if (spiderQuantity == 0 || dogQuantity == 0) {
            return false;
        }
        return spiderBiteQuantity / spiderQuantity > dogBiteQuantity / dogQuantity;
    }

    //task18
    Animal findHeaviestFish(List<Animal>... more) {
        return more[0].stream().filter(a -> a.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight)).get();
    }

    //task19
    Map<String, ValidationError> findErrors(List<Animal> animalList) {
        Map<String, ValidationError> errorsOfAnimals =
            animalList.stream()
                .collect(Collectors.toMap(Animal::name, a -> {
                    ValidationError validationError = new ValidationError();
                    validationError.checkAllErrors(a);
                    return validationError;
                }));
        return errorsOfAnimals;
    }

    //task20
    Map<String, String> findErrorsWithMessage(List<Animal> animalList) {
        Map<String, String> errorsOfAnimals =
            animalList.stream()
                .collect(Collectors.toMap(Animal::name, a -> {
                    ValidationError validationError = new ValidationError();
                    validationError.checkAllErrors(a);
                    String message = validationError.getNameError().getMessage() + " "
                        + validationError.getAgeError().getMessage() + " "
                        + validationError.getHeightError().getMessage() + " "
                        + validationError.getWeightError().getMessage();
                    return message;
                }));
        return errorsOfAnimals;
    }
}
