package Lesson8;

/**
 * Enum representing different buyer classes with associated discount rates.
 *
 * @author oracle
 */
public enum BuyerClass {
    BASIC(0.0d),       // No discount
    SILVER(0.01d),     // 1% discount
    GOLD(0.02d),       // 2% discount
    PLATINUM(0.03d);   // 3% discount

    private final double rate;

    // Constructor to assign the discount rate to each buyer class
    BuyerClass(double rate){
        this.rate = rate;
    }

    // Getter to retrieve the discount rate for the buyer class
    public double getRate(){
        return rate;
    }
}
