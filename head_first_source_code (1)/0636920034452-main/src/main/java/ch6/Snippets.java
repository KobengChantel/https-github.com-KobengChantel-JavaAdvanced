package ch6;

import java.util.ArrayList;

// This class contains various Java code snippets that demonstrate how to use ArrayLists, logical operators (AND, OR, NOT), conditionals, short-circuiting, and how to compare elements in arrays and collections.

public class Snippets {

  // Demonstrates usage of an ArrayList to store and manipulate custom objects (Egg)
  void arrayList() {
    ArrayList<Egg> myList = new ArrayList<Egg>();

    Egg egg1 = new Egg();         // Create first Egg object
    myList.add(egg1);             // Add first Egg to the list

    Egg egg2 = new Egg();         // Create second Egg object
    myList.add(egg2);             // Add second Egg to the list

    int theSize = myList.size();              // Get size of list
    boolean isIn = myList.contains(egg1);     // Check if egg1 is in the list
    int idx = myList.indexOf(egg2);           // Get index of egg2
    boolean empty = myList.isEmpty();         // Check if list is empty
    myList.remove(egg1);                      // Remove egg1 from the list
  }

  // Demonstrates the use of logical AND (&&) in an if-statement
  void andExample(int price, String camera) {
    if (price >= 300 && price < 400) {
      camera = "X"; // Assign camera type if price falls in range
    }
  }

  // Demonstrates the use of logical OR (||) in an if-statement
  void orExample(String brand) {
    if (brand.equals("A") || brand.equals("B")) {
      // do stuff for only brand A or brand B
    }
  }

  // Demonstrates complex boolean conditions with AND/OR for zoom settings
  void longBoolean(String zoomType, int zoomDegree) {
    if ((zoomType.equals("optical") &&
            (zoomDegree >= 3 && zoomDegree <= 8)) ||
            (zoomType.equals("digital") &&
                    (zoomDegree >= 5 && zoomDegree <= 12))) {
      // do appropriate zoom stuff
    }
  }

  // Demonstrates not-equal operator for integers
  void notEqualInt(int model) {
    if (model != 2000) {
      //  do non-model 2000 stuff
    }
  }

  // Demonstrates not-equal operator for Strings
  void notEqualString(String brand) {
    if (!brand.equals("X")) {
      // do non-brand X stuff
    }
  }

  // Demonstrates short-circuit evaluation using logical AND with null check
  void shortCircuit(SomeType refVar) {
    if (refVar != null &&
            refVar.isValidType()) {
      // do ‘got a valid type’ stuff
    }
  }

  // Demonstrates how to manually check if a String is in an array
  void arrayListComparedToArray(String[] myList) {
    String b = new String("Frog");

    boolean isIn = false;
    for (String item : myList) {
      if (b.equals(item)) {
        isIn = true;
        break;
      }
    }
  }

  // A nested class used for short-circuit validation demo
  private class SomeType {
    public boolean isValidType() {
      return false;
    }
  }
}
