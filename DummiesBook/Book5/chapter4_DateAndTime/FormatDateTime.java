package DummiesBook.Book5.chapter4_DateAndTime;

import java.util.*;
import java.time.*;
import java.time.format.*;
public class FormatDateTime
{
    public static void main(String[] args)
    {
        LocalDateTime now = LocalDateTime.now();
        printDate(now, "YYYY-MM-dd");
        printDate(now, "MM-dd-YYYY");
        printDate(now, "dd MMM YYYY");
        printDate(now, "MMMM d, YYYY");
        printDate(now, "HH:mm");
        printDate(now, "h:mm a");
    }

    public static void printDate(LocalDateTime date, String pattern)
    {
        DateTimeFormatter f;
        f = DateTimeFormatter.ofPattern(pattern);
        pattern = (pattern + " ").substring(0, 14);
        System.out.println(pattern + " " + date.format(f));
    }
}
