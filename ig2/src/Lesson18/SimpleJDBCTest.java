package Lesson18;

import java.sql.*;
import java.util.Date;

// This program connects to a PostgreSQL database and retrieves all Employee records, printing their details to the console.

public class SimpleJDBCTest {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/EmployeeM";
        String username = "postgre";
        String password = "postgre";


        // SQL query to select all employees
        String query = "SELECT * FROM public.\"Employee\"";

        // Try-with-resources to automatically close Connection, Statement, and ResultSet
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Loop through each row in the result set and print employee details
            while (rs.next()) {
                int empID = rs.getInt("ID");
                String first = rs.getString("FIRSTNAME");
                String last = rs.getString("LASTNAME");
                Date birthDate = rs.getDate("BIRTHDATE");
                double salary = rs.getDouble("SALARY");

                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first + " " + last + "\n"
                        + "Birth Date:    " + birthDate + "\n"
                        + "Salary:        " + salary + "\n");
            } // end of while loop

        } catch (SQLException ex) {
            // Handle SQL exceptions by printing detailed error information including chained exceptions
            while (ex != null) {
                System.out.println("SQLState:  " + ex.getSQLState());
                System.out.println("Error Code:" + ex.getErrorCode());
                System.out.println("Message:   " + ex.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause:" + t);
                    t = t.getCause();
                }
                ex = ex.getNextException();
            }
        }
    }
}
