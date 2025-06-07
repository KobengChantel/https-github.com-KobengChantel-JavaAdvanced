package Lesson19;

import java.text.NumberFormat;
import java.util.Locale;

// This class demonstrates formatting a currency value according to a specific locale.
public class NumberTest {

  public static void main(String[] args) {

    // Set the locale to United Kingdom
    Locale loc = Locale.UK;

    // Get a currency formatter for the UK locale
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);

    // Define a money amount to format
    double money = 1_000_000.00d;

    // Print the formatted currency string along with the locale information
    System.out.println("Money: " + nf.format(money) + " in Locale: " + loc);
  }
}
