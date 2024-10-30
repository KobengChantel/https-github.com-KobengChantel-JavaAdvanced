package DummiesBook.Book5.chapter1_ProgrammingThreads;
//LISTING 1.2 VERSION 1
// The LaunchEvent class implements the Runnable interface, allowing it to be executed by a thread.

public class LaunchEvent3 implements Runnable {

    // Private fields to store the start time of the event and the message to be displayed.
    private int start;
    private String message;

    // Constructor for the LaunchEvent class.
    // Takes the start time and the message as arguments.
    public LaunchEvent3(int start, String message, CountDownClock1 clock) {
        // Initialize the start time (in seconds before launch).
        this.start = start;
        // Initialize the message that will be displayed when the event triggers.
        this.message = message;
    }

    // Override the run method from the Runnable interface, which contains the event logic.
    @Override
    public void run() {
        try {
            // Pause execution for the calculated time: (20 - start) seconds.
            // For example, if start = 5, the sleep time will be 15 seconds.
            Thread.sleep(20000 - (start * 1000)); // Wait for the correct time before the event starts.
        } catch (InterruptedException e) {
            // Handle interruption during the sleep period (empty catch block).
        }

        // After the wait is over, print the message associated with this event.
        System.out.println(message);
    }

    // Main method to test the LaunchEvent.
    public static void main(String[] args) {
        // Example of how to use the LaunchEvent class in a main method.
        // Assuming the CountDownClock1 class is defined elsewhere.
        CountDownClock1 clock = new CountDownClock1();  // Replace this with your actual clock implementation

        // Creating LaunchEvent objects with different start times and messages.
        LaunchEvent3 event1 = new LaunchEvent3(5, "Event 1: 5 seconds to launch!", clock);
//        LaunchEvent7 event2 = new LaunchEvent3(10, "Event 2: 10 seconds to launch!", clock);

        // Starting these events in separate threads.
        Thread thread1 = new Thread(event1);
//        Thread thread2 = new Thread(event2);

        // Start the threads.
        thread1.start();
//        thread2.start();
    }
}
