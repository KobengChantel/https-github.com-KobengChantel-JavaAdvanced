package Lesson13;

//class defines a custom checked exception used to signal errors specific to stock-related operations

// Custom exception class for handling errors related to Stock operations
public class StockException extends Exception {

    private static final long serialVersionUID = 103L; // Serialization version ID

    // Constructor that accepts an error message describing the exception reason
    public StockException(String reason) {
        super(reason);
    }
}
