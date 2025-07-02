package Lesson9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {
        List<SalesTxn> tList = new ArrayList<>(10);
        //suplier builder to add a new supplier/ new Sales Txn
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
        tList.add(txnSupplier.get());
        System.out.println("\n==Supplier=");
        tList.stream().forEach(t -> System.out.println(t.getTxnId() + " " + t.getSalesPerson() + " " + t.getProduct()));
    }
}
