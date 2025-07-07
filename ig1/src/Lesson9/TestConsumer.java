package Lesson9;

import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {
        // Create a list of sample SalesTxn objects
        List<SalesTxn> tList = SalesTxn.createTxnList();

        // Consumer to print transaction ID and buyer name for each SalesTxn
        Consumer<SalesTxn> buyerConsumer = t ->
                System.out.println("Id: " + t.getTxnId() + " Buyer: " + t.getBuyerName());

        System.out.println("\n==Buyers Lambda==");
        // Use stream and forEach to apply the Consumer on each transaction in the list
        tList.stream()
                .forEach(buyerConsumer);
    }
}
