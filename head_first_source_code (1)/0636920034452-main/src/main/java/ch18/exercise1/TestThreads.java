package ch18.exercise1;

// This program demonstrates thread synchronization using a singleton accumulator where two threads concurrently update a shared counter with different increment values.

/**
 * Main test class that creates and starts two threads that operate on a shared accumulator.
 * Demonstrates thread synchronization and singleton pattern usage.
 */
public class TestThreads {
  /**
   * Main method that creates and starts two concurrent threads.
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    // Create instances of the two runnable thread classes
    ThreadOne t1 = new ThreadOne();
    ThreadTwo t2 = new ThreadTwo();

    // Wrap the runnables in Thread objects
    Thread one = new Thread(t1);
    Thread two = new Thread(t2);

    // Start both threads concurrently
    one.start();
    two.start();
  }
}

/**
 * Singleton accumulator class that maintains a shared counter across threads.
 * Uses synchronization to ensure thread-safe updates to the counter.
 */
class Accum {
  // Singleton instance - only one Accum object will ever exist
  private static final Accum a = new Accum();

  // The shared counter that will be modified by multiple threads
  private int counter = 0;

  /**
   * Private constructor to prevent external instantiation (singleton pattern).
   */
  private Accum() {
  }

  /**
   * Static method to get the singleton instance of Accum.
   * @return The single instance of Accum
   */
  public static Accum getAccum() {
    return a;
  }

  /**
   * Thread-safe method to update the counter by adding a value.
   * Synchronized to prevent race conditions when multiple threads access simultaneously.
   * @param add The value to add to the current counter
   */
  public synchronized void updateCounter(int add) {
    counter += add;
  }

  /**
   * Gets the current value of the counter.
   * Note: This method is NOT synchronized, which could lead to reading
   * inconsistent values during updates.
   * @return The current counter value
   */
  public int getCount() {
    return counter;
  }
}

/**
 * First thread implementation that adds 1000 to the shared counter 98 times.
 * Total contribution: 98,000
 */
class ThreadOne implements Runnable {
  // Get reference to the singleton accumulator
  Accum a = Accum.getAccum();

  /**
   * Thread execution method that performs 98 iterations of adding 1000.
   */
  public void run() {
    // Loop 98 times, adding 1000 each time
    for (int x = 0; x < 98; x++) {
      // Add 1000 to the shared counter
      a.updateCounter(1000);

      try {
        // Sleep for 50ms to allow thread interleaving
        Thread.sleep(50);
      } catch (InterruptedException ignored) {
        // Ignore interruption exceptions
      }
    }
    // Print the counter value when this thread finishes
    System.out.println("one " + a.getCount());
  }
}

/**
 * Second thread implementation that adds 1 to the shared counter 99 times.
 * Total contribution: 99
 */
class ThreadTwo implements Runnable {
  // Get reference to the singleton accumulator
  Accum a = Accum.getAccum();

  /**
   * Thread execution method that performs 99 iterations of adding 1.
   */
  public void run() {
    // Loop 99 times, adding 1 each time
    for (int x = 0; x < 99; x++) {
      // Add 1 to the shared counter
      a.updateCounter(1);

      try {
        // Sleep for 50ms to allow thread interleaving
        Thread.sleep(50);
      } catch (InterruptedException ignored) {
        // Ignore interruption exceptions
      }
    }
    // Print the counter value when this thread finishes
    System.out.println("two " + a.getCount());
  }
}