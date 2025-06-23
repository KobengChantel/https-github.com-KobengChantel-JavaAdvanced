package Lesson8;

import java.util.List;

public class ForEachTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();

//        System.out.println("\n=== Print List with forEach ===");
//        tList.forEach(t -> t.printSummary());

        System.out.println("\n== Print List with Lambda ==");
        tList.forEach(t -> System.out.println(
                "\nID: " + t.getTxnId() +
                        "\nSeller: " + t.getSalesPerson() +
                        "\nBuyer: " + t.getBuyerName() +
                        "\nAmt: " + t.getTransactionTotal()
        ));
    }
}
