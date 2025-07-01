package Lesson9;

import java.util.List;
import java.util.function.BiPredicate;

public class TestBinary {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        SalesTxn first = tList.get(0);
        String testState = "CA";

        BiPredicate<SalesTxn, String> stateBiPred = (t,s) -> t.getState().getStr().equals(s);

        System.out.println("First state is California(CA)? " + stateBiPred.test(first, testState));
    }
}
