package chapter12_DateTime.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.Month.*;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author tmcginn
 */
public class Fluent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Not very readable - is this June 11 or November 6th?
        LocalDate myBday = LocalDate.of(1970, 6, 11);
        // A fluent approach
        myBday = Year.of(1970).atMonth(JUNE).atDay(11);

        DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        // Schedule a meeting fluently
        LocalDateTime meeting = LocalDate.of(2014, MARCH, 25).atTime(12, 30);
        System.out.println("meeting:      " + meeting.format(format));

        // Schedule that meeting using the London timezone
        ZonedDateTime meetingUK = meeting.atZone(ZoneId.of("Europe/London"));
        System.out.println("meetingUK:    " + meetingUK.format(format));

        // What time is in San Francisco for that meeting?
        ZonedDateTime earlyMeeting = meetingUK.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
        System.out.println("earlyMeeting: " + earlyMeeting.format(format));

    }

}
