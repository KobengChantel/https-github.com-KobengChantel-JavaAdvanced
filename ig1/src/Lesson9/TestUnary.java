package Lesson9;

import java.util.List;
import java.util.function.UnaryOperator;

public class TestUnary {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        UnaryOperator<String> unaryStr = s -> s.toUpperCase();
        SalesTxn first = tList.get(0);

        System.out.println("Uppercase Buyer: " + unaryStr.apply(first.getBuyerName()));
    }
}
