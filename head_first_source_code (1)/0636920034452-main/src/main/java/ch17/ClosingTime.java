package ch17;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

// This code demonstrates various ways to shutdown ExecutorService thread pools including graceful shutdown, forced shutdown, and handling of unfinished tasks.

public class ClosingTime {
  public static void main(String[] args) throws InterruptedException {
    // Create a fixed thread pool with 2 threads
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Submit two jobs to the thread pool
    threadPool.execute(new LongJob("Long Job"));
    threadPool.execute(new ShortJob("Short Job"));

    // Initiate graceful shutdown - no new tasks accepted but existing tasks continue
    threadPool.shutdown();

    try {
      // Wait up to 4 seconds for all tasks to complete
      boolean finished = threadPool.awaitTermination(4, TimeUnit.SECONDS);
      System.out.println("Finished? " + finished);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Force shutdown immediately, interrupting running tasks
    threadPool.shutdownNow();
  }

  static void fullShutdown() throws InterruptedException {
    // Create thread pool with 2 threads
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Submit multiple jobs (more than thread pool capacity)
    threadPool.execute(new LongJob("Long Job 1"));
    threadPool.execute(new ShortJob("Short Job"));
    threadPool.execute(new LongJob("Long Job 2"));
    threadPool.execute(new LongJob("Long Job 3"));
    threadPool.execute(new LongJob("Long Job 4"));
    threadPool.execute(new ShortJob("Shouldn't start job"));

    // Initiate graceful shutdown
    threadPool.shutdown();

    // Try to submit a new job after shutdown - this will fail
    ShortJob tooLateJob = new ShortJob("Too late job");
    try {
      threadPool.execute(tooLateJob);
    } catch (RejectedExecutionException e) {
      System.out.println("Too late to start another job!! " + tooLateJob);
    }

    // Wait for termination with timeout
    threadPool.awaitTermination(4, TimeUnit.SECONDS);

    // Force shutdown and get list of unfinished tasks
    List<Runnable> unfinished = threadPool.shutdownNow();

    // Print information about unfinished tasks
    System.out.println("unfinished.size() = " + unfinished.size());
    for (Runnable runnable : unfinished) {
      System.out.println(runnable);
    }
  }

  static void shutdownGracefully() {
    // Create fixed thread pool
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Submit jobs
    threadPool.execute(new LongJob("Long Job 1"));
    threadPool.execute(new ShortJob("Short Job"));
    threadPool.execute(new LongJob("Long Job 2"));
    threadPool.execute(new ShortJob("Queued job"));

    // Graceful shutdown
    threadPool.shutdown();

    // Attempt to submit job after shutdown
    ShortJob tooLateJob = new ShortJob("Too late job");
    try {
      threadPool.execute(tooLateJob);
    } catch (RejectedExecutionException e) {
      System.out.println("Too late to start another job!! " + tooLateJob);
    }

    // Check shutdown status
    System.out.println("threadPool.isShutdown() = " + threadPool.isShutdown());
    System.out.println("threadPool.isTerminated() = " + threadPool.isTerminated());

    try {
      // Wait a long time for all tasks to complete naturally
      boolean poolFinished = threadPool.awaitTermination(100, TimeUnit.SECONDS);
      System.out.println("Finished? " + poolFinished);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Check final status
    System.out.println("threadPool.isShutdown() = " + threadPool.isShutdown());
    System.out.println("threadPool.isTerminated() = " + threadPool.isTerminated());
  }

  static void shutdownGracefullyWorkstealing() {
    // Create work-stealing thread pool (uses ForkJoinPool internally)
    ExecutorService threadPool = Executors.newWorkStealingPool(2);

    // Submit jobs
    threadPool.execute(new LongJob("Long Job 1"));
    threadPool.execute(new ShortJob("Short Job"));
    threadPool.execute(new LongJob("Long Job 2"));
    threadPool.execute(new ShortJob("Queued job"));

    // Graceful shutdown
    threadPool.shutdown();

    // Try to submit job after shutdown
    ShortJob tooLateJob = new ShortJob("Too late job");
    try {
      threadPool.execute(tooLateJob);
    } catch (RejectedExecutionException e) {
      System.out.println("Too late to start another job!! " + tooLateJob);
    }

    // Check status
    System.out.println("threadPool.isShutdown() = " + threadPool.isShutdown());
    System.out.println("threadPool.isTerminated() = " + threadPool.isTerminated());

    try {
      // Wait with shorter timeout
      System.out.println("Finished? " + threadPool.awaitTermination(4, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Check final status
    System.out.println("threadPool.isShutdown() = " + threadPool.isShutdown());
    System.out.println("threadPool.isTerminated() = " + threadPool.isTerminated());
  }

  static void forceShutdown() {
    // Create fixed thread pool
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Submit jobs
    threadPool.execute(new LongJob("Long Job 1"));
    threadPool.execute(new ShortJob("Short Job"));
    threadPool.execute(new LongJob("Long Job 2"));
    threadPool.execute(new ShortJob("Shouldn't start job"));

    // Immediate forced shutdown - interrupts running tasks and returns unfinished ones
    List<Runnable> unfinished = threadPool.shutdownNow();

    // Print unfinished task information
    System.out.println("unfinished.size() = " + unfinished.size());
    for (Runnable runnable : unfinished) {
      System.out.println(runnable);
    }
  }

  static void forceShutdownWorkStealing() {
    // Create work-stealing thread pool
    ExecutorService threadPool = Executors.newWorkStealingPool(2);

    // Submit jobs
    threadPool.execute(new LongJob("Long Job 1"));
    threadPool.execute(new ShortJob("Short Job"));
    threadPool.execute(new LongJob("Long Job 2"));
    threadPool.execute(new ShortJob("Shouldn't start job"));

    // Force shutdown immediately
    List<Runnable> unfinished = threadPool.shutdownNow();

    try {
      // Brief wait to see if shutdown completes
      System.out.println("Finished? " + threadPool.awaitTermination(1, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print unfinished task information
    System.out.println("unfinished.size() = " + unfinished.size());
    for (Runnable runnable : unfinished) {
      System.out.println(runnable);
    }
  }
}

// Abstract base class for named jobs
abstract class NamedJob implements Runnable {
  protected String jobName;

  NamedJob(String jobName) {
    this.jobName = jobName;
  }

  @Override
  public String toString() {
    return "NamedJob{" +
            "jobName='" + jobName + '\'' +
            '}';
  }
}

// Job that completes quickly
class ShortJob extends NamedJob {
  ShortJob(String jobName) {
    super(jobName);
  }

  public void run() {
    // Simply print the job name
    System.out.println(jobName);
  }
}

// Job that takes time to complete (3 seconds)
class LongJob extends NamedJob {
  LongJob(String jobName) {
    super(jobName);
  }

  public void run() {
    try {
      // Sleep for 3 seconds to simulate long-running work
      TimeUnit.SECONDS.sleep(3);
      System.out.println(jobName);
    } catch (InterruptedException e) {
      // Handle interruption (from shutdownNow())
      System.out.println("Job interrupted: " + jobName);
      e.printStackTrace();
    }
  }
}