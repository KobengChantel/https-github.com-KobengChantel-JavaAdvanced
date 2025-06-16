package ch17;

import java.util.concurrent.*;

// This code demonstrates three different synchronization mechanisms (awaitTermination, sleep with TimeUnit, and CountDownLatch) to ensure predictable execution order between main and worker threads, with performance timing included.

public class PredictableRunOrder {
  public static void main(String[] args) throws InterruptedException {
    // Record start time for performance measurement
    long startTime = System.currentTimeMillis();

    // Run the PredictableSleep example 100 times to measure total execution time
    for (int i = 0; i < 100; i++) {
      PredictableSleep.main(args);
    }

    // Calculate and print total execution time
    long endTime = System.currentTimeMillis();
    System.out.println(endTime-startTime);
  }
}

class PredictableSleep {
  public static void main (String[] args) throws InterruptedException {
    // Create single-thread executor
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Submit task that sleeps for 2 seconds then prints
    executor.execute(() -> sleepThenPrint());

    // This prints immediately on main thread
    System.out.println("back in main");

    // Initiate graceful shutdown
    executor.shutdown();

    // Wait up to 2 seconds for all tasks to complete - ensures predictable order
    executor.awaitTermination(2, TimeUnit.SECONDS);
  }

  private static void sleepThenPrint() {
    try {
      // Sleep for 2000 milliseconds (2 seconds)
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // This will always print after "back in main" due to awaitTermination
    System.out.println("top o' the stack");
  }
}

class SleepWithTimeUnit {
  public static void main (String[] args) throws InterruptedException {
    // Create single-thread executor
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Submit task to executor
    executor.execute(() -> sleepThenPrint());

    // Print on main thread
    System.out.println("back in main");

    // Shutdown and wait for completion
    executor.shutdown();
    executor.awaitTermination(2, TimeUnit.SECONDS);
  }

  private static void sleepThenPrint() {
    try {
      // Alternative way to sleep using TimeUnit enum (more readable)
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("top o' the stack");
  }
}

class PredictableLatch {
  public static void main (String[] args) throws InterruptedException {
    // Create single-thread executor
    ExecutorService executor = Executors.newSingleThreadExecutor();

    // Create CountDownLatch with count of 1 (one thread must count down)
    CountDownLatch latch = new CountDownLatch(1);

    // Submit task that waits for latch before printing
    executor.execute(() -> waitForLatchThenPrint(latch));

    // Print on main thread
    System.out.println("back in main");

    // Signal the latch - allows waiting thread to proceed
    latch.countDown();

    // Shutdown and wait for completion
    executor.shutdown();
    executor.awaitTermination(2, TimeUnit.SECONDS);
  }

  private static void waitForLatchThenPrint(CountDownLatch latch) {
    try {
      // Wait until latch count reaches zero (when countDown() is called)
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    // This prints after main thread calls countDown()
    System.out.println("top o' the stack");
  }
}