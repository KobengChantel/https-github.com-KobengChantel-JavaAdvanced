package Lesson9;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Buyer with a name and a buyer classification.
 */
public class Buyer {

    private String name;
    private BuyerClass buyerClass;

    // Private default constructor
    private Buyer(){
        super();
    }

    // Private constructor to initialize Buyer with name and class
    private Buyer(String name, BuyerClass buyerClass){
        this.name = name;
        this.buyerClass = buyerClass;
    }

    /**
     * Factory method to create a new Buyer instance.
     * @param name the buyer's name
     * @param buyerClass the classification of the buyer
     * @return a new Buyer object
     */
    public static Buyer getInstance(String name, BuyerClass buyerClass){
        return new Buyer(name, buyerClass);
    }

    public String getName(){
        return name;
    }

    public BuyerClass getBuyerClass(){
        return buyerClass;
    }

    /**
     * Creates and returns a map of sample Buyers keyed by their ID.
     * @return Map<String, Buyer> map of sample buyers
     */
    public static Map<String, Buyer> getBuyerMap(){
        Map<String, Buyer> buyerMap = new HashMap<>();

        // Populate map with sample Buyers
        buyerMap.put("Acme", Buyer.getInstance("Acme Electronics", BuyerClass.SILVER));
        buyerMap.put("BestDeals", Buyer.getInstance("Best Deals", BuyerClass.GOLD));
        buyerMap.put("GreatDeals", Buyer.getInstance("Great Deals", BuyerClass.BASIC));
        buyerMap.put("MomAndPops", Buyer.getInstance("Mom and Pops", BuyerClass.BASIC));
        buyerMap.put("RadioHut", Buyer.getInstance("Radio Hut", BuyerClass.PLATINUM));
        buyerMap.put("PriceCo", Buyer.getInstance("PriceCo", BuyerClass.SILVER));

        return buyerMap;
    }
}
