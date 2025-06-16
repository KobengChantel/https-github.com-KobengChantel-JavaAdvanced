package ch4;

// This code defines a PoorDog class with private fields size and name accessible only via getter methods, then tests by creating a PoorDog object and printing its default size and name values.

class PoorDog {
  private int size;        // private integer size
  private String name;     // private String name

  public int getSize() {   // getter for size
    return size;
  }

  public String getName() {  // getter for name
    return name;
  }
}

public class PoorDogTestDrive {
  public static void main(String[] args) {
    PoorDog one = new PoorDog();   // create new PoorDog object
    System.out.println("Dog size is " + one.getSize());  // print default size (0)
    System.out.println("Dog name is " + one.getName());  // print default name (null)
  }
}
