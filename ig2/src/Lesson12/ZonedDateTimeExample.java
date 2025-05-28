package Lesson12;

import java.time.*;
import java.time.zone.ZoneOffsetTransition;

import static java.time.Month.MARCH;
import static java.time.Month.NOVEMBER;
import static java.time.temporal.ChronoUnit.MINUTES;

// demonstrates how to work with time zones and daylight saving time transitions using Java's ZonedDateTime, including detecting time gaps and overlaps due to DST changes

public class ZonedDateTimeExample {

    public static void main(String[] args) {
        // Define a ZoneId for US Eastern time
        ZoneId USEast = ZoneId.of("America/New_York");

        // Define a date and time for a course start
        LocalDate date = LocalDate.of(2014, MARCH, 23);
        LocalTime time = LocalTime.of(9, 30);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        // Create a ZonedDateTime using the US Eastern timezone
        ZonedDateTime courseStart = ZonedDateTime.of(date, time, USEast);

        // Get and print the zone offset (e.g., -04:00 or -05:00)
        ZoneOffset offset = courseStart.getOffset();
        System.out.println("Zone offset: " + offset);

        // Get the current time in the US Eastern timezone, truncated to minutes
        ZonedDateTime hereNow = ZonedDateTime.now(USEast).truncatedTo(MINUTES);

        System.out.println("Here now:         " + hereNow);
        System.out.println("Course start:     " + courseStart);

        // Calculate a new course start time by adding 2 days and subtracting 30 minutes
        ZonedDateTime newCourseStart = courseStart.plusDays(2).minusMinutes(30);
        System.out.println("New Course Start: " + newCourseStart);
        System.out.println("");

        // --- Gaps/Overlaps due to DST ---

        // Daylight Saving Time (DST) begins on March 9th, 2014
        // Create a ZonedDateTime just before the DST starts
        LocalDate meetDate = LocalDate.of(2014, MARCH, 8);
        LocalTime meetTime = LocalTime.of(16, 00);
        ZonedDateTime meeting = ZonedDateTime.of(meetDate, meetTime, USEast);
        System.out.println("meeting time:     " + meeting);

        // Add one day to see how DST affects the time
        ZonedDateTime newMeeting = meeting.plusDays(1);
        System.out.println("new meeting time: " + newMeeting);
        System.out.println("");

        // Check if a local date-time falls into a DST transition (gap or overlap)
        LocalDateTime lateNight = LocalDateTime.of(2014, MARCH, 9, 2, 30);
        System.out.println("Local meeting: " + lateNight);

        // Check transition rules for DST around this time
        ZoneOffsetTransition zot = USEast.getRules().getTransition(lateNight);
        if (zot != null) {
            if (zot.isGap()) {
                System.out.println("gap"); // Time does not exist due to spring forward
            }
            if (zot.isOverlap()) {
                System.out.println("overlap"); // Time occurs twice due to fall back
            }
        }
        System.out.println("");

        // DST ends on November 2nd, 2014
        // Simulate a meeting the day before DST ends
        meetDate = LocalDate.of(2104, NOVEMBER, 1); // Note: year 2104 likely a typo for 2014
        meeting = ZonedDateTime.of(meetDate, meetTime, USEast);
        System.out.println("meeting time:     " + meeting);

        // Add one day to see if overlap occurs (when clocks go back)
        newMeeting = meeting.plusDays(1);
        System.out.println("new meeting time: " + newMeeting);
    }

}
