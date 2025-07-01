package Lesson9;

import java.util.List;
import java.util.function.Function;

public class TestFunction {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        //index 0
        SalesTxn first = tList.get(0);
        //overrides apply method
        Function<SalesTxn, String> buyerFunc = t -> t.getBuyer().getName();

        System.out.println("\n===First Buyer===");
        System.out.println(buyerFunc.apply(first));
    }
}
