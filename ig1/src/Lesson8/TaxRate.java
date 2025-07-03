package Lesson8;

/**
 * Enum representing tax rates for specific US states.
 * Each enum constant holds a tax rate value.
 *
 * @author oracle
 */
public enum TaxRate {
    CA(0.09d),  // California tax rate 9%
    CO(0.08d),  // Colorado tax rate 8%
    MA(0.09d);  // Massachusetts tax rate 9%

    private final double rate;  // The tax rate for the state

    // Constructor to set the tax rate value
    TaxRate(double rate){
        this.rate = rate;
    }

    /**
     * Returns the tax rate for this enum constant.
     * @return tax rate as a double
     */
    public double getRate(){
        return rate;
    }

    /**
     * Returns the tax rate for the given State enum by matching it to the corresponding TaxRate.
     * @param s State enum value
     * @return tax rate as a double
     */
    public static double byState(State s){
        double rate = 0.0d;

        switch(s){
            case CA: rate = CA.getRate(); break;
            case CO: rate = CO.getRate(); break;
            case MA: rate = MA.getRate(); break;
        }

        return rate;
    }
}
