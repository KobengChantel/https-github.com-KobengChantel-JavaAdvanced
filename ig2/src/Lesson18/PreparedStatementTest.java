package Lesson18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class PreparedStatementTest {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/adv_java";
        String username = "postgres";
        String password = "Jada2004";
        String input = "";
        double searchValue;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            PreparedStatement pStmt = con.prepareStatement("SELECT * FROM public.\"Employee\" WHERE SALARY > ?");
            // Loop 
            while (true) {
                System.out.print("Enter salary to search for or Q to quit: ");
                input = in.readLine();
                if (input.equals("q") || input.equals("Q")) {
                    break;
                }
                searchValue = Double.valueOf(input);
                pStmt.setDouble(1, searchValue);
                ResultSet rs = pStmt.executeQuery();
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
            }// end of while
        } catch (NumberFormatException n) {
            System.out.println("Please enter a valid number.");
        } catch (IOException | SQLException e) {
            System.out.println("SQLException: " + e);
        } // end of try-with-resources
    }
}