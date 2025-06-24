package Lesson7.ex07_1_exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// This program counts occurrences of product codes from a sales list and prints a report matching product names to their total sales.
public class ProductCounter {
    // Map to count occurrences of each product code
    private Map<String, Long> productCountMap = new HashMap<>();

    // Map to associate product names with product codes (e.g., "Blue Polo Shirt" → "1S01")
    private Map<String, String> productNames = new TreeMap<>();

    public static void main(String[] args) {
        // List of sold product codes
        String[] parts = new String[]{
                "1S01", "1S01", "1S01", "1S01", "1S01",
                "1S02", "1S02", "1S02",
                "1H01", "1H01",
                "1S02", "1S01", "1S01",
                "1H01", "1H01", "1H01",
                "1S02", "1S02",
                "1M02", "1M02", "1M02"
        };

        // Map of product names to product codes
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug", "1M02"); // removed extra spaces from "Duke Mug   "

        // Create ProductCounter object with product name map
        ProductCounter pc1 = new ProductCounter(productNames);

        // Count product code occurrences in the array
        pc1.processList(parts);

        // Print a formatted report
        pc1.printReport();
    }

    // Constructor: receives the product name → code mapping
    public ProductCounter(Map<String, String> productNames) {
        this.productNames = productNames;
    }

    // Count how many times each product code appears in the list
    public void processList(String[] list) {
        for (String itemNumber : list) {
            productCountMap.put(itemNumber, productCountMap.getOrDefault(itemNumber, 0L) + 1);
        }
    }

    // Print report showing name and count for each product
    public void printReport() {
        System.out.println("=== Product Report ===");
        for (String productName : productNames.keySet()) {
            String productCode = productNames.get(productName);
            Long count = productCountMap.getOrDefault(productCode, 0L);
            System.out.printf("Name: %-20s\tCount: %d%n", productName, count);
        }
    }
}
