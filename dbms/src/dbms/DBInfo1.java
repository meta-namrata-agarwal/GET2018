package dbms;

import java.sql.*;

public class DBInfo1 {
  public static Connection getConn() {
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
          e.printStackTrace();
          System.exit(1);
      } catch (SQLException e) {
          e.printStackTrace();
          System.exit(2);
      }
      return con;
  }

}
