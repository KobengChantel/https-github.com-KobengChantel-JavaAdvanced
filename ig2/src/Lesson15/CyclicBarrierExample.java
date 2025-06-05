package Lesson15;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

// This program sets up a CyclicBarrier to synchronize multiple threads, allowing them to wait for each other before continuing execution.

public class CyclicBarrierExample implements Runnable {
    // A CyclicBarrier that waits for 2 threads to reach the barrier before proceeding
    final CyclicBarrier barrier = new CyclicBarrier(2);

    // AtomicInteger to keep track of how many threads have reached the barrier
    AtomicInteger threadCount = new AtomicInteger(0);

    public static void main(String[] args) {
        // Create a thread pool with 4 threads
        ExecutorService es = Executors.newFixedThreadPool(4);

        // Create an instance of the runnable class
        CyclicBarrierExample ex = new CyclicBarrierExample();

        // Submit the same task multiple times to simulate multiple threads reaching the barrier
        es.submit(ex);
        es.submit(ex);
        es.submit(ex);
        es.submit(ex);

        // Shut down the executor service after task submission
        es.shutdown();
    }

    @Override
    public void run() {
        // Simulate each thread doing some work before reaching the barrier
        try {
            int count = threadCount.incrementAndGet(); // Increment the thread counter
            System.out.println("Thread " + count + " waiting at the barrier");

            barrier.await(); // Wait at the barrier until 2 threads arrive

            // Code below this line runs only after both threads reach the barrier
            System.out.println("Thread " + count + " passed the barrier");

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace(); // Handle any exceptions related to the barrier
        }
    }
}
