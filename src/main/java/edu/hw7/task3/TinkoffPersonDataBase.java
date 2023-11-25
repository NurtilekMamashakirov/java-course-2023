package edu.hw7.task3;

import java.util.HashMap;
import java.util.Map;

public class TinkoffPersonDataBase implements PersonDataBase {

    private final Map<Integer, Person> dataBaseById;
    private final Map<String, Person> dataBaseByName;
    private final Map<String, Person> dataBaseByAddress;
    private final Map<String, Person> dataBaseByPhone;

    public TinkoffPersonDataBase() {
        dataBaseById = new HashMap<>();
        dataBaseByName = new HashMap<>();
        dataBaseByAddress = new HashMap<>();
        dataBaseByPhone = new HashMap<>();
    }

    @Override
    public synchronized void add(Person person) {
        dataBaseById.put(person.id(), person);
        dataBaseByName.put(person.name(), person);
        dataBaseByAddress.put(person.address(), person);
        dataBaseByPhone.put(person.phoneNumber(), person);
    }

    @Override
    public synchronized void delete(int id) {
        Person person = dataBaseById.remove(id);

        if (person != null) {
            dataBaseByName.remove(person.name());
            dataBaseByAddress.remove(person.address());
            dataBaseByPhone.remove(person.phoneNumber());
        }
    }

    @Override
    public synchronized Person findByName(String name) {
        return dataBaseByName.get(name);

    }

    @Override
    public synchronized Person findByAddress(String address) {
        return dataBaseByAddress.get(address);
    }

    @Override
    public synchronized Person findByPhone(String phone) {
        return dataBaseByPhone.get(phone);
    }

}
