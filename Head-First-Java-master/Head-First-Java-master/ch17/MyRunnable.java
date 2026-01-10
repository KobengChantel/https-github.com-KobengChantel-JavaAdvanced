package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This code demonstrates three different ways to execute the same Runnable task (direct method call, Thread, and ExecutorService) and shows how each approach affects the call stack and thread execution.

public class MyRunnable implements Runnable {

  public void run() {
    // Entry point for Runnable interface - delegates to go() method
    go();
  }

  public void go() {
    // Intermediate method that delegates to doMore()
    doMore();
  }

  public void doMore() {
    // Final method that prints current thread name and dumps the call stack
    System.out.println(Thread.currentThread().getName() + ": top o' the stack");
    Thread.dumpStack(); // Shows the complete call stack trace
  }
}

class RunTester {
  public static void main(String[] args) {
    // Test 1: Direct method execution on main thread
    MyRunnable runnable = new MyRunnable();
    runnable.run(); // Called directly - runs on main thread

    // Print main thread info and dump its stack
    System.out.println(Thread.currentThread().getName() +
            ": back in main");
    Thread.dumpStack(); // Shows main thread's call stack
  }
}

class ThreadTester {
  public static void main(String[] args) {
    // Test 2: Execute using explicit Thread creation
    Runnable threadJob = new MyRunnable();
    Thread myThread = new Thread(threadJob); // Create new thread with the runnable

    myThread.start(); // Start the thread (runs asynchronously)

    // This executes on main thread (may run before or after the other thread)
    System.out.println(Thread.currentThread().getName() +
            ": back in main");
    Thread.dumpStack(); // Shows main thread's call stack
  }
}

class ExecutorTester {
  public static void main(String[] args) {
    // Test 3: Execute using ExecutorService thread pool
    Runnable job = new MyRunnable();
    ExecutorService executor = Executors.newSingleThreadExecutor(); // Create single-thread pool
    executor.execute(job); // Submit job to executor (runs asynchronously)

    // This executes immediately on main thread
    System.out.println(Thread.currentThread().getName() +
            ": back in main");
    Thread.dumpStack(); // Shows main thread's call stack

    // Clean shutdown of executor
    executor.shutdown();
  }
}

class StackUtils {
  // Utility method to get current call stack as a formatted string
  static String getCurrentStack() {
    StringBuffer stack = new StringBuffer();
    // Use StackWalker API (Java 9+) to walk through stack frames
    StackWalker.getInstance()
            .forEach(stackFrame -> stack.append(stackFrame.toString()).append("\n"));
    return stack.toString();
  }
}