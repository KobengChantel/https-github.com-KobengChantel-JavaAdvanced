package ch9;

// The Car class models a car with a size attribute, initialized via the constructor.

public class Car {
  // Private instance variable to store the size of the car
  private String size;

  // Constructor that sets the size of the car when a new Car object is created
  public Car(String size) {
    this.size = size;  // Assign the passed size parameter to the instance variable
  }
}
