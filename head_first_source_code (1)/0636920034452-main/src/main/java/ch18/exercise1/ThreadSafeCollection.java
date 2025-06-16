package ch18.exercise1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program demonstrates thread safety using CopyOnWriteArrayList where multiple concurrent tasks add letters to a shared thread-safe collection and measures execution time.

/**
 * Main class that demonstrates thread-safe collection usage with concurrent tasks.
 * Uses CopyOnWriteArrayList to provide thread safety without explicit synchronization.
 */
public class ThreadSafeCollection {
  // Comment indicates previous execution took 13,920 milliseconds
  // 13920 ms

  /**
   * Main method that creates and executes concurrent letter-adding tasks using thread-safe collections.
   * @param args Command line arguments (not used)
   * @throws InterruptedException If the thread pool termination is interrupted
   */
  public static void main(String[] args) throws InterruptedException {
    // Create a fixed thread pool with 2 threads for concurrent execution
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Record start time for performance measurement
    long start = System.currentTimeMillis();

    // Create 10 iterations of concurrent letter-adding tasks
    for (int i = 0; i < 10; i++) {
      // Create a new thread-safe data instance for each iteration
      IData data = new DataSafe();

      // Submit a task to add uppercase letters 'A' through 'Z'
      threadPool.execute(new AddUpperCaseJob(data));

      // Submit a task to add lowercase letters 'a' through 'z'
      threadPool.execute(new AddLowerCaseJob(data));
    }

    // Shutdown the thread pool - no new tasks will be accepted
    threadPool.shutdown();

    // Wait up to 5 minutes for all tasks to complete
    threadPool.awaitTermination(5, TimeUnit.MINUTES);

    // Record end time and calculate total execution time
    long end = System.currentTimeMillis();
    System.out.println("Total time: " + (end - start));
  }
}

/**
 * Thread-safe implementation of IData using CopyOnWriteArrayList.
 * This collection is inherently thread-safe and doesn't require explicit synchronization.
 */
class DataSafe implements IData {
  // CopyOnWriteArrayList provides thread safety by creating a new copy of the array
  // for each write operation, making it safe for concurrent reads and writes
  private final List<String> letters = new CopyOnWriteArrayList<>();

  /**
   * Returns the list of letters. This method is thread-safe because
   * CopyOnWriteArrayList handles concurrent access internally.
   * @return The thread-safe list containing all added letters
   */
  public List<String> getLetters() {
    return letters;
  }

  /**
   * Adds a letter to the collection in a thread-safe manner.
   * No synchronization needed because CopyOnWriteArrayList handles thread safety internally.
   * @param letter The character to convert to string and add to the collection
   */
  public void addLetter(char letter) {
    // Convert character to string and add to the thread-safe list
    // CopyOnWriteArrayList will create a new internal array copy for this write operation
    letters.add(String.valueOf(letter));
  }
}