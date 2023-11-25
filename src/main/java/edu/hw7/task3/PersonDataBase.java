package edu.hw7.task3;

import java.util.List;

public interface PersonDataBase {

    void add(Person person);

    void delete(int id);

    Person findByName(String name);

    Person findByAddress(String address);

    Person findByPhone(String phone);

}
