package DummiesBook.Book8.chapter4_JDCB;

public class getConnection {
    public static void main(String[] args) {
        private static Connection getConnection()
        {
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost/Movies";
                String user = "root";
                String pw = "PassWord";
                con = DriverManager.getConnection(url, user, pw);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
                System.exit(0);
            }
            return con;
        }
    }
}
