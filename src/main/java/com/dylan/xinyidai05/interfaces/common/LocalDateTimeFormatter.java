package com.dylan.xinyidai05.interfaces.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author baoxiang
 * @create 2020-06-28 9:54
 */
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String s, Locale locale) throws ParseException {
        return LocalDateTime.parse(s.replaceAll("\"",""), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String print(LocalDateTime localDateTime, Locale locale) {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.parse("2020-06-28 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",Locale.CHINA)));
    }
}
 