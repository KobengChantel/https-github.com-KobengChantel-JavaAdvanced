package ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This code demonstrates parallel execution by creating a fixed thread pool with 2 threads and running two jobs concurrently, each printing 25 messages showing which thread is executing the job.

public class RunThreads {

  public static void main(String[] args) {
    // Create a fixed thread pool with exactly 2 worker threads
    ExecutorService threadPool = Executors.newFixedThreadPool(2);

    // Submit first job to the thread pool (will run on one of the 2 threads)
    threadPool.execute(() -> runJob("Job 1"));

    // Submit second job to the thread pool (will run on the other thread concurrently)
    threadPool.execute(() -> runJob("Job 2"));

    // Initiate graceful shutdown - no new tasks accepted, existing tasks complete
    threadPool.shutdown();
  }

  public static void runJob(String jobName) {
    // Loop 25 times to simulate work and demonstrate concurrent execution
    for (int i = 0; i < 25; i++) {
      // Get the name of the current thread executing this job
      String threadName = Thread.currentThread().getName();

      // Print job name and thread name - output will be interleaved between jobs
      System.out.println(jobName + " is running on " + threadName);
    }
  }
}