package Lesson15;

import java.util.concurrent.Callable;

// This class implements Callable to simulate a task that prints numbers and returns their sum as a result after execution.

public class ExampleCallable implements Callable {

    // Name of the task (used for output)
    private final String name;

    // Number of iterations (upper limit for the loop)
    private final int len;

    // Sum of numbers from 0 to len-1
    private int sum = 0;

    // Constructor to initialize name and loop length
    public ExampleCallable(String name, int len){
        this.name = name;
        this.len = len;
    }

    // The call() method will be executed in a separate thread and returns a result
    // Note: This method should be defined in a class that implements Callable<String>
    public String call() throws Exception {
        // Print the task name and current index, and calculate the sum
        for (int i = 0; i < len; i++) {
            System.out.println(name + ":" + i);
            sum += i;
        }

        // Return the total sum as a string
        return "sum: " + sum;
    }
}
