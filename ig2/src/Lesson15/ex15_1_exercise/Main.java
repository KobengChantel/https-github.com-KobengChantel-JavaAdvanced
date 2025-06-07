package Lesson15.ex15_1_exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This program creates a cached thread pool to run three
// CountRunnable tasks concurrently, each printing a count with a label.

public class Main {

  public static void main(String[] args) {
    // Setup an ExecutorService using a cached thread pool (dynamically grows/shrinks thread count as needed)
    ExecutorService es = Executors.newCachedThreadPool();

    // Create three CountRunnable tasks with count size 20 and unique thread names
    CountRunnable run1 = new CountRunnable(20, "A");
    CountRunnable run2 = new CountRunnable(20, "B");
    CountRunnable run3 = new CountRunnable(20, "C");

    // Submit the tasks to the ExecutorService for execution
    es.submit(run1);
    es.submit(run2);
    es.submit(run3);

    // Shut down the ExecutorService after task submission
    es.shutdown();
  }
}
