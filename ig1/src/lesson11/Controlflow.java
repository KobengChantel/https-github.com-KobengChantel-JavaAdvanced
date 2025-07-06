package lesson11;

// This class demonstrates a basic use of enum and switch statement to print the name of a card suit.

public class Controlflow {

    // Define an enum called Suit with four possible values
    enum Suit {
        SPADES, DIAMONDS, CLUBS, HEARTS
    }

    public static void main(String args[]) {
        // Assign the enum constant HEARTS to variable suit
        Suit suit = Suit.HEARTS;

        // Use switch-case to print the name of the suit
        switch(suit) {
            case CLUBS:
                System.out.print("club");
                break;
            case DIAMONDS:
                System.out.print("diamond");
                break;
            case HEARTS:
                System.out.print("diamond");  // Note: This prints "diamond" even though suit is HEARTS, possibly a mistake
                break;
            case SPADES:
                System.out.print("spades");
                break;
            default:
                // Assert false will trigger an error if suit is none of the above
                assert false : suit;
        }
    }
}
