package Lesson7;

import java.util.Set;
import java.util.TreeSet;

// Demonstrates using a TreeSet to store unique strings sorted alphabetically, ignoring duplicates automatically.
public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(); // TreeSet stores elements in sorted order and disallows duplicates

        // Add strings to the set
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("three"); // Duplicate, will not be added

        // Print the set (sorted and unique elements)
        System.out.println(set);

        // Alternative iteration through the set (not required here)
        // for(String s: set) {
        //     System.out.println("Item: " + s);
        // }
    }
}
