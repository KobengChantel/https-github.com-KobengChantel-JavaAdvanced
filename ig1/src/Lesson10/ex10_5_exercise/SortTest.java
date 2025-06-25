package Lesson10.ex10_5_exercise;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author oracle
 */
public class SortTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        Consumer<SalesTxn> transReport = 
          t -> System.out.printf("Id: " + t.getTxnId() 
            + " Seller: " + t.getSalesPerson() + " Buyer: " 
            + t.getBuyerName() + " Amt: $%,9.2f%n", t.getTransactionTotal());
        
        // Print out PriceCo Transactions
        System.out.println("=== PriceCo Transactions ===");
        tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                //prints in ascending order
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal))
                .forEach(transReport);
        
        System.out.println("\n=== PriceCo Transactions Reversed ===");
        tList.stream()
                .filter(t -> t.getBuyerName().equals("PriceCo"))
                //prints in descending order
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal).reversed())
                .forEach(transReport);
        
        // Sort by Buyer, SalesPerson, Transaction Total
        System.out.println("\n=== Triple Sort Transactions ===");
        tList.stream()
                //prints in ascending order
                .sorted(Comparator.comparing(SalesTxn::getBuyerName))
                .sorted(Comparator.comparing(SalesTxn::getSalesPerson))
                .sorted(Comparator.comparing(SalesTxn::getTransactionTotal))
                .forEach(transReport);
    }
}
