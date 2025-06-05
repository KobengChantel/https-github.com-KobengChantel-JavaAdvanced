package Lesson15;

// This class extends Thread to create a custom thread that prints its name and a count from 0 to 999.

public class ExampleThread extends Thread {
    // Name used to identify the thread in the output
    private final String name;

    // Constructor to initialize the thread's name
    public ExampleThread(String name){
        this.name = name;
    }

    // The code that runs when the thread is started
    @Override
    public void run(){
        // Loop to print the thread name and index from 0 to 999
        for (int i = 0; i < 1000; i++){
            System.out.println(name + ":" + i);
        }
    }
}
