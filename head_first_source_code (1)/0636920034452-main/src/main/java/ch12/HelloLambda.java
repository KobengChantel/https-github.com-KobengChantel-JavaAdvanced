package ch12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// This class demonstrates various examples of using lambda expressions, streams, and functional interfaces in Java.
public class HelloLambda {
  public static void main(String[] args) {
    longPipeline(); // Runs one stream processing example when the program starts
  }

  // Sorts a list of strings ignoring case and returns the first 4
  static void helloLambda() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    List<String> result = strings.stream()
            .sorted((s1, s2) -> {
              return s1.compareToIgnoreCase(s2);
            })
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Sorts a list using natural (default) order
  static void sortingNaturalOrder() {
    List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");

    List<String> result = strings.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Demonstrates lambda as behavior in both forEach and stream sorting
  static void lambdaAsBehaviour() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));
    String str = strings.get(2); // gets "a"
    strings.add("new String");
    strings.forEach(s -> System.out.println(s)); // prints each string

    List<String> result = strings.stream()
            .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
            .limit(4)
            .collect(Collectors.toList());
  }

  // Skips 2 elements and limits to 4 after sorting by case-insensitive comparison
  static void longPipeline() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));

    List<String> result = strings.stream()
            .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
            .skip(2)
            .limit(4)
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Uses a longer lambda syntax with explicit types and return
  static void longLambda() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));

    List<String> result = strings.stream()
            .sorted((String s1, String s2) -> {
              return s1.compareToIgnoreCase(s2);
            })
            .collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Sorts by string length in descending order using a multiline lambda
  static void multilineLambda() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));
    Stream<String> sorted = strings.stream().sorted(
            (str1, str2) -> {
              int l1 = str1.length();
              int l2 = str2.length();
              return l2 - l1;
            });

    List<String> result = sorted.collect(Collectors.toList());
    System.out.println("result = " + result);
  }

  // Compares strings using case-insensitive comparison
  static void compare() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));
    Stream<String> sorted = strings.stream().sorted(
            (str1, str2) -> str1.compareToIgnoreCase(str2));
  }

  // Demonstrates a lambda that performs side effects (prints each string with a prefix)
  static void noReturn() {
    List<String> strings = new ArrayList<>(List.of("I", "am", "a", "list", "of", "Strings"));
    strings.forEach(
            (String str) -> {
              String output = "str = " + str;
              System.out.println(output);
            }
    );
  }

  // Lambda with no parameters, passed to a thread executor
  static void noArgs() {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    executorService.submit(() -> System.out.println("Hello!"));
  }

  // Demonstrates when explicit parameter types are needed due to method overloads
  static void mandatoryTypes() {
    // Compiler needs type info to resolve which overloaded method to call
    overloadedMethod((String str) -> System.out.println(str));
  }

  // Overloaded method that accepts a Consumer<String>
  private static void overloadedMethod(Consumer<String> consumer) {
    consumer.accept("Something");
  }

  // Overloaded method that accepts a Function<Integer, Integer>
  private static void overloadedMethod(Function<Integer, Integer> function) {
    function.apply(1);
  }
}
