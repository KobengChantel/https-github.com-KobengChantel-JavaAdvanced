package Lesson15;

// This class implements Runnable to print a given name alongside numbers from 0 to 999 in a separate thread.

public class ExampleRunnable implements Runnable {
    // Name to identify the running thread in the output
    private final String name;

    // Constructor to initialize the name
    public ExampleRunnable(String name){
        this.name = name;
    }

    // The method executed when the thread starts
    @Override
    public void run(){
        // Print the name and number 1000 times (from 0 to 999)
        for (int i = 0; i < 1000; i++){
            System.out.println(name + ":" + i);
        }
    }
}
