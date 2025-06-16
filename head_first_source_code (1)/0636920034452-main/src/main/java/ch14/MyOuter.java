package ch14;

// This class demonstrates an inner class accessing and modifying the outer class's private field.

class MyOuter {
  private int x;                    // Private variable of the outer class
  private MyInner inner = new MyInner();  // Instance of the inner class

  public void doStuff() {
    inner.go();                   // Calls the inner class method to modify x
  }

  // Inner class defined inside MyOuter
  class MyInner {
    void go() {
      x = 42;                    // Inner class directly accesses and sets the outer class's private field
    }
  }

}
