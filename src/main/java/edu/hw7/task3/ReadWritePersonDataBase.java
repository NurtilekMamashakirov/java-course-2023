package edu.hw7.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWritePersonDataBase implements PersonDataBase {

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Map<Integer, Person> dataBaseById = new HashMap<>();
    private final Map<String, Person> dataBaseByName = new HashMap<>();
    private final Map<String, Person> dataBaseByAddress = new HashMap<>();
    private final Map<String, Person> dataBaseByPhone = new HashMap<>();

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            dataBaseById.put(person.id(), person);
            dataBaseByName.put(person.name(), person);
            dataBaseByAddress.put(person.address(), person);
            dataBaseByPhone.put(person.phoneNumber(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            Person person = dataBaseById.remove(id);

            if (person != null) {
                dataBaseByName.remove(person.name());
                dataBaseByAddress.remove(person.address());
                dataBaseByPhone.remove(person.phoneNumber());
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Person findByName(String name) {
        lock.readLock().lock();
        try {
            return dataBaseByName.get(name);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByAddress(String address) {
        lock.readLock().lock();
        try {
            return dataBaseByAddress.get(address);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Person findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return dataBaseByPhone.get(phone);
        } finally {
            lock.readLock().unlock();
        }
    }

}
