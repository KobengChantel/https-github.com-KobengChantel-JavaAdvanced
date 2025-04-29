package chapter14_NIO_2.examples.EmployeeSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * Example demonstrating how to stream keys and values of a Map.
 * The code filters and processes map keys and values based on specific criteria.
 *
 * Author: Oracle
 */
public class A05MapStream {

    public static void main(String[] args) {

        // Create a HashMap to store state abbreviations and their capitals
        Map<String, String> stMap = new HashMap<>();

        // Populate the map with some initial key-value pairs
        stMap.put("WY", "Cheyenne");   // Wyoming
        stMap.put("SD", "Pierre");    // South Dakota
        stMap.put("CO", "Denver");    // Colorado
        stMap.put("CA", "Sacramento");// California
        stMap.put("DE", "Dover");     // Delaware

        // Stream through the keys of the map (state abbreviations)
        // Filter the keys that start with "C" and print them
        stMap.keySet().stream()
                .filter(s -> s.startsWith("C")) // Filters keys starting with 'C'
                .forEach(s -> System.out.println("State:  " + s));

        // Stream through the values of the map (city names)
        // Filter the values that start with "D" and print them
        stMap.values().stream()
                .filter(s -> s.startsWith("D")) // Filters values starting with 'D'
                .forEach(s -> System.out.println("City: " + s));
    }
}
