package DummiesBook.Book8.chapter4_JDCB;

import java.sql.Connection; // Import Connection
import java.sql.DriverManager; // Import DriverManager
import java.sql.SQLException; // Import SQLException

public class getConnection { // Class name should follow PascalCase convention
    // Method to establish a database connection
    private static Connection getConnection() {
        Connection con = null;
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Movies"; // PostgreSQL JDBC URL
            String user = ""; // Your PostgreSQL username
            String pw = ""; // Your PostgreSQL password
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found: " + e.getMessage());
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            System.exit(0);
        }
        return con;
    }

    public static void main(String[] args) {
        // Establish the connection and handle the response
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connection established successfully!");
            // Close the connection if needed later
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
