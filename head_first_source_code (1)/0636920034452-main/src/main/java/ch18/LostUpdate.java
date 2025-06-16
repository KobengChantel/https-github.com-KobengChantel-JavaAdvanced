package ch18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// This program demonstrates how using AtomicInteger prevents lost updates during concurrent modifications, unlike the unsynchronized version.

public class LostUpdate {
  public static void main(String[] args) throws InterruptedException {
    // Create a thread pool with 30 threads
    ExecutorService pool = Executors.newFixedThreadPool(30);

    // Use AtomicBalance to ensure thread-safe incrementing
    AtomicBalance balance = new AtomicBalance();

    // Submit 1000 increment tasks to the thread pool
    for (int i = 0; i < 1000; i++) {
      pool.execute(() -> balance.increment());
    }

    // Shutdown the thread pool - no new tasks will be accepted
    pool.shutdown();

    // Wait until all tasks are finished before printing the final balance
    if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
      System.out.println("balance = " + balance.balance); // Should print 1000
    }
  }
}

// A regular (non-thread-safe) balance class - not used in this example
class Balance {
  int balance = 0;

  // This increment method is not synchronized and can lead to lost updates
  public void increment() {
    balance++;
  }
}

// A thread-safe balance class using AtomicInteger
class AtomicBalance {
  AtomicInteger balance = new AtomicInteger(0);

  // Atomically increments the balance to prevent race conditions
  public void increment() {
    balance.incrementAndGet();
  }
}
