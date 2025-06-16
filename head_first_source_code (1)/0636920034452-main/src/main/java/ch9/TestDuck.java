package ch9;

/**
 * The TestDuck class demonstrates creating Duck objects using
 * multiple constructors with different parameter types and orders.
 */
public class TestDuck {

  public static void main(String[] args) {
    // Initialize variables to be used as constructor arguments
    int weight = 8;
    float density = 2.3F;
    String name = "Donald";
    long[] feathers = {1, 2, 3, 4, 5, 6};
    boolean canFly = true;
    int airspeed = 22;

    // Create an array of Duck objects with space for 7 Ducks
    Duck[] d = new Duck[7];

    // Instantiate Duck objects using different constructors:

    // Use no-argument constructor
    d[0] = new Duck();  // prints: "type 1 duck"

    // Use constructor with (float, int) parameters (weight, floatability)
    d[1] = new Duck(density, weight);  // prints: "type 4 duck"

    // Use constructor with (String, long[]) parameters (name, feathers)
    d[2] = new Duck(name, feathers);  // prints: "type 3 duck"

    // Use constructor with (boolean) parameter (canFly)
    d[3] = new Duck(canFly);  // prints: "type 2 duck"

    // Use constructor with (float, int) parameters (density, airspeed)
    d[4] = new Duck(3.3F, airspeed);  // prints: "type 5 duck"

    // Use constructor with (boolean) parameter (false)
    d[5] = new Duck(false);  // prints: "type 2 duck"

    // Use constructor with (int, float) parameters (airspeed, density)
    d[6] = new Duck(airspeed, density);  // prints: "type 5 duck"
  }

  /**
   * The Duck class represents a duck with various properties.
   * It has multiple overloaded constructors to demonstrate
   * constructor overloading and different parameter orders.
   */
  static class Duck {
    private int kilos = 6;                   // weight in kilos
    private float floatability = 2.1F;      // floatability factor
    private String name = "Generic";         // duck's name
    private long[] feathers = {1, 2, 3, 4, 5, 6, 7};  // feather pattern array
    private boolean canFly = true;           // flight capability
    private int maxSpeed = 25;               // maximum speed

    /**
     * No-argument constructor - sets default Duck properties.
     */
    public Duck() {
      System.out.println("type 1 duck");
    }

    /**
     * Constructor with a boolean indicating if the duck can fly.
     * @param fly true if the duck can fly, false otherwise
     */
    public Duck(boolean fly) {
      canFly = fly;
      System.out.println("type 2 duck");
    }

    /**
     * Constructor with a name and feather array.
     * @param n the duck's name
     * @param f the duck's feathers array
     */
    public Duck(String n, long[] f) {
      name = n;
      feathers = f;
      System.out.println("type 3 duck");
    }

    /**
     * Constructor with weight (int) and floatability (float).
     * @param w weight of the duck
     * @param f floatability factor
     */
    public Duck(int w, float f) {
      kilos = w;
      floatability = f;
      System.out.println("type 4 duck");
    }

    /**
     * Constructor with floatability (float) and maxSpeed (int).
     * Note: parameter order differs from the (int, float) constructor.
     * @param density floatability factor
     * @param max maximum speed
     */
    public Duck(float density, int max) {
      floatability = density;
      maxSpeed = max;
      System.out.println("type 5 duck");
    }
  }
}
