package Lesson11;

public class Invariant {
    static void checkNum(int num){
        int x = num;
        if (x > 0) {
            System.out.println("number is positive" + x);

        } else if (x == 0) {
            System.out.println("number is zero" + x);
        } else{
            //assert statements are used for testing
            //assert methods assume code is going to work( nothing wil print if it works)
            assert (x < 0);
        }
    }

    public static void main(String[] args) {
        checkNum(-4);
    }
}
