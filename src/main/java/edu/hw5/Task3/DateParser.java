package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    private final static Pattern PATTERN = Pattern.compile("^(\\d+) days? ago$");

    public static Optional<LocalDate> parseDate(String string) {
        try {
            LocalDate date = LocalDate.parse(string);
            return Optional.of(date);
        } catch (DateTimeParseException e) {
            // Date string does not match ISO format, try other formats
        }

        try {
            LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("d/M/yyyy"));
            return Optional.of(date);
        } catch (DateTimeParseException e) {
            // Date string does not match "M/d/yyyy" format, try other formats
        }

        try {
            string = string.equalsIgnoreCase("tomorrow") ? "1" : string;
            LocalDate date = LocalDate.now().plusDays(Long.parseLong(string));
            return Optional.of(date);
        } catch (NumberFormatException | DateTimeParseException e) {
            // Date string does not match "X day(s) ago" format or cannot be parsed as number
        }

        try {
            string = string.equalsIgnoreCase("yesterday") ? "1" : string;
            LocalDate date = LocalDate.now().minusDays(Long.parseLong(string));
            return Optional.of(date);
        } catch (NumberFormatException | DateTimeParseException e) {
            // Date string does not match "X day(s) ago" format or cannot be parsed as number
        }

        try {
            string = string.equalsIgnoreCase("today") ? "1" : string;
            LocalDate date = LocalDate.now()
                .plusDays(Long.parseLong(string))
                .minusDays(Long.parseLong(string));
            return Optional.of(date);
        } catch (NumberFormatException | DateTimeParseException e) {
            // Date string does not match "X day(s) ago" format or cannot be parsed as number
        }

        try {
            Matcher matcher = PATTERN.matcher(string);
            if (matcher.find()) {
                LocalDate date = LocalDate.now()
                    .minusDays(Integer.parseInt(matcher.group(1)));
                return Optional.of(date);
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            // Date string does not match "X day(s) ago" format or cannot be parsed as number
        }

        return Optional.empty();
    }

}
