package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// This code demonstrates different types of Java thread pools including cached, fixed, scheduled, single-threaded, and work-stealing pools with various execution patterns.

public class ThreadPools {

  public static void main(String[] args) throws InterruptedException {
    // Currently executing the work-stealing pool example
    createWorkStealingPool();
  }

  /**
   * Creates a cached thread pool that reuses threads when available and creates new ones as needed.
   * This pool is good for short-lived asynchronous tasks.
   */
  private static void createCachedThreadPool() {
    ExecutorService threadPool = Executors.newCachedThreadPool();
    // Submit 4 jobs to the cached thread pool
    threadPool.execute(() -> run("Job 1"));
    threadPool.execute(() -> run("Job 2"));
    threadPool.execute(() -> run("Job 3"));
    threadPool.execute(() -> run("Job 4"));
    // Shutdown the pool gracefully
    threadPool.shutdown();
  }

  /**
   * Creates a fixed thread pool with only 2 threads but submits 4 jobs.
   * This demonstrates job queuing when there are more tasks than available threads.
   */
  private static void createFixedThreadPoolWithMoreJobsThanThreads() {
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    // Submit 4 jobs to a pool with only 2 threads - jobs will be queued
    threadPool.execute(() -> run("Job 1"));
    threadPool.execute(() -> run("Job 2"));
    threadPool.execute(() -> run("Job 3"));
    threadPool.execute(() -> run("Job 4"));
    // Shutdown the pool gracefully
    threadPool.shutdown();
  }

  /**
   * Creates a scheduled thread pool that can delay task execution.
   * Tasks are scheduled to run at different times in the future.
   */
  private static void createScheduledThreadPoolAndSchedule() {
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
    // Schedule tasks with different delays
    threadPool.schedule(() -> System.out.println("1"), 2, TimeUnit.SECONDS);        // 2 seconds
    threadPool.schedule(() -> System.out.println("2"), 1500, TimeUnit.MILLISECONDS); // 1.5 seconds
    threadPool.schedule(() -> System.out.println("3"), 1, TimeUnit.SECONDS);         // 1 second
    threadPool.schedule(() -> System.out.println("4"), 500, TimeUnit.MILLISECONDS);  // 0.5 seconds
    // Expected output order: 4, 3, 2, 1 (based on delay times)
    threadPool.shutdown();
  }

  /**
   * Creates a scheduled thread pool that runs tasks repeatedly at fixed intervals.
   * Each task has different initial delays and repeat intervals.
   */
  private static void createScheduledThreadPoolAndScheduleAtFixedRate() throws InterruptedException {
    ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
    // Schedule tasks to run repeatedly at fixed rates
    threadPool.scheduleAtFixedRate(() -> System.out.println("1"), 400, 1000, TimeUnit.MILLISECONDS); // Every 1 second after 400ms
    threadPool.scheduleAtFixedRate(() -> System.out.println("2"), 300, 2000, TimeUnit.MILLISECONDS); // Every 2 seconds after 300ms
    threadPool.scheduleAtFixedRate(() -> System.out.println("3"), 200, 3000, TimeUnit.MILLISECONDS); // Every 3 seconds after 200ms
    threadPool.scheduleAtFixedRate(() -> System.out.println("4"), 100, 4000, TimeUnit.MILLISECONDS); // Every 4 seconds after 100ms
    // Let the scheduled tasks run for 20 seconds
    TimeUnit.SECONDS.sleep(20);
    threadPool.shutdown();
  }

  /**
   * Creates a single-threaded executor that processes tasks sequentially.
   * All tasks are executed by the same thread in the order they were submitted.
   */
  private static void createSingleThreadExecutor() {
    ExecutorService threadPool = Executors.newSingleThreadExecutor();
    // All jobs will be executed sequentially by a single thread
    threadPool.execute(() -> run("Job 1"));
    threadPool.execute(() -> run("Job 2"));
    threadPool.execute(() -> run("Job 3"));
    threadPool.execute(() -> run("Job 4"));
    threadPool.shutdown();
  }

  /**
   * Creates a work-stealing pool that uses a fork-join approach.
   * Idle threads can "steal" work from busy threads' queues for better load balancing.
   */
  private static void createWorkStealingPool() throws InterruptedException {
    ExecutorService threadPool = Executors.newWorkStealingPool();
    // Submit 12 jobs to the work-stealing pool
    threadPool.execute(() -> run("Job 1"));
    threadPool.execute(() -> run("Job 2"));
    threadPool.execute(() -> run("Job 3"));
    threadPool.execute(() -> run("Job 4"));
    threadPool.execute(() -> run("Job 5"));
    threadPool.execute(() -> run("Job 6"));
    threadPool.execute(() -> run("Job 7"));
    threadPool.execute(() -> run("Job 8"));
    threadPool.execute(() -> run("Job 9"));
    threadPool.execute(() -> run("Job 10"));
    threadPool.execute(() -> run("Job 11"));
    threadPool.execute(() -> run("Job 12"));
    // Shutdown the pool
    threadPool.shutdown();
    // Wait for all tasks to complete or timeout after 20 seconds
    threadPool.awaitTermination(20, TimeUnit.SECONDS);
  }

  /**
   * Simulates a job by printing the job name and current thread name 25 times.
   * This helps visualize which threads are executing which jobs.
   */
  public static void run(String jobName) {
    for (int i = 0; i < 25; i++) {
      String threadName = Thread.currentThread().getName();
      System.out.println(jobName + " is running on thread " + threadName);
    }
  }
}