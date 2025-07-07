package Lesson9;

import java.util.List;
import java.util.function.DoubleFunction;

public class TestDoubleFunction {
    public static void main(String[] args) {
        // Create a list of sample SalesTxn objects (not used directly here)
        List<SalesTxn> tList = SalesTxn.createTxnList();
        TestDoubleFunction test = new TestDoubleFunction();

        // DoubleFunction lambda that multiplies input by 3 and converts to String
        DoubleFunction<String> calc = t -> String.valueOf(t * 3);

        // Apply the function to the double value 20 and store the result as a string
        String result = calc.apply(20);

        // Print the resulting string
        System.out.println("New value is: " + result);
    }
}
