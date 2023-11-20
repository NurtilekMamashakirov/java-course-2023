package edu.hw5.Task3.DateParseChain;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DataParseProcessor {

    public DataParseProcessor nextDataParseProcessor;

    public DataParseProcessor(DataParseProcessor nextDataParseProcessor) {
        this.nextDataParseProcessor = nextDataParseProcessor;
    }

    public abstract Optional<LocalDate> isParsed(String stringDate);
}
