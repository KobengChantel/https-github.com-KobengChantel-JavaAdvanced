package Lesson9;

import java.util.List;
import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        //predicate is a lambda expression(returns a boolean)
        Predicate<SalesTxn> massSales = t -> t.getState().equals(State.MA);

        System.out.println("\n===Sales - Stream===");
        tList.stream()
                .filter(massSales)
                .forEach(t -> t.printSummary());

        System.out.println("\n===Sales - Method Call===");
        for(SalesTxn t: tList) {
            if(massSales.test(t)) {
                t.printSummary();
            }
        }
    }
}
