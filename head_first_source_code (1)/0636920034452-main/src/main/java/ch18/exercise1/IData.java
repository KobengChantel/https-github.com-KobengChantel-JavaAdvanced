package ch18.exercise1;

import java.util.List;

// This interface defines a contract for a data structure that can store character letters and retrieve them as a list of strings.

/**
 * Interface defining operations for a data structure that manages character letters.
 * Implementations of this interface should handle thread safety considerations
 * when used in concurrent environments.
 */
public interface IData {
  /**
   * Adds a single character letter to the data structure.
   * @param c The character to be added to the collection
   */
  void addLetter(char c);

  /**
   * Retrieves all stored letters as a list of strings.
   * @return A List containing all the letters that have been added
   */
  List<String> getLetters();
}