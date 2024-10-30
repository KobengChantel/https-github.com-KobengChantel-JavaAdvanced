package DummiesBook.Book5.chapter1_ProgrammingThreads;
//Using an Executor
//LISTING 1.5
// The CountDownClockNew class implements the Runnable interface, allowing it to be executed by a thread.
public class CountDownClockNew implements Runnable {
    public static void main(String[] args) {
        // Create a new CountDownClockNew object with a countdown time of 10 (or any other value).
        CountDownClockNew clock = new CountDownClockNew(10);

        // Start a new thread to run the countdown.
        new Thread(clock).start();
    }
    // An integer field to hold the countdown time.
    int t;

    // Constructor to initialize the countdown time with a given value.
    public CountDownClockNew(int t) {
        // Set the initial value of t (the countdown time).
        this.t = t;
    }

    // The run method contains the logic that will be executed when the thread starts.
    public void run() {
        // Print the current countdown time.
        System.out.println("T minus " + t);
    }
}

