package Lesson15;

import java.util.concurrent.atomic.AtomicInteger; // Import AtomicInteger for thread-safe operations on integers

// class defines a thread-safe counter using AtomicInteger to perform atomic increment, decrement,
// and value retrieval operations without needing synchronization
public class AtomicCounter {
    // Declare a static AtomicInteger to hold the counter value
    private static AtomicInteger i = new AtomicInteger();

    // Method to atomically increment the counter by 1
    public void increment(){
        i.incrementAndGet(); // Increments the value and returns the updated value
    }

    // Method to atomically decrement the counter by 1
    public void decrement(){
        i.decrementAndGet(); // Decrements the value and returns the updated value
    }

    // Method to get the current value of the counter
    public int getValue(){
        return i.get(); // Returns the current value of the AtomicInteger
    }
}
