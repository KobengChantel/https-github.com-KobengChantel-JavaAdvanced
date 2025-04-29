package chapter14_NIO_2.examples.EmployeeSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Example of using `computeIfAbsent` in a Map.
 * Demonstrates adding a placeholder value for a key if the key is not already present in the map.
 *
 * Author: Oracle
 */
public class A03ComputeIfAbsent {

    // Define a constant placeholder value for absent keys
    private static final String placeHolder = "TBD";

    public static void main(String[] args) {

        // Create a HashMap to store state abbreviations and their capitals
        Map<String, String> stMap = new HashMap<>();

        // Populate the map with some initial values
        stMap.put("WY", "Cheyenne"); // Wyoming
        stMap.put("SD", "Pierre");   // South Dakota
        stMap.put("CO", "Denver");   // Colorado

        // Use computeIfAbsent to add a placeholder if the key "AL" (Alabama) is not present
        // If "AL" is already in the map, this will do nothing
        stMap.computeIfAbsent("AL", v -> placeHolder);

        // Print the entire map to the console
        System.out.println("=== Print Map ===");
        stMap.forEach(
                (k, v) -> System.out.println("Key: " + k + " "
                        + "Value: " + v));
    }
}
