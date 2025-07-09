package Lesson9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        // Initialize an empty list to hold SalesTxn objects
        List<SalesTxn> tList = new ArrayList<>(10);

        // Supplier lambda that builds and returns a new SalesTxn object when called
        Supplier<SalesTxn> txnSupplier = () -> new SalesTxn.Builder()
                .txnId(101)
                .salesPerson("John Adams")
                .buyer(Buyer.getBuyerMap().get("PriceCo"))
                .product("Widget")
                .paymentType("Cash")
                .unitPrice(20)
                .unitCount(8000)
                .txnDate(LocalDate.of(2013,11,10))
                .city("Boston")
                .state(State.MA)
                .code("02108")
                .build();

        // Add a new transaction created by the supplier to the list
        tList.add(txnSupplier.get());

        System.out.println("\n==Supplier==");
        // Print the transaction id, salesperson, and product for each transaction in the list
        tList.stream().forEach(t ->
                System.out.println(t.getTxnId() + " " + t.getSalesPerson() + " " + t.getProduct()));
    }
}
