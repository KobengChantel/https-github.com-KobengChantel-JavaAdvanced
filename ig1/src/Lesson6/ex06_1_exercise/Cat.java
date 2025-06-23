package Lesson6.ex06_1_exercise;

// Cat class extends Animal and implements Pet, representing a cat with a name and typical behaviors.

public class Cat extends Animal implements Pet {

    public String name;  // Name of the cat

    // Constructor setting the cat's name and initializing legs to 4 via superclass constructor
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    // No-argument constructor that defaults the name to "Fluffy"
    public Cat() {
        this("Fluffy");
    }

    // Getter for the cat's name (from Pet interface)
    @Override
    public String getName() {
        return name;
    }

    // Setter for the cat's name (from Pet interface)
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Implementation of play method (from Pet interface)
    @Override
    public void play() {
        System.out.println(name + " likes to play with string.");
    }

    // Implementation of abstract eat method (from Animal)
    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }
}
