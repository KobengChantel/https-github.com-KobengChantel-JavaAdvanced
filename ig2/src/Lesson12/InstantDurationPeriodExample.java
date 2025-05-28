/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson12;

import java.time.*;

import static java.time.Month.DECEMBER;
import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author tmcginn
 */
import java.time.*;
import java.time.temporal.ChronoUnit;
import static java.time.Month.*;
import static java.time.temporal.ChronoUnit.DAYS;

public class InstantDurationPeriodExample {

    /**
     * Demonstrates the use of Instant, Duration, Period, and other temporal classes.
     */
    public static void main(String[] args) throws InterruptedException {
        // ========================
        // Instant (Machine Time)
        // ========================
        // Capture the current instant in UTC
        Instant now = Instant.now();

        // Pause the thread briefly (1 nanosecond)
        Thread.sleep(0, 1);

        // Capture another instant shortly after the first
        Instant later = Instant.now();

        // Compare two instants
        System.out.println("now is before later? " + now.isBefore(later));
        System.out.println("Now:   " + now);   // Outputs ISO 8601 instant
        System.out.println("Later: " + later);
        System.out.println("");

        // ========================
        // Period (Human-based time: days, months, years)
        // ========================
        // Create a period of one day
        Period oneDay = Period.ofDays(1);
        System.out.println("Period of one day: " + oneDay);

        // Set a specific date and time before DST in Johannesburg
        LocalDateTime beforeDST = LocalDateTime.of(2014, MARCH, 8, 12, 0);
        ZonedDateTime SATime = ZonedDateTime.of(beforeDST, ZoneId.of("Africa/Johannesburg"));

        // Add the period of one day
        System.out.println("Before: " + SATime);
        System.out.println("After:  " + SATime.plus(oneDay));
        System.out.println("");

        // ========================
        // Duration (Precise time: seconds, nanoseconds)
        // ========================
        // Create a 24-hour duration
        Duration one24hourDay = Duration.ofDays(1);
        System.out.println("Duration of one day: " + one24hourDay);

        // Use the same starting point as above
        beforeDST = LocalDateTime.of(2014, MARCH, 8, 12, 0);
        SATime = ZonedDateTime.of(beforeDST, ZoneId.of("Africa/Johannesburg"));

        // Add the exact duration of 24 hours
        System.out.println("Before: " + SATime);
        System.out.println("After:  " + SATime.plus(one24hourDay));
        System.out.println("");

        // ========================
        // Temporal Calculation
        // ========================
        // Define Christmas date
        LocalDate christmas = LocalDate.of(2014, DECEMBER, 25);

        // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate total days until Christmas
        long days = DAYS.between(today, christmas);
        System.out.println("There are " + days + " shopping days til Christmas");

        // Use Period to get months and days until Christmas
        Period tilXMas = Period.between(today, christmas);
        System.out.println("There are " + tilXMas.getMonths() + " months and " + tilXMas.getDays() + " days til Christmas");
    }
}
