package Lesson16.ex16_1_exercise;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
/**
*program generates a large array of random integers and uses the Fork/Join framework with the FindMaxTask to efficiently find the maximum value in parallel.
 **/
public class Main {

    // Note: JVM needs sufficient heap space for large arrays, set with -Xmx1024m in VM options
    public static void main(String[] args) {
        // Create a large array (~512 MB) to store random integers
        int[] data = new int[1024 * 1024 * 128];

        // Initialize the array with random integer values
        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }

        // Sequential max search example (commented out)
        /*
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println("Max value found:" + max);
        */

        // Create a ForkJoinPool to manage concurrent tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Create a FindMaxTask to find max in data using a threshold for splitting
        FindMaxTask task = new FindMaxTask(data, 0, data.length - 1, data.length / 16);

        // Execute the task and wait for the result
        Integer result = pool.invoke(task);

        // Print the maximum value found in the array
        System.out.println("Max value found:" + result);
    }
}
