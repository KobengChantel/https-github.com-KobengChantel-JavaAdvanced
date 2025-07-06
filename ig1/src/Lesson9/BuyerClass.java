package Lesson9;

/**
 * Enum representing different buyer classes with associated discount rates.
 */
public enum BuyerClass {
    BASIC(0.0d),       // No discount
    SILVER(0.01d),     // 1% discount rate
    GOLD(0.02d),       // 2% discount rate
    PLATINUM(0.03d);   // 3% discount rate

    private final double rate;  // Discount rate for the buyer class

    /**
     * Constructor to set the discount rate for the buyer class.
     * @param rate discount rate as a decimal
     */
    BuyerClass(double rate){
        this.rate = rate;
    }

    /**
     * Returns the discount rate associated with the buyer class.
     * @return discount rate
     */
    public double getRate(){
        return rate;
    }
}
