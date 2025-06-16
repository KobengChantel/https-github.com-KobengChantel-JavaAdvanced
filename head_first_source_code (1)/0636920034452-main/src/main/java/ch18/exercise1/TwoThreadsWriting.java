package ch18.exercise1;

import java.util.*;
import java.util.concurrent.*;

// This program demonstrates unsafe concurrent access where two threads simultaneously write to a shared ArrayList, potentially causing race conditions and data corruption.

/**
 * Main class that demonstrates unsafe concurrent writing to shared data.
 * Two threads simultaneously add letters to the same ArrayList without synchronization,
 * which can lead to race conditions and unpredictable results.
 */
public class TwoThreadsWriting {
  /**
   * Main method that creates two threads writing concurrently to shared data.
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    // Create a fixed thread pool with 2 threads
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Create a shared data object that both threads will access
    Data data = new Data();

    // Submit first lambda task to add lowercase letters starting with 'a'
    threadPool.execute(() -> addLetterToData('a', data));

    // Submit second lambda task to add uppercase letters starting with 'A'
    threadPool.execute(() -> addLetterToData('A', data));

    // Shutdown the thread pool - no new tasks will be accepted
    threadPool.shutdown();
  }

  /**
   * Helper method that adds 26 consecutive letters to the data structure.
   * This method is called concurrently by multiple threads, creating race conditions.
   * @param letter Starting letter (will be incremented for each addition)
   * @param data The shared data structure to add letters to
   */
  private static void addLetterToData(char letter, Data data) {
    // Add 26 consecutive letters (e.g., a-z or A-Z)
    for (int i = 0; i < 26; i++) {
      // Add current letter and increment to next letter
      // This is NOT thread-safe - multiple threads can interfere with each other
      data.addLetter(letter++);

      try {
        // Sleep for 50ms to increase likelihood of thread interference
        Thread.sleep(50);
      } catch (InterruptedException ignored) {
        // Ignore interruption exceptions
      }
    }

    // Print the current thread name and all letters in the collection
    // WARNING: This can cause ConcurrentModificationException if the other thread
    // is modifying the ArrayList while this thread is iterating over it
    System.out.println(Thread.currentThread().getName() + data.getLetters());

    // Print the current thread name and the size of the collection
    System.out.println(Thread.currentThread().getName()
            + " size = " + data.getLetters().size());
  }
}

/**
 * Data class that holds a collection of letters.
 * WARNING: This class is NOT thread-safe! ArrayList is not synchronized,
 * so concurrent access can lead to data corruption, lost updates, or exceptions.
 */
final class Data {
  // ArrayList is NOT thread-safe - concurrent modifications can cause problems
  private final List<String> letters = new ArrayList<>();

  /**
   * Returns the list of letters.
   * WARNING: Not thread-safe - can throw ConcurrentModificationException
   * if called while another thread is modifying the list.
   * @return The list containing all added letters
   */
  public List<String> getLetters() {
    return letters;
  }

  /**
   * Adds a letter to the collection.
   * WARNING: Not thread-safe - concurrent calls can lead to data corruption
   * or lost updates since ArrayList is not synchronized.
   * @param letter The character to convert to string and add to the collection
   */
  public void addLetter(char letter) {
    // Convert character to string and add to ArrayList
    // This operation is NOT atomic and NOT thread-safe
    letters.add(String.valueOf(letter));
  }
}