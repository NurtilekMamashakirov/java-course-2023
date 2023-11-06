package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Tasks {

    //task1
    public List<Animal> sortByHeight(List<Animal> animalList) {
        animalList = animalList.stream().sorted(Comparator.comparing(Animal::height)).toList();
        return animalList;
    }

    //task2
    public List<Animal> reverseSortByWeightAndChooseK(List<Animal> animalList, Integer k) {
        animalList = animalList.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).toList();
        return animalList;
    }

    //task3
    public Map<Animal.Type, Integer> countTypes(List<Animal> animalList) {
        Map<Animal.Type, Integer> types = new HashMap<>();
        animalList.stream().forEach(animal -> {
            if (types.containsKey(animal.type())) {
                types.put(animal.type(), types.get(animal.type()) + 1);
            } else {
                types.put(animal.type(), 1);
            }
        });
        return types;
    }

    //task4
    public Animal longestName(List<Animal> animalList) {
        animalList =
            animalList.stream().sorted((Animal o1, Animal o2) -> Integer.compare(o2.name().length(), o1.name().length()))
                .limit(1)
                .toList();
        return animalList.get(0);
    }

    //task5
    public Animal.Sex maleOrFemale(List<Animal> animalList) {
        Map<Animal.Sex, Integer> sexesCount = new HashMap<>();
        sexesCount.put(Animal.Sex.M, 0);
        sexesCount.put(Animal.Sex.F, 0);
        animalList.stream().forEach(animal ->
            sexesCount.put(animal.sex(), sexesCount.get(animal.sex()) + 1)
        );
        return sexesCount.get(Animal.Sex.M) >= sexesCount.get(Animal.Sex.F) ? Animal.Sex.M : Animal.Sex.F;
    }

    //task6
    public Map<Animal.Type, Animal> heaviestAnimalOfTypes(List<Animal> animalList) {
        Map<Animal.Type, Animal> heaviestAnimals = new HashMap<>();
        animalList.stream().forEach(animal -> {
            if (heaviestAnimals.containsKey(animal.type())) {
                if (heaviestAnimals.get(animal.type()).weight() < animal.weight()) {
                    heaviestAnimals.put(animal.type(), animal);
                }
            } else {
                heaviestAnimals.put(animal.type(), animal);
            }
        });
        return heaviestAnimals;
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
        AtomicReference<Integer> countPaws = new AtomicReference<>(0);
        animalList.stream().forEach(animal -> {
            if (animal.type().equals(Animal.Type.DOG) || animal.type().equals(Animal.Type.CAT)) {
                countPaws.getAndSet(countPaws.get() + 4);
            } else if (animal.type().equals(Animal.Type.BIRD)) {
                countPaws.getAndSet(countPaws.get() + 2);
            } else if (animal.type().equals(Animal.Type.SPIDER)) {
                countPaws.getAndSet(countPaws.get() + 8);
            }
        });
        return countPaws.get();
    }

    //task10
    public List<Animal> animalsWithAgeNotEqualsPaws(List<Animal> animalList) {
        animalList = animalList.stream().filter(animal -> {
            if (animal.type().equals(Animal.Type.DOG) || animal.type().equals(Animal.Type.CAT)) {
                return animal.age() != 4;
            } else if (animal.type().equals(Animal.Type.BIRD)) {
                return animal.age() != 2;
            } else if (animal.type().equals(Animal.Type.SPIDER)) {
                return animal.age() != 8;
            } else {
                return animal.age() != 0;
            }
        }).toList();
        return animalList;
    }

    //task11
    public List<Animal> canBiteAndHigher100(List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.bites() && animal.height() > 100).toList();
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
        Map<Animal.Type, Integer> sumWeight = new HashMap<>();
        animalList.stream().filter(animal -> animal.age() >= k && animal.age() <= i).toList()
            .forEach(animal -> {
                if (sumWeight.containsKey(animal.type())) {
                    sumWeight.put(animal.type(), sumWeight.get(animal.type()) + animal.weight());
                } else {
                    sumWeight.put(animal.type(), animal.weight());
                }
            });
        return sumWeight;
    }

    //task16
    public List<Animal> sortTypeSexName(List<Animal> animalList) {
        return animalList.stream().sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex)
            .thenComparing(Animal::name)).toList();
    }

    //task17
    public Boolean spiderBitesMoreThanDog(List<Animal> animalList) {
        Map<Animal.Type, Integer[]> countBite = new HashMap<>();
        countBite.put(Animal.Type.DOG, new Integer[] {0, 0});
        countBite.put(Animal.Type.SPIDER, new Integer[] {0, 0});
        animalList.stream().forEach(a -> {
            if (a.type().equals(Animal.Type.DOG) || a.type().equals(Animal.Type.SPIDER)) {
                Integer[] count = countBite.get(a.type());
                count[0]++;
                if (a.bites()) {
                    count[1]++;
                }
                countBite.put(a.type(), count);
            }
        });
        if (countBite.get(Animal.Type.SPIDER)[0] != 0 && countBite.get(Animal.Type.DOG)[0] != 0) {
            Double spiderStat = Double.valueOf(countBite.get(Animal.Type.SPIDER)[1])
                / Double.valueOf(countBite.get(Animal.Type.SPIDER)[0]);
            Double dogStat = Double.valueOf(countBite.get(Animal.Type.DOG)[1])
                / Double.valueOf(countBite.get(Animal.Type.DOG)[0]);
            return spiderStat > dogStat;
        } else {
            return false;
        }
    }

    //task18
    Animal findHeaviestFish(List<Animal>... more) {
        return more[0].stream().filter(a -> a.type().equals(Animal.Type.FISH))
            .max(Comparator.comparing(Animal::weight)).get();
    }

    //task19
    Map<String, ValidationError> findErrors(List<Animal> animalList) {
        Map<String, ValidationError> errorsOfAnimals = new HashMap<>();
        animalList.stream().forEach(a -> {
            ValidationError validationError = new ValidationError();
            validationError.checkAllErrors(a);
            errorsOfAnimals.put(a.name(), validationError);
        });
        return errorsOfAnimals;
    }

    //task20
    Map<String, String> findErrorsWithMessage(List<Animal> animalList) {
        Map<String, String> errorsOfAnimals = new HashMap<>();
        animalList.stream().forEach(a -> {
            ValidationError validationError = new ValidationError();
            validationError.checkAllErrors(a);
            String message = validationError.getNameError().getMessage() + " "
                + validationError.getAgeError().getMessage() + " "
                + validationError.getHeightError().getMessage() + " "
                + validationError.getWeightError().getMessage();
            errorsOfAnimals.put(a.name(), message);
        });
        return errorsOfAnimals;
    }
}
