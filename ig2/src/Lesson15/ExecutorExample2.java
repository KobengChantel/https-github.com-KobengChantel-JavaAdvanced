package Lesson15;

import java.util.concurrent.*;

// This program uses an ExecutorService to run two Callable tasks concurrently and retrieve their results using Future.

public class ExecutorExample2 {
    public static void main(String[] args) {
        // Create a thread pool with 4 threads
        ExecutorService es = Executors.newFixedThreadPool(4);

        // Submit two ExampleCallable tasks and store their Future results
        Future<String> f1 = es.submit(new ExampleCallable("one", 10000));
        Future<String> f2 = es.submit(new ExampleCallable("two", 10000));

        try {
            // Wait up to 5 seconds for tasks to complete (non-blocking for submitted tasks)
            es.awaitTermination(5, TimeUnit.SECONDS);

            // Shut down the executor service gracefully
            es.shutdown();

            // Retrieve and print the result from the first task
            String result1 = f1.get(); // Blocks until result is available
            System.out.println("Results of one: " + result1);

            // Retrieve and print the result from the second task
            String result2 = f2.get();
            System.out.println("Results of two: " + result2);

        } catch (ExecutionException | InterruptedException ex) {
            // Handle possible exceptions during task execution or thread interruption
            System.out.println("Exception: " + ex);
        }
    }
}
