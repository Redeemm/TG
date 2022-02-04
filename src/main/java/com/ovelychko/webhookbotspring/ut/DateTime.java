package com.ovelychko.webhookbotspring.ut;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTime {
    public static String Date() {
        Locale locale = new Locale("en", "EN");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        return date;
    }

    public static void Time() {
        Date currentTime = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:00");
        if (Time.valueOf("19:25:00").equals(timeFormat.format(currentTime))) {
            System.out.println("correct");
        }else System.out.println("wrong");
    }
}
