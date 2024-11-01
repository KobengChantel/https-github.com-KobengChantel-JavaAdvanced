package DummiesBook.Book8.chapter3_DataBase;
//mysql> source c:\data\create.sql


//package DummiesBook.Book8.chapter3_DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database1 {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // Connect to the PostgreSQL server
    private static final String USER = "postgres"; // Your PostgreSQL username
    private static final String PASS = "postgreSQL"; // Your PostgreSQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Drop the database if it exists (PostgreSQL requires you to connect to a different database to drop one)
            // You can't drop the current database you're connected to.
            stmt.executeUpdate("DROP DATABASE IF EXISTS movies");

            // Create the database
            stmt.executeUpdate("CREATE DATABASE movies");

            // Note: We cannot execute USE in PostgreSQL.
            // Instead, connect to the newly created database after this step.
            // Close the current connection and create a new one to the "movies" database.
            conn.close(); // Close the current connection

            // Create a new connection to the "movies" database
            try (Connection newConn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies", USER, PASS);
                 Statement newStmt = newConn.createStatement()) {

                // Create the table
                newStmt.executeUpdate("CREATE TABLE movie (" +
                        "id SERIAL PRIMARY KEY, " + // Use SERIAL for auto-increment
                        "title VARCHAR(50), " +
                        "year INT, " +
                        "price DECIMAL(8,2))");

                // Insert data into the table
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('It\'s a Wonderful Life', 1946, 14.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Young Frankenstein', 1974, 16.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Star Wars', 1977, 17.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('The Princess Bride', 1987, 16.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Glory', 1989, 14.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('The Game', 1997, 14.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Shakespeare in Love', 1998, 19.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Zombieland', 2009, 18.95)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('The King\'s Speech', 2010, 17.85)");
                newStmt.executeUpdate("INSERT INTO movie (title, year, price) VALUES ('Star Trek Into Darkness', 2013, 19.95)");

                System.out.println("Database and table created and data inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR!");
        }
    }
}
