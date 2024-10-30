package DummiesBook.Book8.chapter4_JDCB;

public class loanMovie {
        public static void main(String[] args) {
            private static void loanMovie(int id, String lastName,
                    String firstName)
            {
                Connection con = getConnection();
                try
                {
                    Statement stmt = con.createStatement();
                    String insert = "insert into friend "
                            + "(lastname, firstname, movieid) "
                            + "values ("
                            + "\"" + lastName + "\", \""
                            + firstName + "\", " +
                            + id + ")";
                    int i = stmt.executeUpdate(insert);
                    if (i == 1)
                        System.out.println("Loan recorded.");
                    else
                        System.out.println("Loan not recorded.");
                }
                catch (SQLException e)
                {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }
        }
}
