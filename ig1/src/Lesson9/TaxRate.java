package Lesson9;

/**
 *
 * @author oracle
 */

// Enum representing tax rates for specific U.S. states
public enum TaxRate {
    CA(0.09d),  // California tax rate 9%
    CO(0.08d),  // Colorado tax rate 8%
    MA(0.09d);  // Massachusetts tax rate 9%

    private final double rate;  // Tax rate value for the state

    // Constructor initializes the tax rate for the enum instance
    TaxRate(double rate){
        this.rate = rate;
    }

    // Getter method to return the tax rate
    public double getRate(){
        return rate;
    }

    // Static method to get the tax rate by State enum value
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
