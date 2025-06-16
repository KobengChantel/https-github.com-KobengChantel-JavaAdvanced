package ch18.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// This program demonstrates thread synchronization by running multiple concurrent tasks that add letters to a shared synchronized data structure and measures the execution time.

/**
 * Main class that demonstrates synchronized access to shared data using thread pools.
 * Creates multiple concurrent tasks that add uppercase and lowercase letters to shared collections.
 */
public class SynchronizedCollection {
  // Comment indicates previous execution took 13,959 milliseconds
  //13 959 ms

  /**
   * Main method that creates and executes concurrent letter-adding tasks.
   * @param args Command line arguments (not used)
   * @throws InterruptedException If the thread pool termination is interrupted
   */
  public static void main(String[] args) throws InterruptedException {
    // Create a fixed thread pool with 2 threads to handle concurrent execution
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Record start time for performance measurement
    long start = System.currentTimeMillis();

    // Create 10 iterations of concurrent letter-adding tasks
    for (int i = 0; i < 10; i++) {
      // Create a new synchronized data instance for each iteration
      IData data = new DataSynchronized();

      // Submit a task to add lowercase letters 'a' through 'z'
      threadPool.execute(new AddLowerCaseJob(data));

      // Submit a task to add uppercase letters 'A' through 'Z'
      threadPool.execute(new AddUpperCaseJob(data));
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
 * Implementation of IData that provides synchronized access to prevent race conditions.
 * Uses method-level synchronization to ensure thread-safe operations.
 */
class DataSynchronized implements IData {
  // ArrayList to store letters - not thread-safe on its own
  private final List<String> letters = new ArrayList<>();

  /**
   * Returns the list of letters. Note: This method is NOT synchronized,
   * which could lead to ConcurrentModificationException if called while
   * another thread is modifying the list.
   * @return The list containing all added letters
   */
  public List<String> getLetters() {
    return letters;
  }

  /**
   * Adds a letter to the collection in a thread-safe manner.
   * The synchronized keyword ensures only one thread can execute this method at a time.
   * @param letter The character to convert to string and add to the collection
   */
  public synchronized void addLetter(char letter) {
    // Convert character to string and add to the list
    letters.add(String.valueOf(letter));
  }
}