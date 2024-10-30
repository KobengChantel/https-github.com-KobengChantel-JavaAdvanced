package DummiesBook.Book5.chapter1_ProgrammingThreads;
//Listing 1-3 shows the code for a CountDownApp class that uses these classes to
//launch a spacecraft

public class CountDownApp2 {
    // The CountDownApp class is the main application that manages the countdown and launch events.
    public class CountDownApp {

        // The main method is the entry point of the application.
        public static void main(String[] args) {

            // Create a new instance of the CountDownClock, which is a Thread to run the countdown.
            Thread clock = new CountDownClock7(15); // Line 5

            // Declare three Runnable references to represent different launch events.
            Runnable flood, ignition, liftoff; // Line 7

            // Initialize the 'flood' event, set to trigger 16 seconds before launch with a specific message.
            flood = new LaunchEvent7(16, "Flood the pad!", (TimeMonitor7) clock);

            // Initialize the 'ignition' event, set to trigger 6 seconds before launch with a specific message.
            ignition = new LaunchEvent7(6, "Start engines!", (TimeMonitor7) clock);

            // Initialize the 'liftoff' event, set to trigger at the exact moment of launch with a specific message.
            liftoff = new LaunchEvent7(0, "Liftoff!", (TimeMonitor7) clock);

            // Start the countdown clock in a separate thread.
            clock.start(); // Line 12

            // Start the 'flood' event in a separate thread, which will execute the run method in the LaunchEvent class.
            new Thread(flood).start(); // Line 14

            // Start the 'ignition' event in a separate thread.
            new Thread(ignition).start();

            // Start the 'liftoff' event in a separate thread.
            new Thread(liftoff).start();
        }
    }
}
