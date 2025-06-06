package chapter19_Localization.examples.DateFormatExample;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateFormatTest {
  public static void main(String[] args) {
    
    LocalDateTime today = LocalDateTime.now();
    Locale loc = Locale.FRANCE;
    
    DateTimeFormatter df = 
      DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
        .withLocale(loc);
    System.out.println("Date: " + today.format(df) 
        + " Locale: " + loc.toString());
  }
}