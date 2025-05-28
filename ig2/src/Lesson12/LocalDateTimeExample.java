package Lesson12;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.System.out;
import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.DAYS;


public class LocalDateTimeExample {

    public static void main(String[] args) {
        // Declare LocalDateTime variables
        LocalDateTime meeting, flight, courseStart, courseEnd;

        // Create a meeting date and time: March 21, 2014 at 13:30
        meeting = LocalDate.of(2014, MARCH, 21).atTime(13, 30);
        out.println("Meeting is on: " + meeting);

        // Create a flight date: March 31, 2014
        LocalDate flightDate = LocalDate.of(2014, MARCH, 31);

        // Create a flight time: 21:45
        LocalTime flightTime = LocalTime.of(21, 45);

        // Combine flight date and time into a LocalDateTime object
        flight = LocalDateTime.of(flightDate, flightTime);
        out.println("Flight leaves: " + flight);

        // Set course start date and time: March 24, 2014 at 9:00 AM
        courseStart = LocalDateTime.of(2014, MARCH, 24, 9, 00);

        // Course duration is 4 days and 8 hours
        courseEnd = courseStart.plusDays(4).plusHours(8);
        out.println("Course starts: " + courseStart);
        out.println("Course ends:   " + courseEnd);

        // Estimate total course hours (approximation for illustrative purposes)
        long courseHrs = (courseEnd.getHour() - courseStart.getHour()) * (courseStart.until(courseEnd, DAYS) + 1);
        out.println("Course is:     " + courseHrs + " hours long.");
    }
}
