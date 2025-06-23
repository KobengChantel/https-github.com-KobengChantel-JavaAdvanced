package Lesson6.ex06_1_exercise;

// Abstract class representing an animal with a number of legs and the ability to walk and eat (eat is abstract).

public abstract class Animal {

    protected int legs;  // Number of legs the animal has

    // Constructor to initialize the number of legs
    public Animal(int legs) {
        this.legs = legs;
    }

    // Concrete method to print how the animal walks
    public void walk() {
        System.out.println("This animal walks on " + legs + " legs.");
    }

    // Abstract method to define eating behavior, must be implemented by subclasses
    public abstract void eat();
}
