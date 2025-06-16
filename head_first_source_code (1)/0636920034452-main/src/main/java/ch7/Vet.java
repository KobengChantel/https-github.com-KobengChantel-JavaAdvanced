package ch7;

// This code demonstrates polymorphism by having a Vet give shots to different Animal subclasses, triggering their specific behaviors via the makeNoise method.

class Vet {
  public void giveShot(Animal a) {
    // Perform an action on the Animal passed as parameter 'a'
    a.makeNoise();  // Call the specific Animal's implementation of makeNoise
  }
}

class PetOwner {
  public void start() {
    Vet vet = new Vet();     // Create a Vet instance
    Dog dog = new Dog();     // Create a Dog instance (subclass of Animal)
    Hippo hippo = new Hippo(); // Create a Hippo instance (subclass of Animal)

    vet.giveShot(dog);       // Vet gives a shot to the dog, dog makes its noise
    vet.giveShot(hippo);     // Vet gives a shot to the hippo, hippo makes its noise
  }
}
