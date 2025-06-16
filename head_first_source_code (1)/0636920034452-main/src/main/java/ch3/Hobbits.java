package ch3;

// This class demonstrates object creation, array initialization, and basic conditional logic to assign different names to Hobbit objects and print them.

class Hobbits {
  String name; // Instance variable to hold the name of the Hobbit

  public static void main(String[] args) {
    Hobbits[] h = new Hobbits[3]; // Create an array to hold 3 Hobbit objects
    int z = -1;

    // Loop to initialize each Hobbit object and assign a specific name
    while (z < 2) {
      z = z + 1;
      h[z] = new Hobbits();         // Create a new Hobbit object
      h[z].name = "bilbo";          // Default name
      if (z == 1) {
        h[z].name = "frodo";        // Change name to "frodo" for index 1
      }
      if (z == 2) {
        h[z].name = "sam";          // Change name to "sam" for index 2
      }

      // Print the name and a message
      System.out.print(h[z].name + " is a ");
      System.out.println("good Hobbit name");
    }
  }
}
