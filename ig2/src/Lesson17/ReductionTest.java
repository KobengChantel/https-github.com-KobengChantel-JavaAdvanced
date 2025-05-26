package Lesson17;

import java.util.stream.IntStream;

public class ReductionTest {
    public static void main(String[] args) {

        //takes sequence of input values and combines it into a single result
        //similar to recursion
        //identity/sum is zero
        //elements are no.s within range
        //reduction occurs whether stream is || or sequential

        //1 + 2 + 3 + 4 + 5
        int r1 = IntStream.rangeClosed(1, 5).parallel()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Result: " + r1);

        //1 + 2 + 3 + 4 + 5
        int r2 = IntStream.rangeClosed(1, 5).parallel()
                .reduce(0, (sum, element) -> sum + element);


        System.out.println("Result: " + r2);

        //1 + 2 + 3 + 4 + 5 + 6 + 7 + 8
        int r3 = IntStream.rangeClosed(1, 8).parallel().reduce(0, (sum, element) -> sum + element);

        System.out.println("Result: " + r3);

    }
}
