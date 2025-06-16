package ch6;

import java.util.ArrayList;

// This code implements a simple command-line game where the user tries to sink three "Startup" ships by guessing their locations on a grid.

public class StartupBust {

  private GameHelper helper = new GameHelper();                  // Helper object for input and grid placement
  private ArrayList<Startup> startups = new ArrayList<>();       // List of Startup objects
  private int numOfGuesses = 0;                                  // Counter for number of guesses

  private void setUpGame() {
    // Create and name three Startup objects
    Startup one = new Startup();
    one.setName("poniez");
    Startup two = new Startup();
    two.setName("hacqi");
    Startup three = new Startup();
    three.setName("cabista");

    // Add the Startup objects to the list
    startups.add(one);
    startups.add(two);
    startups.add(three);

    // Print game instructions
    System.out.println("Your goal is to sink three Startups.");
    System.out.println("poniez, hacqi, cabista");
    System.out.println("Try to sink them all in the fewest number of guesses");

    // Place each Startup on the grid
    for (Startup startup : startups) {
      ArrayList<String> newLocation = helper.placeStartup(3); // Get a location of size 3
      startup.setLocationCells(newLocation);                  // Set the location
    }
  } // end setUpGame

  private void startPlaying() {
    // Keep asking for guesses until all startups are sunk
    while (!startups.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess"); // Ask for input
      checkUserGuess(userGuess);                               // Check the guess
    }
    finishGame();                                               // Game over
  } // end startPlaying

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;                             // Increment guess counter
    String result = "miss";                     // Default result

    // Check each Startup for a hit or kill
    for (Startup startupToTest : startups) {
      result = startupToTest.checkYourself(userGuess);

      if (result.equals("hit")) {
        break; // No need to keep checking if it's a hit
      }
      if (result.equals("kill")) {
        startups.remove(startupToTest); // Remove sunk startup
        break;
      }
    }

    System.out.println(result); // Display result to user
  } // end checkUserGuess

  private void finishGame() {
    // Game end message
    System.out.println("All Startups are dead! Your stock is now worthless");

    // Performance evaluation
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options");
    }
  } // end finishGame

  public static void main(String[] args) {
    // Start the game
    StartupBust game = new StartupBust();
    game.setUpGame();     // Set up the board and startups
    game.startPlaying();  // Start accepting guesses
  }
}
