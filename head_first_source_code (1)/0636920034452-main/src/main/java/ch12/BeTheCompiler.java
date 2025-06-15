package ch12;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This class demonstrates the use of lambda expressions in Java for functional interfaces
 * such as Runnable, Consumer, Supplier, Function, and Comparator, along with examples of valid and invalid lambda assignments.
 */
public class BeTheCompiler {
  public static void main(String[] args) {
    // A Runnable lambda that prints "Hi!" when run
    Runnable runnable = () -> System.out.println("Hi!");

    // A Consumer lambda that takes a string and prints it
    Consumer<String> consumer = s -> System.out.println(s);

    // ❌ INVALID: Supplier must return a value, not print
    // Supplier<String> supplier3 = () -> System.out.println("Some string");

    // ❌ INVALID: Consumer only accepts one parameter
    // Consumer<String> consumer2 = (s1, s2) -> System.out.println(s1 + s2);

    // ❌ INVALID: Runnable's run() takes no arguments
    // Runnable runnable2 = (String str) -> System.out.println(str);

    // A Function that takes a String and returns its length
    Function<String, Integer> function = s -> s.length();

    // A Supplier that returns a string value
    Supplier<String> supplier = () -> "Some string";

    // ❌ INVALID: Consumer expects void return type, not a value-producing expression
    // Consumer<String> consumer3 = s -> "String" + s;

    // ❌ INVALID: Function parameter type mismatch and return type is String, not Integer
    // Function<String, Integer> function3 = (Integer i) -> "i = " + i;

    // ❌ INVALID: Supplier lambda should take no arguments
    // Supplier<String> supplier2 = s -> "Some string: " + s;

    // ❌ INVALID: Function lambda must return Integer, not void
    // Function<String, Integer> function2 = () -> System.out.println("Some string");
  }

  void book() {
    // These are commented examples for learners to assess whether they are valid lambda assignments
  }

  void assignToVariable() {
    // A Comparator that compares strings ignoring case
    Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);

    // A Runnable that prints "Hello!"
    Runnable runnable = () -> System.out.println("Hello!");

    // A Consumer that prints the input string
    Consumer<String> consumer = str -> System.out.println(str);

    // A Supplier that returns a string
    Supplier<String> supplier = () -> "Returned from a lambda";
  }
}
