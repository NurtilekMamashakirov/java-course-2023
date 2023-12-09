package edu.hw5.Task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeAnalyze {

    private TimeAnalyze() {}

    private final static Logger LOGGER = LogManager.getLogger();
    private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd, HH:mm");
    private final static Pattern PATTERN =
        Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})$");
    private final static String WRONG_DATE_MESSAGE = "Wrong date format: ";

    private static long minusDates(Date startDate, Date endDate) {
        final long MILLISECONDS_IN_MINUTE = 60000;

        long date1Milliseconds = startDate.getTime();
        long date2Milliseconds = endDate.getTime();

        long date1Minutes = date1Milliseconds / MILLISECONDS_IN_MINUTE;
        long date2Minutes = date2Milliseconds / MILLISECONDS_IN_MINUTE;

        return Math.abs(date2Minutes - date1Minutes);
    }

    public static String analyzeTime(String... startsAndEnds) {
        long averageTime = 0;
        for (String startAndEnd : startsAndEnds) {
            Matcher matcher = PATTERN.matcher(startAndEnd);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(WRONG_DATE_MESSAGE + startAndEnd);
            }
            String[] startAndEndArray = startAndEnd.split(" - ");
            String start = startAndEndArray[0];
            String end = startAndEndArray[1];
            try {
                Date startDate = FORMATTER.parse(start);
                Date endDate = FORMATTER.parse(end);
                averageTime += minusDates(startDate, endDate);
            } catch (ParseException e) {
                LOGGER.info(e);
            }
        }
        averageTime = averageTime / startsAndEnds.length;
        return minutesToString(averageTime);
    }

    private static String minutesToString(long minutes) {
        final long MINUTES_IN_HOUR = 60;
        String minutesToString = String.valueOf(minutes % MINUTES_IN_HOUR);
        String hoursToString = String.valueOf((minutes - (minutes % MINUTES_IN_HOUR)) / MINUTES_IN_HOUR);
        return hoursToString + "ч " + minutesToString + "м";
    }

}

