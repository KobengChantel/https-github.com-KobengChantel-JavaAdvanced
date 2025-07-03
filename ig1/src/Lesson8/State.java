package Lesson8;

/**
 * Enum representing US states used in the SalesTxn system.
 * Each enum constant holds a two-letter state code string.
 *
 * @author oracle
 */
public enum State {
    CA("CA"),  // California
    CO("CO"),  // Colorado
    MA("MA");  // Massachusetts

    private final String str;  // The two-letter abbreviation for the state

    // Constructor to set the string code for the enum constant
    State(String stateStr){
        this.str = stateStr;
    }

    /**
     * Returns the string representation (two-letter code) of the state.
     * @return two-letter state code
     */
    public String getStr(){
        return str;
    }
}
