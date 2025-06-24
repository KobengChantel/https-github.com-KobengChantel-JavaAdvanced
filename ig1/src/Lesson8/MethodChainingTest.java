package Lesson8;

import java.util.List;

public class MethodChainingTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        System.out.println("\n===CA Transactions for ACME (Two filters)===");
        //two filter methods
        tList.stream()
                .filter(t -> t.getState().equals(State.CA))
                .filter(t -> t.getBuyer().getName().equals("Acme Electronics"))
                .forEach(SalesTxn :: printSummary);
        System.out.println();
        System.out.println("\n===CA Transactions for ACME (One filter)===");
        //one filter method
        tList.stream()
                .filter(t -> t.getState().equals(State.CA) && t.getBuyerName().equals("Acme Electronics"))
                .forEach(SalesTxn :: printSummary);
    }
}
