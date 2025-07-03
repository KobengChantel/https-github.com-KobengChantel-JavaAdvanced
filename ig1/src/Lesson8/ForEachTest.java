package Lesson8;

import java.util.List;

/**
 * Demonstrates iterating over a list of sales transactions using Java's forEach and lambda expressions to print summaries.
 */
public class ForEachTest {
    public static void main(String[] args) {
        // Create a sample list of SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Using forEach with lambda to print detailed info for each transaction
        System.out.println("\n== Print List with Lambda ==");
        tList.forEach(t -> System.out.println(
                "\nID: " + t.getTxnId() +
                        "\nSeller: " + t.getSalesPerson() +
                        "\nBuyer: " + t.getBuyerName() +
                        "\nAmt: " + t.getTransactionTotal()
        ));
    }
}
