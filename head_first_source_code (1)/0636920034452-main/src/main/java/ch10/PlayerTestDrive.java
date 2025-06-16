package ch10;

/**
 * The Player class represents a player with a name.
 * It keeps track of how many Player instances have been created
 * using a static variable playerCount.
 */
class Player {
  // Static variable to count the number of Player objects created
  static int playerCount = 0;

  // Instance variable to store the name of the player
  private String name;

  /**
   * Constructor that sets the player's name
   * and increments the static playerCount.
   * @param n The name of the player
   */
  public Player(String n) {
    name = n;
    playerCount++;  // Increment count each time a new Player is created
  }
}

/**
 * Test class to demonstrate the use of the Player class
 * and how the static variable playerCount tracks the total players.
 */
public class PlayerTestDrive {
  public static void main(String[] args) {
    // Initially, no Player objects have been created, so playerCount is 0
    System.out.println(Player.playerCount);

    // Create a new Player object named "Tiger Woods"
    Player one = new Player("Tiger Woods");

    // playerCount is now 1 since we created one Player instance
    System.out.println(Player.playerCount);
  }
}
