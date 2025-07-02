package Lesson9;

import java.util.List;
import java.util.function.ToDoubleFunction;

public class TestToDoubleFunction {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        ToDoubleFunction<SalesTxn> discount = t -> t.getTransactionTotal() * t.getDiscountRate();
        SalesTxn first = tList.get(0);

        System.out.println("\n===Discount===");
        System.out.println(discount.applyAsDouble(first));
    }
}
