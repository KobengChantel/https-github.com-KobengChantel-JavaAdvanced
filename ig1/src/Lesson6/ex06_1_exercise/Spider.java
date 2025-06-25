package Lesson6.ex06_1_exercise;

// Spider class extends Animal representing an 8-legged spider with specific eating behavior.

public class Spider extends Animal {

    // Constructor initializes the spider with 8 legs by calling superclass constructor
    public Spider() {
        super(8);
    }

    // Implementation of the abstract eat method for Spider
    @Override
    public void eat() {
        System.out.println("The spider eats a fly.");
    }
}
