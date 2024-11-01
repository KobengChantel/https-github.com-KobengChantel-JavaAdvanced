package DummiesBook.Book8.chapter3_DataBase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Friend {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres"; // Replace with your MySQL username
    private static final String PASS = "postgreSQL"; // Replace with your MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Create the friend table
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS friend ("
                    + "lastname VARCHAR(50), "
                    + "firstname VARCHAR(50), "
                    + "movieid INT)");

            // Insert data into the friend table
            stmt.executeUpdate("INSERT INTO friend (lastname, firstname, movieid) VALUES ('Haskell', 'Eddie', 3)");
            stmt.executeUpdate("INSERT INTO friend (lastname, firstname, movieid) VALUES ('Haskell', 'Eddie', 5)");
            stmt.executeUpdate("INSERT INTO friend (lastname, firstname, movieid) VALUES ('Cleaver', 'Wally', 9)");
            stmt.executeUpdate("INSERT INTO friend (lastname, firstname, movieid) VALUES ('Mondello', 'Lumpy', 2)");
            stmt.executeUpdate("INSERT INTO friend (lastname, firstname, movieid) VALUES ('Cleaver', 'Wally', 3)");

            System.out.println("Friend table created and data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
