package Lesson8;

import java.util.List;

/**
 * Demonstrates method chaining with Java streams by filtering and printing sales transactions
 * for buyers named "Acme Electronics" located in California (CA), using two different filter approaches.
 */
public class MethodChainingTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n=== CA Transactions for ACME (Two filters) ===");
        // Using two filter() calls for state and buyer name
        tList.stream()
                .filter(t -> t.getState().equals(State.CA))
                .filter(t -> t.getBuyer().getName().equals("Acme Electronics"))
                .forEach(SalesTxn::printSummary);

        System.out.println();

        System.out.println("\n=== CA Transactions for ACME (One filter) ===");
        // Using a single filter() call combining both conditions with &&
        tList.stream()
                .filter(t -> t.getState().equals(State.CA) && t.getBuyerName().equals("Acme Electronics"))
                .forEach(SalesTxn::printSummary);
    }
}
