package Lesson10.ex10_7_exercise;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author oracle
 */
public class JoinTest {
    
    public static void main(String[] args) {

        List<SalesTxn> tList = SalesTxn.createTxnList();
        
        // Print out a sorted list of unique buyer names
        System.out.println("=== Sorted Buyer's List ===");
        String result = tList.stream()
                .map(t -> t.getBuyerName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", ")); //Replace with your stream
        
        System.out.println("Buyer list: " + result);
            
        
        
        
    }
}
