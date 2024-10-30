package DummiesBook.Book5.chapter1_ProgrammingThreads;
//LISTING 1.6
public class LaunchEventNew implements Runnable {

    // Private field to store the message that will be printed when the event runs
    private String message;

    // Constructor for the LaunchEventNew class
    // Takes a message as an argument and assigns it to the instance variable 'message'
    public LaunchEventNew(String message) {
        this.message = message;  // Initialize the message that will be displayed when the event triggers
    }

    // Override the run method from the Runnable interface
    // This method defines the behavior of the thread when it is executed
    @Override
    public void run() {
        // Print the message when the thread runs
        System.out.println(message);
    }

    // Main method to test the LaunchEventNew class
    public static void main(String[] args) {
        // Creating a LaunchEventNew object with a message
        LaunchEventNew event = new LaunchEventNew("Launch event is happening!");

        // Creating a thread to run the event
        Thread thread = new Thread(event);

        // Start the thread
        thread.start();
    }
}
