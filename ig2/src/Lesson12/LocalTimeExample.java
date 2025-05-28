package Lesson12;


import java.time.LocalTime;

import static java.lang.System.out;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class LocalTimeExample {

    public static void main(String[] args) {
        // Declare LocalTime variables
        LocalTime now, nowPlus, nowHrsMins, lunch, bedtime;

        // Get the current local time
        now = LocalTime.now();
        out.println("The time now is: " + now);

        // Add 1 hour and 15 minutes to the current time
        nowPlus = now.plusHours(1).plusMinutes(15);
        out.println("What time is it 1 hour 15 minutes from now? " + nowPlus);

        // Truncate the current time to the nearest minute (removes seconds and nanoseconds)
        nowHrsMins = now.truncatedTo(MINUTES);
        out.println("Truncate the current time to minutes: " + nowHrsMins);

        // Print the minute of the day (from 0 to 1439)
        out.println("It is the " + now.toSecondOfDay()/60 + "th minute of the day.");

        // Set lunch time to 12:30
        lunch = LocalTime.of(12, 30);

        // Check if lunch is still in the future
        out.println("Is lunch in my future? " + lunch.isAfter(now));

        // Calculate minutes until lunch time
        long minsToLunch = now.until(lunch, MINUTES);
        out.println("Minutes til lunch: " + minsToLunch);

        // Set bedtime to 21:00 (9 PM)
        bedtime = LocalTime.of(21, 0);

        // Calculate hours until bedtime
        long hrsToBedtime = now.until(bedtime, HOURS);
        out.println("How many hours until bedtime? " + hrsToBedtime);

        // calculate minutes in a year (Note: this comment is a placeholder; no implementation present)
    }
}
