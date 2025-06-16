package ch2;

// This code defines a GameLauncher class that creates a GuessGame object and starts the game by calling its startGame method.
public class GameLauncher {
  public static void main(String[] args) {
    GuessGame guessGame = new GuessGame();  // Create a new GuessGame object
    guessGame.startGame();                   // Start the game by invoking startGame method
  }
}
