package Lesson8;

import java.util.List;

public class ForLoopTest {
    public static void main(String[] args) {
        List<SalesTxn> tList = SalesTxn.createTxnList();

        System.out.println("\n=== Print List with for ===");
        for(SalesTxn t:tList){
            t.printSummary();
        }
    }
}
