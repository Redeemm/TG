package com.ovelychko.webhookbotspring.ut.scheduler;

import java.util.Calendar;
import java.util.Scanner;
import java.util.TimerTask;

public class Timer {
    public static Scanner scanner = new Scanner(System.in);
    public static int DayNumber;
    public static String Days;
    public static String AtPlace;
    public static String CourseTitle;
    public static int Hour_of_day;
    public static int Minutes;


    public static void asd() {

        java.util.Timer timer = new java.util.Timer();

        System.out.println("What is the course title: ");
        CourseTitle = scanner.next();
        System.out.println("What is the Hour:");
        Hour_of_day = scanner.nextInt();
        System.out.println("What is the Minute: ");
        Minutes = scanner.nextInt();

        Calendar calendar = Calendar.getInstance();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("You have a class. The Course Title is " + CourseTitle);
                timer.notify();
            }
        };

        calendar.set(Calendar.HOUR_OF_DAY,Hour_of_day);
        calendar.set(Calendar.MINUTE,Minutes);
//
        timer.schedule(task,calendar.getTime(),1000);

    }
}
