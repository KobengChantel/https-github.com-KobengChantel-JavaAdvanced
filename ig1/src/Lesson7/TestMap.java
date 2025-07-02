package Lesson7;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Demonstrates usage of a TreeMap to store product codes as keys and product names as values, including overwriting a value and iterating keys.
public class TestMap {
    public static void main(String[] args) {
        // Create a TreeMap to hold product code (key) and product name (value) pairs
        Map<String, String> partList = new TreeMap<>();
        partList.put("S001", "Blue Polo Shirt");
        partList.put("S002", "Black Polo Shirt");
        partList.put("H001", "Duke Hat");

        // Overwrite the value for key "S002"
        partList.put("S002", "Black T-Shirt");

        // Get the set of keys from the map
        Set<String> keys = partList.keySet();

        System.out.println("=== Part List ===");
        // Iterate over keys and print the associated product names
        for (String key : keys) {
//            System.out.println("Part#: " + key + " " + partList.get(key));
            System.out.println(partList.get(key));
        }
    }
}
