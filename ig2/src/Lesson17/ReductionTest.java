package Lesson17;

import java.util.stream.IntStream;

// This code demonstrates how to use the reduce operation to sum a range of integers using parallel streams.

public class ReductionTest {
    public static void main(String[] args) {

        // Demonstrates the reduce operation on an IntStream
        // Reduction combines elements of a stream into a single result
        // The identity value (initial value) for sum is 0
        // The operation works with both parallel and sequential streams

        // Sum of numbers 1 through 5 using parallel stream and reduce
        int r1 = IntStream.rangeClosed(1, 5)  // creates stream of integers 1,2,3,4,5 inclusive
                .parallel()                    // use parallel processing
                .reduce(0, (a, b) -> a + b);  // sum the elements, starting from 0

        System.out.println("Result: " + r1);  // Expected output: 15

        // Same as above but with different parameter names for clarity
        int r2 = IntStream.rangeClosed(1, 5)
                .parallel()
                .reduce(0, (sum, element) -> sum + element);

        System.out.println("Result: " + r2);  // Expected output: 15

        // Sum of numbers 1 through 8 using parallel stream and reduce
        int r3 = IntStream.rangeClosed(1, 8)
                .parallel()
                .reduce(0, (sum, element) -> sum + element);

        System.out.println("Result: " + r3);  // Expected output: 36

    }
}
