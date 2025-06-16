package ch12;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// This program demonstrates Java Stream operations like filtering, sorting, and collecting elements from a list, as well as shows improper stream reuse.

public class StreamStuff {
  public static void main(String[] args) {
    // List of different coffee types
    List<String> coffees = List.of("Cappuccino",
            "Americano", "Espresso", "Cortado", "Mocha",
            "Cappuccino", "Flat White", "Latte");

    // Create a stream that filters coffee names ending with "o" and sorts them
    Stream<String> stream1 = coffees.stream()
            .filter(s -> s.endsWith("o")) // Keep only names ending in "o"
            .sorted(); // Sort them alphabetically

    // Collect and print distinct values from the stream
    System.out.println(stream1.distinct()
            .collect(Collectors.toList())); // This line consumes the stream

    // ERROR: Stream already consumed above — this line will throw IllegalStateException at runtime
    System.out.println(stream1.collect(Collectors.toList()));

    // Create an unmodifiable list containing a single integer
    List<Integer> integers = Collections.unmodifiableList(Arrays.asList(1));
  }
}
