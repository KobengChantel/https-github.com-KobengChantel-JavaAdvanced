package Lesson15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This program uses a thread pool to run multiple AtomicCounterRunnable tasks concurrently with shared atomic operations.

public class AtomicTest {
    public static void main(String[] args) {
        // Create a thread pool with 4 threads
        ExecutorService es = Executors.newFixedThreadPool(4); // Corrected: use Executors, not Executor

        // Submit three tasks to the thread pool, each with its own thread name and 10 increments
        es.submit(new AtomicCounterRunnable(10, "A")); // Task A
        es.submit(new AtomicCounterRunnable(10, "B")); // Task B
        es.submit(new AtomicCounterRunnable(10, "C")); // Task C

        // Initiates an orderly shutdown of the thread pool after submitting tasks
        es.shutdown();
    }
}
