package Lesson15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This program uses a fixed thread pool to run three threads that increment a shared synchronized counter.

public class SynchronizedTest {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService es = Executors.newFixedThreadPool(3);

        // Submit 3 tasks that increment the synchronized counter
        es.submit(new SynchronizedCounterRunnable(10, "A")); // Thread A
        es.submit(new SynchronizedCounterRunnable(10, "B")); // Thread B
        es.submit(new SynchronizedCounterRunnable(10, "C")); // Thread C

        // Shut down the executor service after submitting tasks
        es.shutdown();
    }
}
