package ch6;

import java.util.ArrayList;

// This class demonstrates the basic usage and comparison of `ArrayList` and arrays for storing, accessing, modifying, and checking the presence of elements.

public class SharpenYourPencil {

  // Demonstrates operations using an ArrayList
  void arrayListCode() {
    ArrayList<String> myList = new ArrayList<String>(); // Create an empty ArrayList

    String a = "whoohoo";
    myList.add(a); // Add "whoohoo" to the list

    String b = "Frog";
    myList.add(b); // Add "Frog" to the list

    int theSize = myList.size(); // Get the size of the list

    String str = myList.get(1); // Retrieve the element at index 1 ("Frog")

    myList.remove(1); // Remove the element at index 1

    boolean isIn = myList.contains(b); // Check if "Frog" is still in the list
  }

  // Demonstrates similar operations using a standard array
  void arrayCode() {
    String[] myList = new String[2]; // Create a String array of size 2

    String a = "whoohoo";
    myList[0] = a; // Assign "whoohoo" to index 0

    String b = "Frog";
    myList[1] = b; // Assign "Frog" to index 1

    int theSize = myList.length; // Get the length of the array

    String str = myList[1]; // Retrieve the element at index 1

    myList[1] = null; // Remove the element by setting index 1 to null

    boolean isIn = false;
    for (String item : myList) { // Check if "Frog" is still in the array
      if (b.equals(item)) {
        isIn = true;
        break;
      }
    }
  }
}
