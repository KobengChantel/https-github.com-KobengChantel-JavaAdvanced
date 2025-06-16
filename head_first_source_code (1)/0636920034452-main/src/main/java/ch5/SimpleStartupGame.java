package ch5;

// This simple guessing game generates a random sequence of three consecutive numbers, prompts the user to guess them, and tracks the number of guesses until all are "hit" and the game ends.

public class SimpleStartupGame {
  public static void main(String[] args) {
    int numOfGuesses = 0;                  // Counts how many guesses the player has made
    GameHelper helper = new GameHelper();  // Helper to get user input

    SimpleStartup theStartup = new SimpleStartup();  // The target object to guess
    int randomNum = (int) (Math.random() * 5);      // Random starting position (0 to 4)

    int[] locations = {randomNum, randomNum + 1, randomNum + 2};  // Consecutive target locations
    theStartup.setLocationCells(locations);                        // Assign target locations
    boolean isAlive = true;                                         // Flag to keep the game running

    while (isAlive) {
      int guess = helper.getUserInput("enter a number");          // Prompt user for a guess
      String result = theStartup.checkYourself(guess);            // Check if guess hits the target
      numOfGuesses++;                                              // Increment guess count
      if (result.equals("kill")) {                                 // If all targets hit, end game
        isAlive = false;
        System.out.println("You took " + numOfGuesses + " guesses");
      }
    }
  }
}
