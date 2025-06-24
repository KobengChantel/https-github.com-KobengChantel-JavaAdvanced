package Lesson6.ex06_1_exercise;

// Fish class extends Animal and implements Pet, representing a fish with no legs and pet behaviors.

public class Fish extends Animal implements Pet {

    private String name;  // Name of the fish

    // Constructor initializes Animal with 0 legs since fish don't have legs
    public Fish() {
        super(0);
    }

    // Getter for the fish's name (from Pet interface)
    @Override
    public String getName() {
        return name;
    }

    // Setter for the fish's name (from Pet interface)
    @Override
    public void setName(String name) {
        this.name = name;
    }

    // Implementation of play method (from Pet interface)
    @Override
    public void play() {
        System.out.println("Just keep swimming.");
    }

    // Implementation of abstract eat method (from Animal)
    @Override
    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    // Override walk method to explain fish don't walk but swim
    @Override
    public void walk() {
        super.walk();  // Calls the Animal walk method, which prints leg count
        System.out.println("Fish, of course, can't walk; they swim.");
    }
}
