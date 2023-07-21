package io.github.peterkaivo.muzmuz.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for {@link java.util.Date} conversion
 */
public class DateUtils {
    private static final SimpleDateFormat MUZMUZ_DATE_FORMAT = new SimpleDateFormat("dd. MM. yyyy");
    private static final SimpleDateFormat SQL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date stringToDate(String sDate) {
        try {
            return MUZMUZ_DATE_FORMAT.parse(sDate);
        } catch (ParseException e) {
            System.err.println(e);
            return null;
        }
    }

    public static String dateToString(Date date) {
        return MUZMUZ_DATE_FORMAT.format(date);
    }
}
