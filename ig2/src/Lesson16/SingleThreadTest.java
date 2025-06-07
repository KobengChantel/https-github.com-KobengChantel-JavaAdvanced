package Lesson16;

import java.util.concurrent.ThreadLocalRandom;

// This class generates a large array of random integers and finds the maximum value using a single thread.
public class SingleThreadTest {
    public static void main(String[] args) {
        // Create a large array of integers (~512 MB)
        int[] data = new int[1024 * 1024 * 128];

        // Populate the array with random integers
        for (int i = 0; i < data.length; i++) {
            data[i] = ThreadLocalRandom.current().nextInt();
        }

        // Initialize max to the smallest possible integer value
        int max = Integer.MIN_VALUE;

        // Iterate through the array to find the maximum value
        for (int value : data) {
            if (value > max) {
                max = value;
                // Optional: print max as it updates
                // System.out.println(max + " ");
            }
        }

        // Print the maximum value found in the array
        System.out.println("Max value found: " + max);
    }
}
