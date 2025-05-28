package Lesson4;

public class Statistics {
    //varargs
    public static float avg(int ... nums) {
        int sum = 0;
        float result = 0;
        if(nums.length > 0) {
            for (int x : nums) {
                sum += x;
            }
            result = ((float) sum/ nums.length);
        }
        return result;
    }
}
