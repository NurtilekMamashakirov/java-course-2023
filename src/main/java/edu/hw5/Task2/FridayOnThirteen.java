package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayOnThirteen {

    private FridayOnThirteen() {}

    private final static int THIRTEENTH = 13;
    private final static int FIRST_MONTH = 1;
    private final static int LAST_MONTH = 12;

    public static List<LocalDate> findFridayThe13ths(int year) {
        List<LocalDate> fridayThe13ths = new ArrayList<>();
        LocalDate date = LocalDate.of(year, FIRST_MONTH, THIRTEENTH);
        for (int month = FIRST_MONTH; month <= LAST_MONTH; month++) {
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
        while (nextFridayThe13th.getDayOfMonth() != THIRTEENTH) {
            nextFridayThe13th = nextFridayThe13th.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return nextFridayThe13th;
    }

}
