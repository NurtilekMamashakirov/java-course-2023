package edu.hw5.Task3.DateParseChain;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaysAgoDateParseProcessor extends DataParseProcessor {

    private final static Pattern PATTERN = Pattern.compile("(\\d+) days? ago");

    public DaysAgoDateParseProcessor(DataParseProcessor nextDataParseProcessor) {
        super(nextDataParseProcessor);
    }

    @Override
    public Optional<LocalDate> isParsed(String stringDate) {
        Matcher matcher = PATTERN.matcher(stringDate);
        if (matcher.matches()) {
            int daysAgo = Integer.parseInt(matcher.group(1));
            return Optional.of(LocalDate.now().minusDays(daysAgo));
        } else if (nextDataParseProcessor != null) {
            return nextDataParseProcessor.isParsed(stringDate);
        } else {
            return Optional.empty();
        }
    }

}
