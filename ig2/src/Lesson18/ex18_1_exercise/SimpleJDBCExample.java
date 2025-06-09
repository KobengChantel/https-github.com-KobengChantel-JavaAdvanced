package Lesson18.ex18_1_exercise;

import java.sql.*;
import java.util.Date;

// This program connects to a PostgreSQL database,
// queries all records from the Employee table,
// and prints each employee's details to the console.

public class SimpleJDBCExample {

    public static void main(String[] args) {
        // Database connection URL assuming PostgreSQL on localhost with database adv_java
        String url = "jdbc:postgresql://localhost:5432/adv_java";
        String username = "postgres";  // Database username
        String password = "Jada2004";   // Database password
        String query = "SELECT * FROM public.\"Employee\"";  // SQL query to select all employees

        // Using try-with-resources to automatically close Connection and Statement objects
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            Statement stmt = con.createStatement();  // Create a statement to execute SQL query
            ResultSet rs = stmt.executeQuery(query); // Execute the query and get results

            // Iterate through each row in the ResultSet
            while (rs.next()) {
                int empID = rs.getInt("ID");                  // Get employee ID
                String first = rs.getString("FIRSTNAME");     // Get employee first name
                String last = rs.getString("LASTNAME");       // Get employee last name
                Date birth_date = rs.getDate("BIRTHDATE");    // Get employee birth date
                float salary = rs.getFloat("SALARY");         // Get employee salary

                // Print employee details with formatting
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                        + "Birth Date:    " + birth_date + "\n"
                        + "Salary:        " + salary + "\n");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions, print error and exit
            System.out.println("Exception creating connection: " + e);
            System.exit(0);
        }
        // Connection and Statement objects are automatically closed by try-with-resources
    }
}
