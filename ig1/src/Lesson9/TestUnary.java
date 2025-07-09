package Lesson9;

import java.util.List;
import java.util.function.UnaryOperator;

/**
 * This class demonstrates using a UnaryOperator functional interface
 * to transform a String (buyer name) to uppercase.
 */
public class TestUnary {
    public static void main(String[] args) {
        // Create a list of SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Define a UnaryOperator that converts a string to uppercase
        UnaryOperator<String> unaryStr = s -> s.toUpperCase();

        // Get the first SalesTxn from the list
        SalesTxn first = tList.get(0);

        // Apply the UnaryOperator on the buyer's name and print the result
        System.out.println("Uppercase Buyer: " + unaryStr.apply(first.getBuyerName()));
    }
}
