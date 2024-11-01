package DummiesBook.Book8.chapter4_JDCB;

//public class loanMovie {
//        public static void main(String[] args) {
//            private static void loanMovie(int id, String lastName,
//                    String firstName);
//            {
//                Connection con = getConnection();
//                try
//                {
//                    Statement stmt = con.createStatement();
//                    String insert = "insert into friend "
//                            + "(lastname, firstname, movieid) "
//                            + "values ("
//                            + "\"" + lastName + "\", \""
//                            + firstName + "\", " +
//                            + id + ")";
//                    int i = stmt.executeUpdate(insert);
//                    if (i == 1)
//                        System.out.println("Loan recorded.");
//                    else
//                        System.out.println("Loan not recorded.");
//                }
//                catch (SQLException e)
//                {
//                    System.out.println(e.getMessage());
//                    System.exit(0);
//                }
//            }
//        }
//}



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class loanMovie {

    public static void main(String[] args) {
        loanMovie(1, "Doe", "John");  // Example call
    }

    private static void loanMovie(int id, String lastName, String firstName) {
        Connection con = getConnection();
        if (con == null) {
            System.out.println("Connection failed.");
            return;
        }

        try {
            Statement stmt = con.createStatement();
            String insert = "insert into friend "
                    + "(lastname, firstname, movieid) "
                    + "values ("
                    + "\"" + lastName + "\", \""
                    + firstName + "\", "
                    + id + ")";
            int i = stmt.executeUpdate(insert);
            if (i == 1)
                System.out.println("Loan recorded.");
            else
                System.out.println("Loan not recorded.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:your_database_url", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            return null;
        }
    }
}
