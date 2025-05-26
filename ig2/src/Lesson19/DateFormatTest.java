package Lesson19;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatTest {
  public static void main(String[] args) {
    
    LocalDateTime today = LocalDateTime.now();
    Locale loc = Locale.FRANCE;
    Locale loc2 = Locale.GERMANY;
    
    DateTimeFormatter df = 
      DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        .withLocale(loc);
    DateTimeFormatter df2 =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                    .withLocale(loc2);
    System.out.println("Date: " + today.format(df) 
        + " Locale: " + loc.toString());
    System.out.println("Date: " + today.format(df2)
            + " Locale: " + loc2.toString());
  }
}