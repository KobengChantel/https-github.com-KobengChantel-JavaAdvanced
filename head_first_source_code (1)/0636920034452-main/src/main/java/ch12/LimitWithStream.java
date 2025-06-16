package ch12;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// This program demonstrates how to use Java Streams to limit, sort, filter, and collect elements from a list of strings using various stream operations.

public class LimitWithStream {

  public static void main(String[] args) {
    streamExamples();  // Calls a method to show basic stream limit usage
  }

  // Demonstrates limiting a stream to 4 elements but doesn't perform a terminal operation, so nothing is printed from the stream itself
  static void streamExamples() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    Stream<String> stream = strings.stream();
    Stream<String> limit = stream.limit(4);
    System.out.println("limit = " + limit); // Prints the stream object reference, not its contents
  }

  // Applies the limit operation and uses count() as the terminal operation to count how many elements are in the limited stream
  void limitWithCountTerminal() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    Stream<String> stream = strings.stream();
    Stream<String> limit = stream.limit(4);
    long result = limit.count();  // Counts the 4 limited elements
    System.out.println("result = " + result);
  }

  // Applies limit and collects the result into a list
  void limitWithCollect() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    Stream<String> stream = strings.stream();
    Stream<String> limit = stream.limit(4);
    List<String> result = limit.collect(Collectors.toList());  // Collects the first 4 elements into a list
    System.out.println("result = " + result);
  }

  // Performs the stream limit in a single chain and collects to a list
  void limitAsStream() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    List<String> result = strings.stream()
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Demonstrates chained operations: sorting, limiting, and skipping elements
  void chainedOperations() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    // Sorts alphabetically and limits to 4 elements
    List<String> result = strings.stream()
            .sorted()
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);

    // Sorts alphabetically, skips 3 elements, then limits to the next 4
    List<String> result2 = strings.stream()
            .sorted()
            .skip(3)
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result2);
  }

  // Sorts strings case-insensitively and limits to 4 elements
  void sortingCaseInsensitive() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    List<String> result = strings.stream()
            .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Filters strings with length less than 4 and collects the result
  void filtering() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    List<String> result = strings.stream()
            .filter(s -> s.length() < 4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Shows that the original list is unchanged after stream operations
  static void printCollectionAfterChanges() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
    List<String> result = strings.stream()
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("strings = " + strings); // Original list
    System.out.println("result = " + result);   // New limited list
  }

  // Demonstrates an error scenario: a stream cannot be reused after a terminal operation like collect()
  static void noReusing() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    Stream<String> limit = strings.stream()
            .limit(4);
    List<String> result = limit.collect(Collectors.toList()); // First terminal operation
    List<String> result2 = limit.collect(Collectors.toList()); // ERROR: Stream already operated upon or closed
  }

}
