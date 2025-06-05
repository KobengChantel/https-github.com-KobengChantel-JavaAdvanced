package Lesson15;

//class defines a Runnable that uses an AtomicCounter to safely
// increment a shared counter a specified number of times, printing the result along with the thread's name
public class AtomicCounterRunnable implements Runnable {
    // Create an instance of AtomicCounter to use for thread-safe counting
    private AtomicCounter count = new AtomicCounter();

    // Number of times to increment the counter
    private int countSize = 0;

    // Name of the thread for identification in output
    private String threadName;

    // Default constructor
    public AtomicCounterRunnable(){
        super(); // Call the parent class constructor (optional here)
    }

    // Constructor that sets the number of increments and thread name
    public AtomicCounterRunnable(int countSize, String threadName){
        this.countSize = countSize;
        this.threadName = threadName;
    }

    // This method will be executed when the thread starts
    @Override
    public void run() {
        for (int i = 0; i < countSize; i++) {
            count.increment(); // Atomically increment the counter
            System.out.println(threadName + " Current Count: " + this.getCounter()); // Print the current count with the thread name
        }
    }

    // Synchronized method to safely retrieve the counter value (even though AtomicInteger is thread-safe, this ensures consistent output)
    public synchronized int getCounter(){
        return count.getValue(); // Return the current counter value
    }
}
