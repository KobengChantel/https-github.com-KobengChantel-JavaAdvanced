package ch6;

import java.util.*;

// This code defines a helper class for a grid-based game, managing user input and placing startups (ships) on a virtual grid with logic to check position validity and alignment.

public class GameHelper {
  private static final String ALPHABET = "abcdefg"; // Columns represented by letters
  private static final int GRID_LENGTH = 7;         // Width of the grid
  private static final int GRID_SIZE = 49;          // Total number of grid cells
  private static final int MAX_ATTEMPTS = 200;      // Max attempts to place a startup

  static final int HORIZONTAL_INCREMENT = 1;          // Increment for horizontal placement
  static final int VERTICAL_INCREMENT = GRID_LENGTH;  // Increment for vertical placement

  private final int[] grid = new int[GRID_SIZE];      // Represents grid cell occupation
  private final Random random = new Random();         // Random number generator

  private int startupCount = 0; // Tracks how many startups have been placed

  // Prompts user for input and returns it in lowercase
  public String getUserInput(String prompt) {
    System.out.print(prompt + ": ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().toLowerCase();
  }

  // Attempts to place a startup of a given size on the grid
  public ArrayList<String> placeStartup(int startupSize) {
    int[] startupCoords = new int[startupSize];
    int attempts = 0;
    boolean success = false;

    startupCount++;
    int increment = getIncrement(); // Alternate placement direction

    while (!success & attempts++ < MAX_ATTEMPTS) {
      int location = random.nextInt(GRID_SIZE);

      for (int i = 0; i < startupCoords.length; i++) {
        startupCoords[i] = location;
        location += increment;
      }
      System.out.println("Trying: " + Arrays.toString(startupCoords));

      if (startupFits(startupCoords, increment)) {
        success = coordsAvailable(startupCoords);
      }
    }

    savePositionToGrid(startupCoords);
    ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startupCoords);
    System.out.println("Placed at: "+ alphaCells);
    return alphaCells;
  }

  // Checks if the startup fits in the grid without crossing rows or boundaries
  boolean startupFits(int[] startupCoords, int increment) {
    int finalLocation = startupCoords[startupCoords.length - 1];
    if (increment == HORIZONTAL_INCREMENT) {
      return calcRowFromIndex(startupCoords[0]) == calcRowFromIndex(finalLocation);
    } else {
      return finalLocation < GRID_SIZE;
    }
  }

  // Checks if the proposed grid cells are unoccupied
  boolean coordsAvailable(int[] startupCoords) {
    for (int coord : startupCoords) {
      if (grid[coord] != 0) {
        System.out.println("position: " + coord + " already taken.");
        return false;
      }
    }
    return true;
  }

  // Marks the chosen grid cells as used
  void savePositionToGrid(int[] startupCoords) {
    for (int index : startupCoords) {
      grid[index] = 1;
    }
  }

  // Converts grid indices to user-friendly coordinates like "a0", "b1"
  private ArrayList<String> convertCoordsToAlphaFormat(int[] startupCoords) {
    ArrayList<String> alphaCells = new ArrayList<String>();
    for (int index : startupCoords) {
      String alphaCoords = getAlphaCoordsFromIndex(index);
      alphaCells.add(alphaCoords);
    }
    return alphaCells;
  }

  // Returns coordinate in "letter+number" format (e.g., "a3")
  String getAlphaCoordsFromIndex(int index) {
    int row = calcRowFromIndex(index);
    int column = index % GRID_LENGTH;
    String letter = ALPHABET.substring(column, column + 1);
    return letter + row;
  }

  // Calculates row number based on grid index
  private int calcRowFromIndex(int index) {
    return index / GRID_LENGTH;
  }

  // Alternates startup placement between horizontal and vertical
  private int getIncrement() {
    if (startupCount % 2 == 0) {
      return HORIZONTAL_INCREMENT;
    } else {
      return VERTICAL_INCREMENT;
    }
  }
}
