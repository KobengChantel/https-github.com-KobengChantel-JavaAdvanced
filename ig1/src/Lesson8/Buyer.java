package Lesson8;

import java.util.HashMap;
import java.util.Map;

/**
 * The Buyer class represents a customer with a name and classification,
 * providing factory method creation and a sample map of Buyers.
 *
 * @author oracle
 */
public class Buyer {

    private String name;
    private BuyerClass buyerClass;

    // Private default constructor to prevent direct instantiation
    private Buyer(){
        super();
    }

    // Private constructor to initialize name and buyerClass
    private Buyer(String name, BuyerClass buyerClass){
        this.name = name;
        this.buyerClass = buyerClass;
    }

    // Factory method to create a new Buyer instance
    public static Buyer getInstance(String name, BuyerClass buyerClass){
        return new Buyer(name, buyerClass);
    }

    // Getter for name
    public String getName(){
        return name;
    }

    // Getter for buyerClass
    public BuyerClass getBuyerClass(){
        return buyerClass;
    }

    // Returns a map of sample Buyers with their IDs as keys
    public static Map<String, Buyer> getBuyerMap(){
        Map<String, Buyer> buyerMap = new HashMap<>();

        // Create Buyer list with various classifications
        buyerMap.put("Acme", Buyer.getInstance("Acme Electronics", BuyerClass.SILVER));
        buyerMap.put("BestDeals", Buyer.getInstance("Best Deals", BuyerClass.GOLD));
        buyerMap.put("GreatDeals", Buyer.getInstance("Great Deals", BuyerClass.BASIC));
        buyerMap.put("MomAndPops", Buyer.getInstance("Mom and Pops", BuyerClass.BASIC));
        buyerMap.put("RadioHut", Buyer.getInstance("Radio Hut", BuyerClass.PLATINUM));
        buyerMap.put("PriceCo", Buyer.getInstance("PriceCo", BuyerClass.SILVER));

        return buyerMap;
    }
}
