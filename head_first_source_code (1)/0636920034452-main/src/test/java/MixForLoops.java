import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MixForLoops {

    @Test
    void shouldSkipTheFirstEntry() {
        // Create a list of integers from 1 to 5
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
        // Loop starting from index 1, skipping the first element at index 0
        for (int i = 1; i < nums.size(); i++) {
            // Append each number followed by a space to the output string
            output += nums.get(i) + " ";
        }
        System.out.println(output);

        // Assert that the output string matches the expected string "2 3 4 5 "
        assertEquals("2 3 4 5 ", output);
    }

    @Test
    void shouldThrowOutOfBoundsWhenLessThanOrEqual() {
        // Test that accessing index nums.size() causes ArrayIndexOutOfBoundsException
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            List<Integer> nums = List.of(1, 2, 3, 4, 5);
            String output = "";
            // Loop condition uses <= which will try to access an invalid index
            for (int i = 0; i <= nums.size(); i++) {
                output += nums.get(i) + " ";
            }
            System.out.println(output);
        });
    }

    // This method is commented out because it does not compile:
    // Lists do not have a length property, they use size() method.
    @Test
    void badFor3() {
//        List<Integer> nums = List.of(1, 2, 3, 4, 5);
//        String output = "";
//        for (int i = 0; i <= nums.length; i++) {
//            output += nums.get(i) + " ";
//        }
//        System.out.println(output);
    }

    // Demonstrates a common mistake: printing the entire list instead of each element
    @Test
    void shouldPrintTheListInsteadOfTheListElement() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
        // For-each loop over the list elements
        for (Integer num : nums) {
            // Mistakenly appending the whole list 'nums' instead of the current element 'num'
            output += nums + " ";
        }
        System.out.println(output);

        // The output repeats the full list string 5 times, once for each element
        assertEquals("[1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] [1, 2, 3, 4, 5] ", output);
    }

    // This method is commented out because it doesn't compile:
    // 'int' is a reserved keyword in Java and cannot be used as a variable name.
    @Test
    void shouldNotCompileBecauseOfUsingReservedWord() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
//        for (Integer int : nums) {
//            output += int + " ";
//        }
        System.out.println(output);
    }

    // Uses the List's forEach method with a lambda expression to print each element
    @Test
    void shouldPrintWithForEach() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.forEach(num -> System.out.println(num));
    }

}
