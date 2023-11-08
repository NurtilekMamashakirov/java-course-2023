package edu.hw3.Task7;

import java.util.Objects;

public class Comparator implements java.util.Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (Objects.equals(o1, o2))
            return 0;
        if (o1 == null)
            return -1;
        if (o2 == null)
            return 1;
        return o1.compareTo(o2);
    }

}
