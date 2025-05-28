package Lesson13;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//class represents a portfolio of unique stocks, allowing adding stocks with duplicate checks, calculating the total portfolio value, and providing a textual summary, all while supporting serialization

// Portfolio class manages a collection of unique Stock objects and supports serialization
public class Portfolio implements Serializable {

    private static final long serialVersionUID = 101L; // Version control for serialization
    private Set<Stock> stocks = new HashSet<>(); // Stores unique stocks in the portfolio

    // Default constructor initializes an empty portfolio
    public Portfolio() {
    }

    // Constructor that accepts multiple Stock objects and adds them to the portfolio
    public Portfolio(Stock... stocks) throws PortfolioException {
        for (Stock s : stocks) {
            addStock(s); // Add each stock while checking for duplicates
        }
    }

    // Adds a new stock to the set; throws exception if duplicate or any error occurs
    private void addStock(Stock newStock) throws PortfolioException {
        try {
            if (!stocks.add(newStock)) {
                throw new PortfolioException("Stock " + newStock.getSymbol() + " is a duplicate.");
            }
        } catch (Exception e) {
            throw new PortfolioException("Exception from Set.add method: " + e);
        }
    }

    // Calculates the total value of all stocks in the portfolio
    public double getValue() {
        double value = 0;
        for (Stock s : stocks) {
            value += s.getValue();
        }
        return value;
    }

    // Builds a string summary of the portfolio contents
    public String toString() {
        StringBuilder sb = new StringBuilder("Portfolio Summary\n");
        for (Stock s : stocks) {
            sb.append(s);
        }
        return sb.toString();
    }
}
