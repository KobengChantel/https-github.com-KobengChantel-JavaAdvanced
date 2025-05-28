/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lesson12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import static java.time.Month.JUNE;
import static java.time.Month.MARCH;

/**
 *
 * @author tmcginn
 */
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FluentExamples {

    /**
     * Demonstrates the fluent API of the java.time package for building dates and times.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a birthday using LocalDate.of - can be confusing due to numeric month (6 = June)
        LocalDate myBday = LocalDate.of(1970, 6, 11); // Is it June 11 or Nov 6?

        // Create the same date using a more readable, fluent approach
        myBday = Year.of(1970).atMonth(Month.JUNE).atDay(11); // Clearly June 11, 1970

        // Define a formatter for medium-style localized date and time
        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        // Schedule a meeting on March 25, 2014 at 12:30 PM (no timezone yet)
        LocalDateTime meeting = LocalDate.of(2014, Month.MARCH, 25).atTime(12, 30);
        System.out.println("meeting:      " + meeting.format(format)); // Outputs local time

        // Assign the meeting to London time zone
        ZonedDateTime meetingUK = meeting.atZone(ZoneId.of("Europe/London"));
        System.out.println("meetingUK:    " + meetingUK.format(format));

        // Convert that time to San Francisco (America/Los_Angeles) time zone
        ZonedDateTime earlyMeeting = meetingUK.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println("earlyMeeting: " + earlyMeeting.format(format));
    }
}

