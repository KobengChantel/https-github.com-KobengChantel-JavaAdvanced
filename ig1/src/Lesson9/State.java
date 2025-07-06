package Lesson9;

/**
 *
 * @author oracle
 */

// Enum representing U.S. states used in transactions, each with a corresponding string abbreviation
public enum State {
    CA("CA"),   // California
    CO("CO"),   // Colorado
    MA("MA");   // Massachusetts

    private final String str;  // String abbreviation of the state

    // Constructor assigns the abbreviation string to the enum instance
    State(String stateStr){
        this.str = stateStr;
    }

    // Getter method to retrieve the state's string abbreviation
    public String getStr(){
        return str;
    }

}
