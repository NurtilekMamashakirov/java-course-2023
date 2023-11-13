package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayOnThirteen {

    public static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 13);
        for (int month = 1; month <= 12; month++) {
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                fridayThe13ths.add(date);
            }
            date = date.plusMonths(1);
        }
        return fridayThe13ths;
    }

    public static LocalDate findNextFridayThe13th() {
        LocalDate date = LocalDate.now();
        LocalDate nextFridayThe13th = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (nextFridayThe13th.getDayOfMonth() != 13) {
            nextFridayThe13th = nextFridayThe13th.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return nextFridayThe13th;
    }

}
