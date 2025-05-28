package Lesson12;

import java.time.LocalDate; // Import class for representing dates (no time)
import static java.lang.System.out; // Static import for simpler output syntax
import static java.time.DayOfWeek.TUESDAY; // Static import to refer to TUESDAY directly
import static java.time.temporal.TemporalAdjusters.next; // Import for date adjustment (e.g., next Tuesday)

public class LocalDateExample {

    public static void main(String[] args) {
        // Declare LocalDate variables
        LocalDate now, bDate, nowPlusMonth, nextTues;

        // Get the current date
        now = LocalDate.now();
        out.println("Now: " + now);

        // Create a specific date (Java's birthday)
        bDate = LocalDate.of(1995, 5, 23);
        out.println("Java's Bday: " + bDate);

        // Check if Java's birthday is before today's date
        out.println("Is Java's Bday in the past? " + bDate.isBefore(now));

        // Check if the year 1995 was a leap year
        out.println("Is Java's Bday in a leap year? " + bDate.isLeapYear());

        // Get the day of the week for Java's birthday
        out.println("Java's Bday day of the week: " + bDate.getDayOfWeek());

        // Calculate the date one month from today
        nowPlusMonth = now.plusMonths(1);
        System.out.println("Now: " + now); // Reprint today's date
        out.println("The date a month from now: " + nowPlusMonth);

        // Find the date of the next Tuesday after today
        nextTues = now.with(next(TUESDAY));
        out.println("Next Tuesday's date: " + nextTues);
    }
}
