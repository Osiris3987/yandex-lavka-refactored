package com.example.yandexlavkarefactored.utils;

import com.example.yandexlavkarefactored.domain.period.Period;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TimeParser {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
    private static final DateTimeFormatter formatterToString = DateTimeFormatter.ofPattern("HH:mm");

    public static String mapPeriodToString(Period period) {
        return period.getFromTime().format(formatterToString) + "-" + period.getToTime().format(formatterToString);
    }

    public static Period parsePeriod(String input) {
        String[] times = input.split("-");
        LocalTime from = LocalTime.parse(times[0], formatter);
        LocalTime to = LocalTime.parse(times[1], formatter);
        Period period = new Period();
        period.setFromTime(from);
        period.setToTime(to);
        return period;
    }

    public static List<Period> parsePeriods(List<String> input){
        return input.stream().map(TimeParser::parsePeriod).toList();
    }
}
