package ch6;

import java.util.ArrayList;

// This code demonstrates manipulation of an ArrayList by adding, checking, removing, and conditionally inserting elements, with the state of the list printed after each change.

public class ArrayListMagnet {
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<String>();  // Create a new ArrayList of Strings
    a.add(0, "zero");    // Add "zero" at index 0
    a.add(1, "one");     // Add "one" at index 1
    a.add(2, "two");     // Add "two" at index 2
    a.add(3, "three");   // Add "three" at index 3
    printList(a);        // Print the list

    if (a.contains("three")) {  // If list contains "three"
      a.add("four");            // Add "four" to the end
    }
    a.remove(2);                // Remove the element at index 2 ("two")
    printList(a);               // Print the list

    if (a.indexOf("four") != 4) { // If "four" is not at index 4
      a.add(4, "4.2");            // Add "4.2" at index 4
    }
    printList(a);                 // Print the list

    if (a.contains("two")) {      // If list contains "two"
      a.add("2.2");               // Add "2.2" to the end
    }
    printList(a);                 // Print the list
  }

  public static void printList(ArrayList<String> list) {
    for (String element : list) {
      System.out.print(element + "  ");  // Print each element in the list
    }
    System.out.println();                // Move to next line after printing all elements
  }
}
