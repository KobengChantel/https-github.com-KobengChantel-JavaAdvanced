package DummiesBook.Book5.chapter4_DateAndTime;
//LIS TING 4.1
//The BirthdayFun Application


import java.util.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
public class BirthdayFun
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        do
        {
            LocalDate birthDate;
            DateTimeFormatter fullFormat =
            DateTimeFormatter.ofPattern("MMMM d, YYYY");
            DateTimeFormatter monthDayFormat =
                    DateTimeFormatter.ofPattern("MMMM d");
            System.out.println("Today is "
                    + LocalDate.now().format(fullFormat) + ".");
            System.out.println();
            System.out.print("Please enter your birthdate "
                    + "(yyyy-mm-dd): ");
            String input = sc.nextLine();

            try
            {
                birthDate = LocalDate.parse(input);
                if (birthDate.isAfter(LocalDate.now()))
                {
                    System.out.println("You haven't been born yet!");
                    continue;
                }
                System.out.println();
                System.out.println(birthDate.format(fullFormat)
                        + " was a very good day!");
                DayOfWeek birthDayOfWeek = birthDate.getDayOfWeek();
                System.out.println("You were born on a "
                        + birthDayOfWeek + ".");
                long years = birthDate.until(LocalDate.now(),
                        ChronoUnit.YEARS);
                System.out.println("You are " + years + " years young.");
                LocalDate nextBDay = birthDate.plusYears(years + 1);
                System.out.println("Your next birthday is "
                        + nextBDay.format(fullFormat) + ".");
                long wait = LocalDate.now().until(nextBDay,
                        ChronoUnit.DAYS);
                System.out.println("That's just " + wait
                        + " days from now!");
                LocalDate halfBirthday = birthDate.plusMonths(6);
                System.out.println("Your half-birthday is "
                        + halfBirthday.format(monthDayFormat) + ".");
            }
            catch (DateTimeParseException ex)
            {
                System.out.println("Sorry, that is not a valid date.");
            }
        } while(askAgain());
    }
    private static boolean askAgain()
    {
        System.out.println();
        System.out.print("Another? (Y or N) ");

        String reply = sc.nextLine();
        if (reply.equalsIgnoreCase("Y"))
        {
            return true;
        }
        return false;
    }
}