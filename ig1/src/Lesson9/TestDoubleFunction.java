package Lesson9;

import java.util.List;
import java.util.function.DoubleFunction;

public class TestDoubleFunction {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();
        TestDoubleFunction test = new TestDoubleFunction();

        DoubleFunction<String> calc = t -> String.valueOf(t * 3);

        String result = calc.apply(20);
        System.out.println("New value is: " + result);
    }
}
