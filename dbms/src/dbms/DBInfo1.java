package dbms;

import java.sql.*;

public class DBInfo1 {
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/storefront1";
            String userName = "root";
            String password = "1234";

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded...");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("connection established");
        } catch (ClassNotFoundException e) {

            throw new ClassNotFoundException("conn is null");

        } catch (SQLException e) {

            throw new SQLException();
        }
        return con;
    }

    public static void closeConection(java.sql.Connection conn) throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            throw new SQLException();
        }
    }

}
