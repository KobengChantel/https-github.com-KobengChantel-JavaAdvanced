package ch11;

import java.util.*;

/**
 * This class demonstrates basic usage of a HashMap in Java by storing,
 * retrieving, and printing key-value pairs where keys are Strings and values are Integers.
 */
public class TestMap {
  public static void main(String[] args) {
    // Create a HashMap to store names (String) as keys and their scores (Integer) as values
    Map<String, Integer> scores = new HashMap<>();

    // Add key-value pairs to the map
    scores.put("Kathy", 42);
    scores.put("Bert", 343);
    scores.put("Skyler", 420);

    // Print the entire map (all key-value pairs)
    System.out.println(scores);

    // Retrieve and print the value associated with the key "Bert"
    System.out.println(scores.get("Bert"));
  }
}
