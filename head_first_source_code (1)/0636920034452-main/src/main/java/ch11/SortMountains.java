package ch11;

import java.util.*;

// This class demonstrates sorting a list of Mountain objects first by name alphabetically and then by height in descending order.
public class SortMountains {
  public static void main(String[] args) {
    new SortMountains().go();
  }

  public void go() {
    // Create a list to hold Mountain objects
    List<Mountain> mountains = new ArrayList<>();

    // Add Mountain instances to the list with their names and heights
    mountains.add(new Mountain("Longs", 14255));
    mountains.add(new Mountain("Elbert", 14433));
    mountains.add(new Mountain("Maroon", 14156));
    mountains.add(new Mountain("Castle", 14265));

    // Print the list as originally entered
    System.out.println("as entered:\n" + mountains);

    // Sort the mountains by their name in ascending alphabetical order and print the list
    mountains.sort((mount1, mount2) -> mount1.name.compareTo(mount2.name));
    System.out.println("by name:\n" + mountains);

    // Sort the mountains by their height in descending order and print the list
    mountains.sort((mount1, mount2) -> mount2.height - mount1.height);
    System.out.println("by height:\n" + mountains);
  }
}

// Class representing a Mountain with a name and height
class Mountain {
  final String name;
  final int height;

  Mountain(String name, int height) {
    this.name = name;
    this.height = height;
  }

  // Provide a string representation of Mountain objects for printing
  public String toString() {
    return name + " " + height;
  }
}
