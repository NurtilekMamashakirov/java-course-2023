package edu.hw5.Task3.DateParseChain;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateWithDashParseProcessor extends DataParseProcessor {

    private static final Pattern PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");

    public DateWithDashParseProcessor(DataParseProcessor nextDataParseProcessor) {
        super(nextDataParseProcessor);
    }

    @Override
    public Optional<LocalDate> isParsed(String stringDate) {
        Matcher matcher = PATTERN.matcher(stringDate);
        if (matcher.matches()) {
            return Optional.of(LocalDate.parse(stringDate));
        } else if (nextDataParseProcessor != null) {
            return nextDataParseProcessor.isParsed(stringDate);
        } else {
            return Optional.empty();
        }
    }
}
