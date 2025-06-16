package ch5;

import java.util.Scanner;

// This class provides a method to prompt the user for integer input via the console and return the entered value.

public class GameHelper {
  public int getUserInput(String prompt) {
    System.out.print(prompt + ": ");           // Display the prompt message
    Scanner scanner = new Scanner(System.in);  // Create Scanner object to read input
    return scanner.nextInt();                   // Return the next integer entered by the user
  }
}
