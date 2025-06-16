package ch3;

// This class contrasts two methods of creating Contact objects to highlight the difference between using an array of objects and a single reference variable.

public class FiveMinuteMystery {

  // This method creates an array to store 10 Contact objects and initializes each element.
  void solution1() {
    int x = 0;
    Contact[] contacts = new Contact[10]; // Declares an array to hold 10 Contact references
    while (x < 10) {                      // Loop through indices 0 to 9
      contacts[x] = new Contact();        // Create a new Contact and assign it to the array
      x = x + 1;                          // Increment the index
    }
    // At this point, the contacts array contains 10 Contact objects for further use
  }

  // This method creates 10 Contact objects, but each time reuses the same reference, so previous objects are not stored.
  void solution2() {
    int x = 0;
    Contact contactRef;                   // A single reference to a Contact object
    while (x < 10) {                      // Loop 10 times
      contactRef = new Contact();        // Create a new Contact and assign it to the same reference
      x = x + 1;                          // Increment the counter
    }
    // Only the last Contact object is accessible through contactRef
  }

}

// A simple class representing a Contact; it can be expanded with fields and methods as needed.
class Contact {
}
