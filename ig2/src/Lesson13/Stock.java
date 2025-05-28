package Lesson13;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Random;

// class models a stock holding with purchase and simulated current prices, supports serialization with custom handling of transient fields, and provides methods to get stock value and formatted details.

// Stock class represents a stock holding and supports serialization
public class Stock implements Serializable {

    private static final long serialVersionUID = 100L; // Serialization version control
    private String symbol;        // Stock symbol (e.g., ORCL)
    private int shares;           // Number of shares held
    private double purchasePrice; // Price at which shares were purchased
    private transient double currPrice; // Current price (transient: not serialized)

    // Constructor initializes the stock and sets a simulated current price
    public Stock(String symbol, int shares, double purchasePrice) {
        this.symbol = symbol;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
        setStockPrice(); // Initialize current price
    }

    // Custom deserialization method to restore transient current price after reading object
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Default deserialization for non-transient fields
        setStockPrice();         // Simulate fetching current price after deserialization
    }

    public String getSymbol() {
        return symbol;
    }

    // Calculate total value based on current price and number of shares
    public double getValue() {
        return shares * currPrice;
    }

    // Simulate fetching/updating the current stock price randomly
    private void setStockPrice() {
        Random r = new Random();
        double rVal = r.nextDouble();
        double p = (currPrice == 0) ? purchasePrice : currPrice;

        if (rVal < 0.5) {
            currPrice = p + (-10 * rVal);
        } else {
            currPrice = p + (10 * rVal);
        }
    }

    // Nicely formatted string representation of the stock details
    @Override
    public String toString() {
        double value = getValue();
        return "Stock:  " + symbol + "\n"
                + "Shares: " + shares + " @ " + NumberFormat.getCurrencyInstance().format(purchasePrice) + "\n"
                + "Curr $: " + NumberFormat.getCurrencyInstance().format(currPrice) + "\n"
                + "Value:  " + NumberFormat.getCurrencyInstance().format(value) + "\n";
    }
}
