package Lesson15;

// This class demonstrates a thread-safe counter using synchronized methods to prevent race conditions.

public class SynchronizedCounter {

    // Shared counter variable
    private static int i = 0;

    // Increments the counter by 1 in a thread-safe way
    public synchronized void increment(){
        i++;
    }

    // Decrements the counter by 1 in a thread-safe way
    public synchronized void decrement(){
        i--;
    }

    // Returns the current value of the counter in a thread-safe way
    public synchronized int getValue(){
        return i;
    }
}
