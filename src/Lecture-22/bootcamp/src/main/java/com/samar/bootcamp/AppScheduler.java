package com.samar.bootcamp;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

    // fixedDelay: once completed will again start after fixedDelay
    // initialDelay: delay in first time to execute
    @Scheduled(fixedDelay = 2000, initialDelay = 3000)
    void processStart() {
        System.out.println("Hello Samar from fixedDelay scheduler !!!");
    }

    // fixedDelay: will execute again after fixedRate
    // irrespective of previously execution completion status
    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    void start() {
        System.out.println("Hello Samar from fixedRate scheduler !!!");
    }

    // Cron expression in Spring has six space-separated
    // fields: second, minute, hour, month-day, month, and week-day.
    // all:         , - * /
    // month-day:   ? L W
    // week-day:    ? L #
    // , -> multiple choices
    // - -> range
    // * -> all
    // / -> increment step-wise (start/step)
    // ? -> any (i don't care)
    // month-day L -> last day of the month (L-3 third last day)
    // week-day L -> last day of the week (6L) (always have to prefix it by a digit (0-7) or the short day notation (MON-SUN))
    // W -> specify the weekday (Monday-Friday) nearest the given day. (15W will search for nearest weekday to 15th)
    // # -> specify the nth weekday of the month (6#3 third Saturday of the month)
    // LW: last weekday of the month
    @Scheduled(cron = "5/3 * * * * *")
    void run() {
        System.out.println("Hello Samar from cron scheduler !!!");
    }
    // Q. at midnight from 5th till 23rd in interval of 5 days and from 28 to 30 of every month
    // A. 0 0 0 5-23/5,28-30 * ?
}
