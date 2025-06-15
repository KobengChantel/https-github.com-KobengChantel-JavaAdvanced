package ch12;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This program filters a list of coffee names to find those ending with "o",
 * removes duplicates, sorts them alphabetically, and prints the final list.
 */
public class CoffeeOrder {
  public static void main(String[] args) {
    // Original list of coffee names, with some duplicates
    List<String> coffees = List.of("Cappuccino",
            "Americano", "Espresso", "Cortado", "Mocha",
            "Cappuccino", "Flat White", "Latte");

    // Stream pipeline:
    // 1. filter names that end with "o"
    // 2. sort them alphabetically
    // 3. remove duplicates
    // 4. collect into a list
    List<String> coffeesEndingInO = coffees.stream()
            .filter(s -> s.endsWith("o"))   // Keep only names ending with "o"
            .sorted()                       // Sort alphabetically
            .distinct()                     // Remove duplicates
            .collect(Collectors.toList()); // Collect results into a new list

    // Output the filtered and sorted list
    System.out.println(coffeesEndingInO); // Output: [Americano, Cortado, Espresso]
  }
}
