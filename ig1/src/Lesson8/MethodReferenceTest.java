package Lesson8;

import java.util.List;
import java.util.function.Predicate;

/**
 * Demonstrates using a Predicate and lambda expressions with Java streams to filter and print sales transactions from California (CA).
 */
public class MethodReferenceTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n=== CA Transactions Lambda ===");

        // Predicate to test if a transaction is from state CA
        Predicate<SalesTxn> state = t -> t.getState().equals(State.CA);

        // Stream the list, filter by state predicate, and print summaries using a lambda
        tList.stream()
                .filter(state)
                .forEach(t -> t.printSummary());
    }
}
