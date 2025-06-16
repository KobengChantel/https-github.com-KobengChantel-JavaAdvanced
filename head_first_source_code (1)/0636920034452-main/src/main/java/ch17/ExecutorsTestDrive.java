package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This code demonstrates basic thread pool usage by creating a single-thread executor, submitting a lambda task to run asynchronously, and then shutting down the executor.

public class ExecutorsTestDrive {
  public static void main(String[] args) {
    // Create an executor service with a single worker thread
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Submit a lambda task to be executed asynchronously on the worker thread
    executor.execute(() -> System.out.println("top o' the stack"));

    // This line executes immediately on the main thread (may print before or after the lambda)
    System.out.println("back in main");

    // Initiate graceful shutdown - no new tasks accepted, existing tasks complete
    executor.shutdown();
  }
}