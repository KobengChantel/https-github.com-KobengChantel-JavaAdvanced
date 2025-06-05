package Lesson15;

import java.util.concurrent.atomic.AtomicInteger;

// This program demonstrates how to use AtomicInteger to safely perform atomic increment operations and display the results.

public class AtomicExample {
    public static void main(String[] args) {

        // Create an AtomicInteger instance with an initial value of 0
        AtomicInteger ai = new AtomicInteger();

        // Atomically increments by 1 and returns the updated value (0 → 1)
        System.out.println("New value: " + ai.incrementAndGet());

        // Returns the current value (1), then increments (1 → 2)
        System.out.println("New value: " + ai.getAndIncrement());

        // Returns the current value (2), then increments (2 → 3)
        System.out.println("New value: " + ai.getAndIncrement());
    }
}
