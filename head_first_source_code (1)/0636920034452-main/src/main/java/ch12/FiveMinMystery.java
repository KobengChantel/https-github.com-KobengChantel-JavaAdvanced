package ch12;

import java.util.List;
import java.util.Optional;

/**
 * This program demonstrates two different ways of using Java Streams:
 * one to get the alphabetically first coffee name, and another to get the name of the weakest coffee (lowest strength).
 */
public class FiveMinMystery {
  public static void main(String[] args) {
    // A list of Coffee objects with name and strength
    List<Coffee> coffees = List.of(
            new Coffee("Cappuccino", 3),
            new Coffee("Americano", 2),
            new Coffee("Espresso", 5),
            new Coffee("Cortado", 4),
            new Coffee("Mocha", 3),
            new Coffee("Flat White", 4),
            new Coffee("Latte", 3),
            new Coffee("Decaf", 1));

    // Stream #1:
    // Map each coffee to its name, sort alphabetically, get the first (alphabetically first name)
    Optional<String> afternoonCoffee = coffees.stream()
            .map(Coffee::getName) // get just the names
            .sorted()              // sort names alphabetically
            .findFirst();          // get the first name in order
    System.out.println(afternoonCoffee); // Output: Optional[Americano]

    // Stream #2:
    // Sort coffees by strength (natural order from Comparable), then get the name of the weakest
    Optional<String> weakCoffee = coffees.stream()
            .sorted()                  // sort using Comparable (by strength)
            .map(coffee -> coffee.name) // map to name
            .findFirst();              // get the name of weakest coffee
    System.out.println(weakCoffee); // Output: Optional[Decaf]
  }

  // Coffee class that implements Comparable to allow sorting by strength
  private static class Coffee implements Comparable<Coffee> {
    private final String name;
    private final int strength;

    public Coffee(String name, int strength) {
      this.name = name;
      this.strength = strength;
    }

    public String getName() {
      return name;
    }

    public int getStrength() {
      return strength;
    }

    // Sorting logic: compare based on strength
    @Override
    public int compareTo(Coffee other) {
      return this.strength - other.strength;
    }
  }
}
