package ch9;

// The GC class demonstrates object references and how they can be passed and reassigned,
// which affects garbage collection eligibility in Java.

public class GC {

  // Static method that creates a new GC object, passes it to doStuff2, then returns it
  public static GC doStuff() {
    GC newGC = new GC();       // Create new GC instance
    doStuff2(newGC);           // Pass newGC to another method
    return newGC;              // Return the newGC reference
  }

  public static void main(String[] args) {
    GC gc1;                   // Declare reference variable gc1 (null initially)
    GC gc2 = new GC();        // Create new GC object, reference held by gc2
    GC gc3 = new GC();        // Create another GC object, reference held by gc3
    GC gc4 = gc3;             // gc4 references the same object as gc3
    gc1 = doStuff();          // gc1 references the GC object returned by doStuff()

    // Additional method calls can be added here
  }

  // Method that assigns the passed reference to a local variable (no effect outside the method)
  public static void doStuff2(GC copyGC) {
    GC localGC = copyGC;      // localGC points to the same object as copyGC
  }
}

/*
These commented lines illustrate how object references can be reassigned or nullified:

copyGC = null;    // Sets copyGC reference to null (inside method, doesn't affect caller)
gc2 = null;       // Original GC object referenced by gc2 may become eligible for GC if no other refs
newGC = gc3;      // newGC now references the same object as gc3
gc1 = null;       // GC object referenced by gc1 may become eligible for GC
newGC = null;     // newGC reference is cleared, object may be eligible for GC if no other refs
gc4 = null;       // gc4 reference cleared; gc3 still references object, so not eligible for GC
gc3 = gc2;        // gc3 now references the object gc2 points to; previous object may be GC'ed
gc1 = gc4;        // gc1 now references what gc4 points to (if gc4 is null, gc1 becomes null)
gc3 = null;       // gc3 reference cleared; the object it pointed to may become eligible for GC
*/

