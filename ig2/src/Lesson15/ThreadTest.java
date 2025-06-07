package Lesson15;

// This program demonstrates creating and starting two threads: one using Runnable and the other by extending Thread.

public class ThreadTest {

    public static void main(String[] args) {
        // Create a thread using a Runnable implementation
        Thread thread1 = new Thread(new ExampleRunnable("one"));

        // Create a thread using a class that extends Thread
        ExampleThread thread2 = new ExampleThread("two");

        // Start both threads to run their tasks concurrently
        thread1.start();
        thread2.start();
    }
}

//static classes, variables and methods
    //stored in memory, are global and can't be deleted
    //don't have to be instatiated
    //can't lock statis fields so don't use in threads

