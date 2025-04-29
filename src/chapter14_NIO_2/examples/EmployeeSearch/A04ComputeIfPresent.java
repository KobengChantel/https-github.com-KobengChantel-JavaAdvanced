package chapter14_NIO_2.examples.EmployeeSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Example of using `computeIfPresent` in a Map.
 * Demonstrates modifying the value associated with a key if the key is present in the map.
 *
 * Author: Oracle
 */
public class A04ComputeIfPresent {

    public static void main(String[] args) {

        // Create a HashMap to store state abbreviations and their capitals
        Map<String, String> stMap = new HashMap<>();

        // Populate the map with some initial key-value pairs
        stMap.put("WY", "Cheyenne"); // Wyoming
        stMap.put("SD", "Pierre");   // South Dakota
        stMap.put("CO", "Denver");   // Colorado

        // Use computeIfPresent to update the value for the key "WY"
        // If "WY" is present, modify the value by appending "(Verified WY)"
        stMap.computeIfPresent("WY",
                (k, v) -> v + " (Verified " + k + ")");

        // Print the entire map to the console
        System.out.println("=== Print Map ===");
        stMap.forEach(
                (k, v) -> System.out.println("Key: " + k + " "
                        + "Value: " + v));
    }
}
