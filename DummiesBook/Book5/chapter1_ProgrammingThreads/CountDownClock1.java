package DummiesBook.Book5.chapter1_ProgrammingThreads;

// The CountDownClock class extends the Thread class to create a countdown timer in a separate thread.
public class CountDownClock1 extends Thread {

    // Override the run method from the Thread class, which contains the logic for the countdown.
    public void run() {
        // Loop to count down from 20 to 0.
        for (int t = 20; t >= 0; t--) {
            // Print the current countdown value.
            System.out.println("T minus " + t);

            try {
                // Pause the execution for 1 second (1000 milliseconds) between each countdown step.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle any interruption during the sleep period (empty catch block).
            }
        }
    }

    // Main method that starts the countdown clock.
    public static void main(String[] args) {
        // Create a new instance of CountDownClock.
        CountDownClock7 clock = new CountDownClock7(14);

        // Start the countdown clock in a separate thread.
        clock.start();
    }
}
