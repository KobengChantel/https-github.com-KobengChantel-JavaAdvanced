package Lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

// This program connects to a PostgreSQL database and lets the user repeatedly query Employees with salaries above a user-specified threshold using a PreparedStatement.

public class PreparedStatementTest {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:postgresql://localhost:5432/EmployeeM";
        String username = "postgre";
        String password = "postgre";


        String input = "";           // To store user input
        double searchValue;          // Salary threshold entered by user
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // Read user input from console

        // Try-with-resources to manage database connection
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            // Prepare SQL query with parameter placeholder for salary
            PreparedStatement pStmt = con.prepareStatement("SELECT * FROM public.\"Employee\" WHERE SALARY > ?");

            // Loop to continuously ask user for salary input until they quit
            while (true) {
                System.out.print("Enter salary to search for or Q to quit: ");
                input = in.readLine();

                // Exit loop if user inputs 'q' or 'Q'
                if (input.equals("q") || input.equals("Q")) {
                    break;
                }

                // Convert input to double to use as parameter in query
                searchValue = Double.valueOf(input);

                // Set the salary parameter in prepared statement
                pStmt.setDouble(1, searchValue);

                // Execute query and get results
                ResultSet rs = pStmt.executeQuery();

                // Iterate through and print each matching employee's details
                while (rs.next()) {
                    int empID = rs.getInt("ID");
                    String first = rs.getString("FIRSTNAME");
                    String last = rs.getString("LASTNAME");
                    Date birth_date = rs.getDate("BIRTHDATE");
                    float salary = rs.getFloat("SALARY");

                    System.out.format("Employee ID:   %s%n"
                                    + "Employee Name: %s %s%n"
                                    + "Birth Date:    %s%n"
                                    + "Salary:        %s%n%n",
                            empID, first, last, birth_date, salary);
                }
            } // end of while loop

        } catch (NumberFormatException n) {
            // Handle invalid number input
            System.out.println("Please enter a valid number.");
        } catch (IOException | SQLException e) {
            // Handle IO and SQL exceptions
            System.out.println("SQLException: " + e);
        } // end of try-with-resources
    }
}
