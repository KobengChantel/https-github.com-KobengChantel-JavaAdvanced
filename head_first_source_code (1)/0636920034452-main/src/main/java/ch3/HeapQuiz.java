package ch3;

// This class demonstrates object creation, reference assignments, and how objects become eligible for garbage collection in Java.

class HeapQuiz {
  int id = 0; // Instance variable to identify each object

  public static void main(String[] args) {
    int x = 0;
    HeapQuiz[] hq = new HeapQuiz[5]; // Creates an array to hold 5 HeapQuiz references

    // Create 3 HeapQuiz objects and assign them to the first 3 elements of the array
    while (x < 3) {
      hq[x] = new HeapQuiz();   // Create a new HeapQuiz object
      hq[x].id = x;             // Assign an id corresponding to its index
      x = x + 1;
    }

    hq[3] = hq[1];   // hq[3] now refers to the same object as hq[1]
    hq[4] = hq[1];   // hq[4] also refers to the same object as hq[1]
    hq[3] = null;    // hq[3] no longer refers to any object
    hq[4] = hq[0];   // hq[4] now refers to the object originally at hq[0]
    hq[0] = hq[3];   // hq[0] is set to null (since hq[3] is null)
    hq[3] = hq[2];   // hq[3] now refers to the object originally at hq[2]
    hq[2] = hq[0];   // hq[2] is now null (since hq[0] is null)

    // At this point, objects not referenced anywhere are eligible for garbage collection
  }
}
