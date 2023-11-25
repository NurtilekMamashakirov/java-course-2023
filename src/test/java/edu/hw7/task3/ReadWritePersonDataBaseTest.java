package edu.hw7.task3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadWritePersonDataBaseTest {

    TinkoffPersonDataBase dataBase = new TinkoffPersonDataBase();

    Thread addThread1 = new Thread(() -> {
        Person person1 = new Person(1, "Valera", "Moscow", "88005553535");
        dataBase.add(person1);
    });
    Thread addThread2 = new Thread(() -> {
        Person person2 = new Person(2, "Ivan", "Tula", "84564565656");
        dataBase.add(person2);
    });
    Thread addThread3 = new Thread(() -> {
        Person person3 = new Person(3, "Maxim", "SPB", "+78005553535");
        dataBase.add(person3);
    });
    Thread deleteThread = new Thread(() -> {
        dataBase.delete(1);
    });

    @Test
    void addTest() throws InterruptedException {

        addThread1.start();
        addThread2.start();
        addThread3.start();

        addThread1.join();
        addThread2.join();
        addThread3.join();

        assertThat(dataBase.findByName("Valera")).isNotNull();
        assertThat(dataBase.findByName("Ivan")).isNotNull();
        assertThat(dataBase.findByName("Maxim")).isNotNull();

    }

    @Test
    void deleteTest() throws InterruptedException {
        addThread1.start();
        addThread1.join();
        deleteThread.start();
        deleteThread.join();

        assertThat(dataBase.findByName("Valera")).isNull();
    }

    @Test
    void findByNameTest() throws InterruptedException {
        addThread1.start();
        addThread1.join();

        assertThat(dataBase.findByName("Valera")).isNotNull()
            .isEqualTo(new Person(1, "Valera", "Moscow", "88005553535"));
    }

    @Test
    void findByAddressTest() throws InterruptedException {
        addThread1.start();
        addThread1.join();

        assertThat(dataBase.findByAddress("Moscow"))
            .isEqualTo(new Person(1, "Valera", "Moscow", "88005553535"));
    }

    @Test
    void findByPhoneTest() throws InterruptedException {
        addThread1.start();
        addThread1.join();

        assertThat(dataBase.findByPhone("88005553535"))
            .isEqualTo(new Person(1, "Valera", "Moscow", "88005553535"));
    }

}
