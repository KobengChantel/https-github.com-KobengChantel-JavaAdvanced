package Lesson13;

import java.io.*;

// program demonstrates creating a stock portfolio, serializing it to a file, and then deserializing it back to verify the portfolio object is correctly saved and restored

public class SerializeStock {

    public static void main(String[] args) {
        // Create Stock objects representing individual stocks
        Stock s1 = new Stock("ORCL", 100, 32.50);
        Stock s2 = new Stock("APPL", 100, 245);
        Stock s3 = new Stock("GOOG", 100, 54.67);
        Portfolio p = null;

        // Create a Portfolio with the above stocks, handling possible exceptions
        try {
            p = new Portfolio(s1, s2, s3);
        } catch (PortfolioException pe) {
            System.out.println("Exception creating Portfolio: " + pe);
            System.exit(-1);
        }

        // Print the portfolio before serialization
        System.out.println("Before serialization:\n" + p + "\n");

        // Serialize the Portfolio object to a file
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Jada\\YourJavaDirectory\\portfolio.ser");
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(p);
            System.out.println("Successfully wrote Portfolio as an object");
        } catch (IOException i) {
            System.out.println("Exception writing out Portfolio: " + i);
        }

        // Deserialize the Portfolio object back from the file
        try (FileInputStream fis = new FileInputStream("C:\\Users\\Jada\\YourJavaDirectory\\portfolio.ser");
             ObjectInputStream in = new ObjectInputStream(fis)) {
            Portfolio newP = (Portfolio) in.readObject();
            System.out.println("Success: read Portfolio back in:\n" + newP);
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading in Portfolio: " + i);
        }
    }
}
