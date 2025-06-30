package Lesson4;

// This class provides a method to calculate the average of a variable number of integer arguments (varargs).

public class Statistics {
    // Method to calculate average of any number of integers using varargs
    public static float avg(int ... nums) {
        int sum = 0;
        float result = 0;

        // Check if there are any numbers passed to avoid division by zero
        if(nums.length > 0) {
            // Sum all the integers passed
            for (int x : nums) {
                sum += x;
            }
            // Calculate the average by dividing the sum by the number of elements
            result = ((float) sum / nums.length);
        }
        // Return the calculated average (or 0 if no numbers given)
        return result;
    }
}
