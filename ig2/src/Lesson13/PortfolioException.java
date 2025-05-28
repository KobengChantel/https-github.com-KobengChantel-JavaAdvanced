package Lesson13;

//class defines a custom checked exception for handling errors related to portfolio operations, with support for error messages and underlying causes

// Custom exception class for handling portfolio-related errors
public class PortfolioException extends Exception {

    private static final long serialVersionUID = 102L; // Serialization version ID

    // Constructor that accepts an error message
    public PortfolioException(String message) {
        super(message);
    }

    // Constructor that accepts an error message and a cause (another throwable)
    public PortfolioException(String message, Throwable t) {
        super(message, t);
    }
}
