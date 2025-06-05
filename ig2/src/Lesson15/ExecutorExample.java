package Lesson15;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// This program uses an ExecutorService to run multiple ExampleRunnable tasks concurrently using a fixed thread pool.

public class ExecutorExample {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService es = Executors.newFixedThreadPool(3);

        // Submit two tasks to be executed by the thread pool
        es.execute(new ExampleRunnable("One")); // Prints "One:0" to "One:999"
        es.execute(new ExampleRunnable("Two")); // Prints "Two:0" to "Two:999"

        // Initiates an orderly shutdown after tasks complete
        es.shutdown();
    }
}
