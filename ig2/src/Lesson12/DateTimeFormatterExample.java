/**
 * To change this license header,
 * choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 *and open the template in the editor
 */

package Lesson12;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * A class demonstrating various ways to format date and time using Java's DateTimeFormatter.
 * Author: tmcginn
 */
public class DateTimeFormatterExample {
    public static void main(String[] args) {
        // Get the current date and time with timezone information
        ZonedDateTime now = ZonedDateTime.now();

        // Format the date and time using the ISO_DATE_TIME format
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(now.format(formatter)); // e.g., 2025-05-28T10:15:30+01:00[Europe/London]

        // Change formatter to ISO_ORDINAL_DATE, which includes the year and day-of-year
        formatter = DateTimeFormatter.ISO_ORDINAL_DATE;
        System.out.println(now.format(formatter)); // e.g., 2025-148

        // Format the date using a custom pattern
        // Pattern includes: full weekday name, full month name, day, year with era,
        // 12-hour time with AM/PM, quarter of year, and time-zone ID
        formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy G, hh:mm a 'Q'q VV");
        System.out.println(now.format(formatter)); // e.g., Wednesday, May 28, 2025 AD, 10:15 AM Q2 Europe/London

        // Format the date and time using a localized medium format
        formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(now.format(formatter)); // e.g., May 28, 2025, 10:15:30 AM
    }
}

