package ch2;

// This code defines a GuessGame class where three Player objects repeatedly guess a randomly generated target number until one or more players guess correctly, then announces the winner(s) and ends the game.
public class GuessGame {
  Player p1;
  Player p2;
  Player p3;

  public void startGame() {
    p1 = new Player();   // Create Player 1
    p2 = new Player();   // Create Player 2
    p3 = new Player();   // Create Player 3

    int guessp1 = 0;    // Player 1's guess
    int guessp2 = 0;    // Player 2's guess
    int guessp3 = 0;    // Player 3's guess

    boolean p1isRight = false;  // Flag if Player 1 guessed correctly
    boolean p2isRight = false;  // Flag if Player 2 guessed correctly
    boolean p3isRight = false;  // Flag if Player 3 guessed correctly

    int targetNumber = (int) (Math.random() * 10);  // Random number 0-9 to guess
    System.out.println("I'm thinking of a number between 0 and 9...");

    while (true) {
      System.out.println("Number to guess is " + targetNumber);

      p1.guess();    // Player 1 makes a guess
      p2.guess();    // Player 2 makes a guess
      p3.guess();    // Player 3 makes a guess

      guessp1 = p1.number;  // Get Player 1's guess
      System.out.println("Player one guessed " + guessp1);

      guessp2 = p2.number;  // Get Player 2's guess
      System.out.println("Player two guessed " + guessp2);

      guessp3 = p3.number;  // Get Player 3's guess
      System.out.println("Player three guessed " + guessp3);

      if (guessp1 == targetNumber) {
        p1isRight = true;
      }
      if (guessp2 == targetNumber) {
        p2isRight = true;
      }
      if (guessp3 == targetNumber) {
        p3isRight = true;
      }

      if (p1isRight || p2isRight || p3isRight) {
        System.out.println("We have a winner!");
        System.out.println("Player one got it right? " + p1isRight);
        System.out.println("Player two got it right? " + p2isRight);
        System.out.println("Player three got it right? " + p3isRight);
        System.out.println("Game is over.");
        break; // Exit the loop because the game is finished
      } else {
        System.out.println("Players will have to try again."); // No winner yet, continue
      }
    }
  }
}
