package Lesson15;

// This class defines a Runnable that safely increments a synchronized counter and prints the result with the thread's name.

public class SynchronizedCounterRunnable implements Runnable {

    // Shared counter instance protected by synchronized methods
    private SynchronizedCounter count = new SynchronizedCounter();

    // Number of times to increment the counter
    private int countSize = 0;

    // Name of the thread using this Runnable
    private String threadName;

    // Default constructor
    public SynchronizedCounterRunnable(){
        super();
    }

    // Constructor with parameters for count size and thread name
    public SynchronizedCounterRunnable(int countSize, String threadName){
        this.countSize = countSize;
        this.threadName = threadName;
    }

    @Override
    public void run(){
        // Loop to increment the counter and print the result
        for (int i = 0; i < countSize; i++){
            synchronized(this) { // Synchronizes block on this instance to prevent output overlap
                count.increment(); // Safely increments the counter
                System.out.println(threadName + " current count: " + count.getValue()); // Print current count
            }
        }
    }
}
