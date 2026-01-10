package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This code demonstrates the unpredictable execution order between main thread and background threads by running executor examples 100 times to show thread scheduling variations.

/**
 * Main class that runs the ExecutorTestDrive example 100 times to demonstrate
 * the unpredictable nature of thread execution order.
 */
public class UnpredictableRunOrder {
  public static void main(String[] args) {
    // Run the executor test 100 times to show unpredictable thread execution order
    for (int i = 0; i < 100; i++) {
      ExecutorTestDrive.main(args);
    }
  }
}

/**
 * Demonstrates thread unpredictability using raw Thread class.
 * Shows that the order of output between main thread and background thread is not guaranteed.
 */
class ThreadTestDrive {
  public static void main (String[] args) {
    // Create a new thread that will print a message
    Thread myThread = new Thread(() ->
            System.out.println("top o' the stack"));
    // Start the thread (runs concurrently with main thread)
    myThread.start();
    // This line may execute before or after the thread's println
    System.out.println("back in main");
  }
}

/**
 * Demonstrates thread unpredictability using ExecutorService.
 * Shows the same unpredictable execution order as ThreadTestDrive but using modern executor approach.
 */
class ExecutorTestDrive {
  public static void main (String[] args) {
    // Create a single-threaded executor
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // Submit a task to be executed by the executor thread
    executor.execute(() -> System.out.println("top o' the stack"));
    // This line may execute before or after the executor's task
    System.out.println("back in main");
    // Shutdown the executor to clean up resources
    executor.shutdown();
  }
}