package ch4;

// This code defines a Dog class with a size attribute and a bark method that outputs different sounds based on the dog's size, then tests this behavior with three Dog objects of varying sizes.

class Dog {
  int size;        // Size of the dog
  String name;     // Name of the dog (not used in this example)

  void bark() {    // Method that makes the dog "bark" with sound depending on its size
    if (size > 60) {
      System.out.println("Wooof! Wooof!");
    } else if (size > 14) {
      System.out.println("Ruff!  Ruff!");
    } else {
      System.out.println("Yip! Yip!");
    }
  }
}

class DogTestDrive {

  public static void main(String[] args) {
    Dog one = new Dog();   // Create Dog object with size 70
    one.size = 70;
    Dog two = new Dog();   // Create Dog object with size 8
    two.size = 8;
    Dog three = new Dog(); // Create Dog object with size 35
    three.size = 35;

    one.bark();            // Outputs bark sound for large dog
    two.bark();            // Outputs bark sound for small dog
    three.bark();          // Outputs bark sound for medium dog
  }
}
