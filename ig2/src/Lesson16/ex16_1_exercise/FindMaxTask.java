package Lesson16.ex16_1_exercise;

import java.util.concurrent.RecursiveTask;

/**
 * FindMaxTask uses the Fork/Join framework to efficiently find the maximum value
 * in a segment of an integer array by recursively splitting the task into smaller subtasks.
 */
public class FindMaxTask extends RecursiveTask<Integer> {

    private final int threshold;   // Minimum size of array segment to process sequentially
    private final int[] myArray;   // Array to search
    private final int start;       // Start index of segment (inclusive)
    private final int end;         // End index of segment (inclusive)

    /**
     * Constructor to initialize the array segment and threshold.
     *
     * @param myArray   The array in which to find the max
     * @param start     Starting index of the segment to process
     * @param end       Ending index of the segment to process
     * @param threshold Threshold below which computation is done sequentially
     */
    public FindMaxTask(int[] myArray, int start, int end, int threshold) {
        this.threshold = threshold;
        this.myArray = myArray;
        this.start = start;
        this.end = end;
    }

    /**
     * Recursively compute the maximum value in the array segment.
     * If the segment size is less than the threshold, compute directly.
     * Otherwise, split the task into two subtasks and combine results.
     *
     * @return The maximum integer value found in the segment
     */
    @Override
    protected Integer compute() {
        if (end - start < threshold) {
            // Sequential computation of max for small enough segment
            int max = myArray[start];
            for (int i = start + 1; i <= end; i++) {
                if (myArray[i] > max) {
                    max = myArray[i];
                }
            }
            return max;
        } else {
            // Split the task into two halves
            int midway = start + (end - start) / 2;

            // Fork the left half to run asynchronously
            FindMaxTask leftTask = new FindMaxTask(myArray, start, midway, threshold);
            leftTask.fork();

            // Compute right half synchronously
            FindMaxTask rightTask = new FindMaxTask(myArray, midway + 1, end, threshold);
            int rightResult = rightTask.compute();

            // Wait for the left half to complete and get its result
            int leftResult = leftTask.join();

            // Return the maximum of the two halves
            return Math.max(leftResult, rightResult);
        }
    }
}
