package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

public class TasksTest {
    Tasks tasks = new Tasks();
    List<Animal> animals = createAnimals();

    List<Animal> createAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Vasyaa", Animal.Type.DOG, Animal.Sex.M, 10, 32, 364, true));
        animals.add(new Animal("Petya", Animal.Type.FISH, Animal.Sex.F, 32, 53, 243, false));
        animals.add(new Animal("Jora", Animal.Type.BIRD, Animal.Sex.M, 53, 352, 53, false));
        animals.add(new Animal("Liza", Animal.Type.CAT, Animal.Sex.F, 30, 90, 432, true));
        return animals;
    }

    //task1
    @Test
    void sortedByHeightTest() {

        List<Animal> sortedAnimals = new ArrayList<>();

        sortedAnimals.add(new Animal("Vasyaa", Animal.Type.DOG, Animal.Sex.M, 10, 32, 364, true));
        sortedAnimals.add(new Animal("Petya", Animal.Type.FISH, Animal.Sex.F, 32, 53, 243, false));
        sortedAnimals.add(new Animal("Liza", Animal.Type.CAT, Animal.Sex.F, 30, 90, 432, true));
        sortedAnimals.add(new Animal("Jora", Animal.Type.BIRD, Animal.Sex.M, 53, 352, 53, false));

        assertThat(tasks.sortByHeight(animals)).isEqualTo(sortedAnimals);
    }

    //task2
    @Test
    void reverseSortByWeightAndChooseKTest() {
        List<Animal> expectedList = new ArrayList<>();
        expectedList.add(new Animal("Liza", Animal.Type.CAT, Animal.Sex.F, 30, 90, 432, true));
        expectedList.add(new Animal("Vasyaa", Animal.Type.DOG, Animal.Sex.M, 10, 32, 364, true));

        assertThat(tasks.reverseSortByWeightAndChooseK(animals, 2)).isEqualTo(expectedList);
    }

    //task3
    @Test
    void typesCountTest() {
        Map<Animal.Type, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Animal.Type.DOG, 1);
        expectedMap.put(Animal.Type.CAT, 1);
        expectedMap.put(Animal.Type.BIRD, 1);
        expectedMap.put(Animal.Type.FISH, 1);
        assertThat(tasks.countTypes(animals)).isEqualTo(expectedMap);
    }

    //task4
    @Test
    void longestNameTest() {
        Animal expected = new Animal("Vasyaa", Animal.Type.DOG, Animal.Sex.M, 10, 32, 364, true);
        assertThat(tasks.longestName(animals)).isEqualTo(expected);
    }

    //task5
    @Test
    void maleOrFemaleTest() {
        animals.add(new Animal("wef", Animal.Type.DOG, Animal.Sex.M, 10, 20, 30, true));
        assertThat(tasks.maleOrFemale(animals)).isEqualTo(Animal.Sex.M);
    }

    //task6
    @Test
    void heaviestAnimalOfTypes() {
        animals.add(new Animal("wef", Animal.Type.DOG, Animal.Sex.M, 10, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 10, 20, 1000, true));
        Map<Animal.Type, Animal> expectedMap = new HashMap<>();
        expectedMap.put(Animal.Type.DOG, new Animal("wef", Animal.Type.DOG, Animal.Sex.M, 10, 20, 1000, true));
        expectedMap.put(Animal.Type.BIRD, new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 10, 20, 1000, true));
        expectedMap.put(Animal.Type.FISH, new Animal("Petya", Animal.Type.FISH, Animal.Sex.F, 32, 53, 243, false));
        expectedMap.put(Animal.Type.CAT, new Animal("Liza", Animal.Type.CAT, Animal.Sex.F, 30, 90, 432, true));
        assertThat(tasks.heaviestAnimalOfTypes(animals)).isEqualTo(expectedMap);
    }

    //task7
    @Test
    void oldestKTest() {
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 100, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 324, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 543, 20, 1000, true));
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 23, 20, 1000, true));
        assertThat(tasks.oldestK(animals, 3)).isEqualTo(new Animal(
            "wef",
            Animal.Type.BIRD,
            Animal.Sex.M,
            100,
            20,
            1000,
            true
        ));
    }

    //task8
    @Test
    void heaviestAndBelowKTest() {
        assertThat(tasks.heaviestAndBelowK(animals, 100)).isEqualTo(Optional.of(new Animal(
            "Liza",
            Animal.Type.CAT,
            Animal.Sex.F,
            30,
            90,
            432,
            true
        )));
    }

    //task9
    @Test
    void countPawsTest() {
        assertThat(tasks.countPaws(animals)).isEqualTo(10);
    }

    //task10
    @Test
    void animalsWithAgeNotEqualsPawsTest() {
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 1000, true));

        List<Animal> expectedAnimals = createAnimals();
        assertThat(tasks.animalsWithAgeNotEqualsPaws(animals)).isEqualTo(expectedAnimals);
    }

    //task11
    @Test
    void canBiteAndHigher100() {
        animals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 2, 200, 1000, true));
        animals.add(new Animal("wesfdf", Animal.Type.BIRD, Animal.Sex.M, 2, 300, 1000, true));
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal("wef", Animal.Type.BIRD, Animal.Sex.M, 2, 200, 1000, true));
        expectedAnimals.add(new Animal("wesfdf", Animal.Type.BIRD, Animal.Sex.M, 2, 300, 1000, true));
        assertThat(tasks.canBiteAndHigher100(animals)).isEqualTo(expectedAnimals);
    }

    //task12
    @Test
    void weightMoreThanHeightTest() {
        assertThat(tasks.weightMoreThanHeight(animals)).isEqualTo(3);
    }

    //task13
    @Test
    void nameWithMoreTwoWordsTest() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.BIRD, Animal.Sex.M, 2, 200, 1000, true));
        animals.add(new Animal("wesfdf dsf sdf", Animal.Type.BIRD, Animal.Sex.M, 2, 300, 1000, true));
        List<Animal> expectedAnimals = new ArrayList<>();
        expectedAnimals.add(new Animal("wef fdw dsf", Animal.Type.BIRD, Animal.Sex.M, 2, 200, 1000, true));
        expectedAnimals.add(new Animal("wesfdf dsf sdf", Animal.Type.BIRD, Animal.Sex.M, 2, 300, 1000, true));
        assertThat(tasks.nameWithMoreTwoWords(animals)).isEqualTo(expectedAnimals);
    }

    //task14
    @Test
    void dogHigherThanK() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.DOG, Animal.Sex.M, 2, 200, 1000, true));
        assertThat(tasks.dogHigherThanK(animals, 100)).isTrue();
        assertThat(tasks.dogHigherThanK(animals, 500)).isFalse();
    }

    //task15
    @Test
    void summarizeWeightWithConditionTest() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.CAT, Animal.Sex.M, 26, 200, 1000, true));
        Map<Animal.Type, Integer> expectedMap = new HashMap<>();
        expectedMap.put(Animal.Type.FISH, 243);
        expectedMap.put(Animal.Type.CAT, 1432);
        assertThat(tasks.summarizeWeightWithCondition(animals, 25, 40)).isEqualTo(expectedMap);
    }

    //task16
    @Test
    void sortTypeSexName() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.CAT, Animal.Sex.M, 26, 200, 1000, true));
        System.out.println(tasks.sortTypeSexName(animals));
        System.out.println();
    }

    //task17
    @Test
    void spiderBitesMoreThanDogTest() {
        animals.add(new Animal("wef fdw dsf", Animal.Type.SPIDER, Animal.Sex.M, 26, 200, 1000, true));
        animals.add(new Animal("wef fdw dsf", Animal.Type.DOG, Animal.Sex.M, 26, 200, 1000, false));
        assertThat(tasks.spiderBitesMoreThanDog(animals)).isTrue();
    }

    //task18
    @Test
    void findHeaviestFish() {
        List<Animal> animals2 = new ArrayList<>();
        animals.add(new Animal("Vasygaa", Animal.Type.DOG, Animal.Sex.M, 10, 32, 364, true));
        animals.add(new Animal("Petfweya", Animal.Type.FISH, Animal.Sex.F, 32, 53, 264, false));
        animals.add(new Animal("JorFWa", Animal.Type.BIRD, Animal.Sex.M, 53, 352, 53, false));
        animals.add(new Animal("FW", Animal.Type.FISH, Animal.Sex.F, 30, 90, 432, true));
        assertThat(tasks.findHeaviestFish(animals, animals2)).isEqualTo(new Animal(
            "FW",
            Animal.Type.FISH,
            Animal.Sex.F,
            30,
            90,
            432,
            true
        ));


    }

    //task19
    @Test
    void findErrorsTest() {
        animals.add(new Animal("3429fu f3f4", Animal.Type.FISH, Animal.Sex.F, 30, 90, 432, true));
        Map<String, ValidationError> errors = tasks.findErrors(animals);
        assertThat(errors.get("Vasyaa").getWeightError().getMessage()).isEqualTo("This type of animal can't have weight 364!");
        assertThat(errors.get("3429fu f3f4").getNameError().getMessage()).isEqualTo("Used illegal symbols!");
    }

    //task20
    @Test
    void findErrorsWithMessageTest() {
        Map<String, String> errors = tasks.findErrorsWithMessage(animals);
        System.out.println(errors);
        assertThat(errors.get("Liza")).isEqualTo("No name error. No age error. This type of animal can't have height 90! This type of animal can't have weight 432!");
        assertThat(errors.get("Vasyaa")).isEqualTo("No name error. No age error. No height error. This type of animal can't have weight 364!");
    }

}
