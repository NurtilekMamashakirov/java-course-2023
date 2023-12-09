package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {

    public List<Contact> parseContact(List<String> names, String progressOrRegress) {
        if (names == null) {
            return new ArrayList<Contact>();
        }
        List<Contact> contacts = new ArrayList<>();
        for (String name : names) {
            String[] arrayOfNameAndSurname = name.split(" ");
            if (arrayOfNameAndSurname.length == 2) {
                contacts.add(new Contact(arrayOfNameAndSurname[1], arrayOfNameAndSurname[0]));
            } else if (arrayOfNameAndSurname.length == 1) {
                contacts.add(new Contact(arrayOfNameAndSurname[0]));
            }
        }

        if (progressOrRegress.equals("ASC")) {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = i + 1; j < contacts.size(); j++) {
                    String name1 = (contacts.get(i)).getSurname() != null ? contacts.get(i).getSurname() : contacts
                        .get(i).getName();
                    String name2 = (contacts.get(j)).getSurname() != null ? contacts.get(j).getSurname() : contacts
                        .get(j).getName();
                    if (compare(name1, name2)) {
                        continue;
                    } else {
                        Contact temp = contacts.get(i);
                        contacts.set(i, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                for (int j = i + 1; j < contacts.size(); j++) {
                    String name1 = (contacts.get(i)).getSurname() != null ? contacts.get(i).getSurname() : contacts
                        .get(i).getName();
                    String name2 = (contacts.get(j)).getSurname() != null ? contacts.get(j).getSurname() : contacts
                        .get(j).getName();
                    if (!compare(name1, name2)) {
                        continue;
                    } else {
                        Contact temp = contacts.get(i);
                        contacts.set(i, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }
        return contacts;
    }

    private boolean compare(String surname1, String surname2) {
        for (int i = 0; i < Math.min(surname1.length(), surname2.length()); i++) {
            if (surname1.charAt(i) < surname2.charAt(i)) {
                return true;
            } else if (surname1.charAt(i) == surname2.charAt(i)) {
                continue;
            } else {
                return false;
            }
        }
        return surname1.length() < surname2.length();
    }

}
