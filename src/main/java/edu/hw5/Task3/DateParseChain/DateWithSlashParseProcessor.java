package edu.hw5.Task3.DateParseChain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateWithSlashParseProcessor extends DataParseProcessor {

    private final static Pattern PATTERN = Pattern.compile("^\\d{1,2}/\\d{1,2}/\\d{4}$");
    private final static String DATE_FORMAT = "d/M/yyyy";

    public DateWithSlashParseProcessor(DataParseProcessor nextDataParseProcessor) {
        super(nextDataParseProcessor);
    }

    @Override
    public Optional<LocalDate> isParsed(String stringDate) {
        Matcher matcher = PATTERN.matcher(stringDate);
        if (matcher.matches()) {
            return Optional.of(LocalDate.parse(stringDate, DateTimeFormatter.ofPattern(DATE_FORMAT)));
        } else if (nextDataParseProcessor != null) {
            return nextDataParseProcessor.isParsed(stringDate);
        } else {
            return Optional.empty();
        }
    }
}
