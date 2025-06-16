package ch7;

// This code demonstrates class inheritance and method overriding across classes A, B, and C, highlighting polymorphism in Java.
class A {
  int ivar = 7;  // Instance variable initialized to 7, inherited by subclasses

  void m1() {
    System.out.print("A's m1, ");  // Method m1 in class A, can be overridden
  }

  void m2() {
    System.out.print("A's m2, ");  // Method m2 in class A, inherited as is by subclasses
  }

  void m3() {
    System.out.print("A's m3, ");  // Method m3 in class A, can be overridden
  }
}

class B extends A {
  @Override
  void m1() {
    System.out.print("B's m1, ");  // Overrides method m1 from class A with new behavior
  }
}

class C extends B {
  @Override
  void m3() {
    // Overrides m3 from class A; accesses inherited ivar and adds 6 before printing
    System.out.print("C's m3, " + (ivar + 6));
  }
}


public class Mixed2 {
  public static void main(String[] args) {
    A a = new A();   // Create instance of A
    B b = new B();   // Create instance of B (inherits from A)
    C c = new C();   // Create instance of C (inherits from B -> A)
    A a2 = new C();  // Create instance of C but referenced by A type (demonstrates polymorphism)


    // Example method calls to illustrate polymorphism:
    // b.m1();  // Calls B's overridden m1 method
    // c.m2();  // Inherits m2 from A
    // a.m3();  // Calls A's m3 method

    // c.m1();  // Inherits overridden m1 from B
    // c.m2();  // Inherits m2 from A
    // c.m3();  // Calls C's overridden m3 method with ivar + 6

    // a.m1();  // Calls A's m1
    // b.m2();  // Inherits m2 from A
    // c.m3();  // Calls C's overridden m3 method

    // a2.m1(); // Calls B's overridden m1 due to a2 referencing C instance
    // a2.m2(); // Inherits m2 from A
    // a2.m3(); // Calls C's overridden m3 method
  }
}
