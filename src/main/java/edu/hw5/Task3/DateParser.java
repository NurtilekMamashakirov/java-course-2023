package edu.hw5.Task3;

import edu.hw5.Task3.DateParseChain.DateWithDashParseProcessor;
import edu.hw5.Task3.DateParseChain.DateWithSlashParseProcessor;
import edu.hw5.Task3.DateParseChain.DayDateParseProcessor;
import edu.hw5.Task3.DateParseChain.DaysAgoDateParseProcessor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    private DateParser() {
    }

    @SuppressWarnings("checkstyle:ReturnCount")
    public static Optional<LocalDate> parseDate(String stringDate) {
        DaysAgoDateParseProcessor daysAgoDateParseProcessor =
            new DaysAgoDateParseProcessor(null);
        DayDateParseProcessor dayDateParseProcessor =
            new DayDateParseProcessor(daysAgoDateParseProcessor);
        DateWithSlashParseProcessor dateWithSlashParseProcessor =
            new DateWithSlashParseProcessor(dayDateParseProcessor);
        DateWithDashParseProcessor dateWithDashParseProcessor =
            new DateWithDashParseProcessor(dateWithSlashParseProcessor);
        return dateWithDashParseProcessor.isParsed(stringDate);
    }

}
