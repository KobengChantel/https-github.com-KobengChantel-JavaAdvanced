package ch2;

// This class tests the Dog class by creating a Dog object, setting its size, and making it bark.
class DogTestDrive {
  public static void main(String[] args) {
    Dog d = new Dog();  // Create a new Dog object named d
    d.size = 40;        // Set the size attribute of the Dog object to 40
    d.bark();           // Call the bark method on the Dog object to make it bark
  }
}
