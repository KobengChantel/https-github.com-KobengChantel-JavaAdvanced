package Lesson7;

import java.util.ArrayList;
import java.util.List;

// This program demonstrates basic ArrayList operations like adding elements, accessing by index, and inserting at a specific position.
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> partList = new ArrayList<>(3); // Create an ArrayList with initial capacity 3

        // Add four Integer objects to the list (auto-boxing could be used instead of new Integer())
        partList.add(new Integer(1111));
        partList.add(new Integer(2222));
        partList.add(new Integer(3333));
        partList.add(new Integer(4444));

        // Print the first element (index 0)
        System.out.println("First Part: " + partList.get(0));

        // Insert new Integer(5555) at the beginning, shifting other elements right
        partList.add(0, new Integer(5555));

        // Print the new first element after insertion
        System.out.println("First Part: " + partList.get(0));
    }
}
