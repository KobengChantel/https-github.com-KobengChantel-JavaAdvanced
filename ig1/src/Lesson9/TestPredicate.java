package Lesson9;

import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        // Create a list of sample SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Predicate lambda that tests if a SalesTxn's state is Massachusetts (MA)
        Predicate<SalesTxn> massSales = t -> t.getState().equals(State.MA);

        System.out.println("\n===Sales - Stream===");
        // Use stream to filter transactions where state is MA and print their summaries
        tList.stream()
                .filter(massSales)
                .forEach(t -> t.printSummary());

        System.out.println("\n===Sales - Method Call===");
        // Use traditional for-loop and predicate test method to print summaries for transactions in MA
        for(SalesTxn t : tList) {
            if(massSales.test(t)) {
                t.printSummary();
            }
        }
    }
}
