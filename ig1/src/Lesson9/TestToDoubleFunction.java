package Lesson9;

import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * This class demonstrates using a ToDoubleFunction functional interface
 * to calculate a discount amount from a SalesTxn object.
 */
public class TestToDoubleFunction {
    public static void main(String[] args) {
        // Create a list of SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define a ToDoubleFunction that calculates discount by multiplying
        // transaction total by discount rate
        ToDoubleFunction<SalesTxn> discount = t -> t.getTransactionTotal() * t.getDiscountRate();

        // Get the first SalesTxn from the list
        SalesTxn first = tList.get(0);

        System.out.println("\n===Discount===");
        // Apply the discount function on the first SalesTxn and print the result
        System.out.println(discount.applyAsDouble(first));
    }
}
