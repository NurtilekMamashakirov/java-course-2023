package edu.hw5.Task3.DateParseChain;

import java.time.LocalDate;
import java.util.Optional;

public class DayDateParseProcessor extends DataParseProcessor {

    public DayDateParseProcessor(DataParseProcessor nextDataParseProcessor) {
        super(nextDataParseProcessor);
    }

    @Override
    public Optional<LocalDate> isParsed(String stringDate) {
        if (stringDate.equalsIgnoreCase("yesterday")) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else if (stringDate.equalsIgnoreCase("today")) {
            return Optional.of(LocalDate.now());
        } else if (stringDate.equalsIgnoreCase("tomorrow")) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else if (nextDataParseProcessor != null) {
            return nextDataParseProcessor.isParsed(stringDate);
        } else {
            return Optional.empty();
        }
    }

}
