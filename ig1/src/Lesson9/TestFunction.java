package Lesson9;

import java.util.List;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        // Create a list of sample SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();
        // Get the first transaction from the list (index 0)
        SalesTxn first = tList.get(0);
        // Function to extract the buyer's name from a SalesTxn object
        Function<SalesTxn, String> buyerFunc = t -> t.getBuyer().getName();

        System.out.println("\n===First Buyer===");
        // Apply the function to the first SalesTxn and print the buyer's name
        System.out.println(buyerFunc.apply(first));
    }
}
