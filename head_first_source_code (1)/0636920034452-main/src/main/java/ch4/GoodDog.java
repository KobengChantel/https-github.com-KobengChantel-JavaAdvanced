package ch4;

// This code defines a GoodDog class with encapsulated size field and methods to get/set size and bark accordingly, then tests it by creating two dogs with different sizes and calling their methods.

class GoodDog {
  private int size;  // Private size variable to enforce encapsulation

  // Getter method to retrieve the dog's size
  public int getSize() {
    return size;
  }

  // Setter method to set the dog's size
  public void setSize(int s) {
    size = s;
  }

  // Bark method prints different sounds based on the dog's size
  void bark() {
    if (size > 60) {
      System.out.println("Wooof! Wooof!");
    } else if (size > 14) {
      System.out.println("Ruff!  Ruff!");
    } else {
      System.out.println("Yip! Yip!");
    }
  }
}

class GoodDogTestDrive {

  public static void main(String[] args) {
    // Create first GoodDog object and set its size
    GoodDog one = new GoodDog();
    one.setSize(70);

    // Create second GoodDog object and set its size
    GoodDog two = new GoodDog();
    two.setSize(8);

    // Print the sizes of both dogs
    System.out.println("Dog one: " + one.getSize());
    System.out.println("Dog two: " + two.getSize());

    // Call the bark method on both dogs to print their bark sounds
    one.bark();
    two.bark();
  }
}
