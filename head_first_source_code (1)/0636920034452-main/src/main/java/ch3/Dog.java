package ch3;

// This code creates multiple Dog objects, stores them in an array, assigns names, and makes each dog bark using a loop.
class Dog {
  String name;  // Dog's name

  public static void main(String[] args) {
    // make a Dog object and access it
    Dog dog1 = new Dog();         // Create a new Dog object
    dog1.bark();                  // Call bark before name is assigned (prints "null says Ruff!")
    dog1.name = "Bart";          // Set dog1's name

    // now make a Dog array
    Dog[] myDogs = new Dog[3];   // Create an array to hold 3 Dog objects

    // and put some dogs in it
    myDogs[0] = new Dog();       // Create and assign first Dog
    myDogs[1] = new Dog();       // Create and assign second Dog
    myDogs[2] = dog1;            // Assign existing dog1 as the third Dog

    // now access the Dogs using the array references
    myDogs[0].name = "Fred";     // Set name for first Dog in array
    myDogs[1].name = "Marge";    // Set name for second Dog in array

    // Hmmmm... what is myDogs[2] name?
    System.out.print("last dog’s name is ");
    System.out.println(myDogs[2].name);  // Print name of third Dog in array

    // now loop through the array and tell all dogs to bark
    int x = 0;
    while (x < myDogs.length) {
      myDogs[x].bark();         // Call bark method for each Dog
      x = x + 1;
    }
  }

  public void bark() {
    System.out.println(name + " says Ruff!");  // Dog barks with its name
  }

  public void eat() {
    // Placeholder method
  }

  public void chaseCat() {
    // Placeholder method
  }
}
