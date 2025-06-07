package Lesson16.ex16_1_exercise;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 * class uses the Fork/Join framework to recursively populate segments of a large array with random integers in parallel for improved performance.
 */
public class RandomArrayAction extends RecursiveAction {
    private final int threshold;  // Threshold to decide when to split tasks
    private final int[] myArray;  // The array to populate with random numbers
    private int start;            // Start index of the array segment
    private int end;              // End index of the array segment

    public RandomArrayAction(int[] myArray, int start, int end, int threshold) {
        this.myArray = myArray;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end - start < threshold) {
            // If segment is small enough, fill directly with random values
            for (int i = start; i <= end; i++) {
                myArray[i] = ThreadLocalRandom.current().nextInt();
            }
        } else {
            int midway = (end - start) / 2 + start;
            // Split task into two subtasks for parallel execution
            RandomArrayAction r1 = new RandomArrayAction(myArray, start, midway, threshold);
            RandomArrayAction r2 = new RandomArrayAction(myArray, midway + 1, end, threshold);
            invokeAll(r1, r2);
        }
    }
}
