package ch9;

/**
 * The SuperclassConstructors class demonstrates the use of constructors in
 * an abstract superclass and how a subclass calls the superclass constructor.
 */
public class SuperclassConstructors {

  /**
   * Abstract class Animal serves as a base class for animals.
   * It contains a private field name and a constructor to initialize it.
   */
  public abstract class Animal {
    // Private field to hold the animal's name
    private String name;

    /**
     * Getter method to retrieve the name of the animal.
     *
     * @return the name of the animal
     */
    public String getName() {
      return name;
    }

    /**
     * Constructor for Animal that initializes the name.
     *
     * @param theName the name to assign to the animal
     */
    public Animal(String theName) {
      name = theName;
    }
  }

  /**
   * Hippo class is a subclass of Animal.
   * It uses the superclass constructor to initialize its name.
   */
  public class Hippo extends Animal {

    /**
     * Constructor for Hippo that calls the superclass constructor with the name.
     *
     * @param name the name of the hippo
     */
    public Hippo(String name) {
      super(name);  // Call the constructor of Animal to set the name
    }
  }

  /**
   * Main method to test the Hippo subclass and Animal superclass behavior.
   */
  public static void main(String[] args) {
    // Create a Hippo object named "Buffy"
    // Hippo h = new SuperclassConstructors().new Hippo("Buffy");
    // Print the name of the Hippo
    // System.out.println(h.getName());
  }
}
