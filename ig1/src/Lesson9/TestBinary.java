package Lesson9;

import java.util.List;
import java.util.function.BiPredicate;

public class TestBinary {
    public static void main(String[] args) {
        // Create a list of sample SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();
        // Get the first transaction from the list
        SalesTxn first = tList.get(0);
        // Define the state string to test against
        String testState = "CA";

        // BiPredicate that tests if a SalesTxn's state matches the given state string
        BiPredicate<SalesTxn, String> stateBiPred = (t, s) -> t.getState().getStr().equals(s);

        // Test and print whether the first transaction's state is "CA"
        System.out.println("First state is California(CA)? " + stateBiPred.test(first, testState));
    }
}
