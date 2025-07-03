package Lesson8;

import java.util.List;

/**
 * Demonstrates iterating over a list of sales transactions using a traditional for-each loop to print summaries.
 */
public class ForLoopTest {
    public static void main(String[] args) {
        // Create a sample list of SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n=== Print List with for ===");
        // Loop through each SalesTxn and call its printSummary method
        for(SalesTxn t : tList){
            t.printSummary();
        }
    }
}
