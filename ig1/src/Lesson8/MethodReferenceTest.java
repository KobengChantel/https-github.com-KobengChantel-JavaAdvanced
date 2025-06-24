package Lesson8;

import java.util.List;
import java.util.function.Predicate;

public class MethodReferenceTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        System.out.println("\n===CA Transactions Lambda===");

        Predicate<SalesTxn> state = t -> t.getState().equals(State.CA);
        //reference makes use of stream
        tList.stream()
                .filter(state)
                .forEach(t -> t.printSummary());
    }
}
