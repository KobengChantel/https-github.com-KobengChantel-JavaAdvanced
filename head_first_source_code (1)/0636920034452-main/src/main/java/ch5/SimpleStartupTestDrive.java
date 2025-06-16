package ch5;

// This code defines a SimpleStartup class simulating a guessing game where a user tries to hit all target locations, and a test drive class that checks if a guess correctly registers a hit.

public class SimpleStartupTestDrive {
  public static void main(String[] args) {
    SimpleStartup dot = new SimpleStartup();

    int[] locations = {2, 3, 4};
    dot.setLocationCells(locations); // Set target locations

    int userGuess = 2;
    String result = dot.checkYourself(userGuess); // Make a guess
    String testResult = "failed";
    if (result.equals("hit")) { // Check if guess is a hit
      testResult = "passed";
    }
    System.out.println(testResult); // Output test result
  }
}

class SimpleStartup {
  private int[] locationCells; // Stores target locations
  private int numOfHits = 0;   // Tracks number of hits

  public void setLocationCells(int[] locs) {
    locationCells = locs; // Assigns target locations
  }

  public String checkYourself(int guess) {
    String result = "miss"; // Default to miss
    for (int cell : locationCells) {
      if (guess == cell) {
        result = "hit";     // If guess matches a target location, it's a hit
        numOfHits++;        // Increment hits count
        break;
      }
    }
    if (numOfHits == locationCells.length) {
      result = "kill";       // If all locations are hit, target is killed
    }
    System.out.println(result);
    return result;
  }
}
