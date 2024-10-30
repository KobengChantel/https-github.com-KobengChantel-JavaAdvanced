package DummiesBook.Book5.chapter4_DateAndTime;

import java.util.*;
import java.time.*;
public class TimeTester
{
    public static void main(String[] args)
    {
        System.out.println("\nLocalTime: "
                + LocalTime.now().toString());
        System.out.println("\nLocalDateTime: "
                + LocalDateTime.now().toString());
        System.out.println("\nZonedDateTime: "
                + ZonedDateTime.now().toString());
        System.out.println("\nOffsetTime: "
                + OffsetTime.now().toString());
        System.out.println("\nOffsetDateTime: "
                + OffsetDateTime.now().toString());
        System.out.println("\nMonthDay: "
                + MonthDay.now().toString());
        System.out.println("\nYearMonth: "
                + YearMonth.now().toString());
        System.out.println("\nInstant: "
                + Instant.now().toString());
    }
}
