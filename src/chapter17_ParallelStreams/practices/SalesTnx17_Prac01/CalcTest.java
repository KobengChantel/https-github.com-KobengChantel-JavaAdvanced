package chapter17_ParallelStreams.practices.SalesTnx17_Prac01;

import java.util.List;

/**
 *
 * @author oracle
 */
public class CalcTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        
        // Print out Transaction Totals
        System.out.println("=== Transactions Totals ===");
        
        // Put code here
        
        
        double t1 = 0; // Put result here
        
        System.out.printf("Radio Hut Total: $%,9.2f%n", t1);
        
    }
}
