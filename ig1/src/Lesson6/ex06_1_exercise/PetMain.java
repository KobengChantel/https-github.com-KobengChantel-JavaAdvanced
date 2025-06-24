package Lesson6.ex06_1_exercise;

// Main class to demonstrate polymorphism with Animal and Pet interfaces using Spider, Cat, and Fish objects.

public class PetMain {

    public static void main(String[] args) {
        Animal a;

        // Test Spider with Spider reference
        Spider s = new Spider();
        s.eat();    // Spider's eat method
        s.walk();   // Spider's walk method

        // Test Spider with Animal reference (polymorphism)
        a = new Spider();
        a.eat();
        a.walk();

        Pet p;

        // Create Cat and demonstrate its behaviors
        Cat c = new Cat("Tom");
        c.eat();
        c.walk();
        c.play();

        // Use Animal reference to Cat (polymorphism)
        a = new Cat();
        a.eat();
        a.walk();

        // Use Pet reference to Cat and change name
        p = new Cat();
        p.setName("Mr. Whiskers");
        p.play();

        // Create Fish and demonstrate its behaviors
        Fish f = new Fish();
        f.setName("Guppy");
        f.eat();
        f.walk();
        f.play();

        // Use Animal reference to Fish (polymorphism)
        a = new Fish();
        a.eat();
        a.walk();

        // Use method accepting Animal to play if pet, else warn
        playWithAnimal(s);
        playWithAnimal(c);
        playWithAnimal(f);
    }

    // Method to play with an animal only if it implements Pet; otherwise print warning
    public static void playWithAnimal(Animal a) {
        if (a instanceof Pet) {
            Pet p = (Pet) a;
            p.play();
        } else {
            System.out.println("Danger! Wild Animal");
        }
    }
}
