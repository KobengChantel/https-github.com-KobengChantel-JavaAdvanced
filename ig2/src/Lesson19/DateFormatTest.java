package Lesson19;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

// This class demonstrates how to format the current date according to different locales.
public class DateFormatTest {
  public static void main(String[] args) {

    // Get the current date and time
    LocalDateTime today = LocalDateTime.now();

    // Define two locales: France and Germany
    Locale loc = Locale.FRANCE;
    Locale loc2 = Locale.GERMANY;

    // Create a date formatter for FULL style date formatting with French locale
    DateTimeFormatter df =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                    .withLocale(loc);

    // Create a date formatter for FULL style date formatting with German locale
    DateTimeFormatter df2 =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                    .withLocale(loc2);

    // Print the formatted date using French locale and display locale name
    System.out.println("Date: " + today.format(df)
            + " Locale: " + loc.toString());

    // Print the formatted date using German locale and display locale name
    System.out.println("Date: " + today.format(df2)
            + " Locale: " + loc2.toString());
  }
}
