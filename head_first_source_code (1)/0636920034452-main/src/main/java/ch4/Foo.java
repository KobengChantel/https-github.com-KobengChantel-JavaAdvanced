package ch4;

// This class contains a method with commented-out code that would cause a compilation error due to the use of an uninitialized local variable.

class Foo {
  public void go() {
    // intentionally doesn't compile
    // int x;          // Declared but not initialized
    // int z = x + 3;  // Error: local variable x might not have been initialized
  }
}
