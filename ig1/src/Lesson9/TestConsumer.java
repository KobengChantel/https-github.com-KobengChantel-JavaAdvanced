package Lesson9;

import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        Consumer<SalesTxn> buyerConsumer = t ->
        System.out.println("Id: " + t.getTxnId()
        + " Buyer: " + t.getBuyerName());

        System.out.println("\n==Buyers Lambda==");
        tList.stream()
                .forEach(buyerConsumer);
    }
}
