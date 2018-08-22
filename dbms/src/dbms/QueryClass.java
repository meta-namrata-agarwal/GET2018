package dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryClass {

    /**
     * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
     * that user which are in shipped state. Orders should be sorted by order date
     * column in chronological order.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void orderDetailsByUserId(int userID) throws ClassNotFoundException, SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        final String query;
        query = "SELECT  OP.Order_id,OP.Date_of_order," + "  SUM(OD.QUANTITY*OD.PRICE) as price " + "FROM PRODUCT P"
                + " LEFT JOIN order_details OD" + " ON OD.Product_id=P.Product_id" + " LEFT JOIN order_placed OP"
                + " ON OP.Order_id=OD.Order_id" + " LEFT JOIN USER" + " ON USER.User_id=OP.User_id"
                + " WHERE  user.user_id=? AND OD.Order_status=\"SHIPPED\"" + " GROUP BY OD.Product_id, OD.Order_id"
                + " ORDER BY OP.Date_of_order DESC";

        try {

            con = DBInfo1.getConn();
            ps = con.prepareStatement(query);

            ps.setInt(1, userID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                OrderDetails order = new OrderDetails();
                order.setOrderId(resultSet.getInt("Order_id"));
                order.setPrice(resultSet.getFloat("price"));
                order.setDate(resultSet.getDate("Date_of_order"));
                System.out.println(order.toString());

            }
        } catch (SQLException e) {

            throw new SQLException();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        DBInfo1.closeConection(con);

    }

    // ASSIGNMENT 2
    /**
     * Insert five or more images of a product using batch insert technique.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    @SuppressWarnings("null")
    public static void batchInsertImage(List<Image> listImage) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement statement = null;
        final String query;
        query = "INSERT INTO product_image(Product_id,Image_id,Image) VALUES(?,?,?)";

        try {

            conn = DBInfo1.getConn();
            statement = conn.prepareStatement(query);

            conn.setAutoCommit(false);
            System.out.println("The SQL query is: " + query); // Echo For debugging
            System.out.println();

            for (int i = 0; i < listImage.size(); i++) {

                statement.setInt(1, listImage.get(i).getProductId());
                statement.setInt(2, listImage.get(i).getImageId());
                statement.setString(3, listImage.get(i).getBlobImage());
                statement.addBatch();
            }
            @SuppressWarnings("null")
            int result[] = statement.executeBatch();
            System.out.println("The number of rows inserted: " + result.length);
            conn.commit();
            System.out.println();

        } catch (SQLException ex) {
            conn.rollback();
            throw new SQLException();

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        DBInfo1.closeConection(conn);

    }

    // aSSIGNMENT 3
    /**
     * Delete all those products which were not ordered by any Shopper in last 1
     * year. Return the number of products deleted.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public static void deleteProductsNotOrderedInYear() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        final String query;

        query = "UPDATE PRODUCT P" + " INNER JOIN ORDER_deTAILS O" + " ON P.Product_id=O.Product_id"
                + " INNER JOIN order_placed OP" + " ON OP.Order_id=O.Order_id" + " SET ISACTIVE=0"
                + " WHERE  ISACTIVE = 1 AND P.Product_id not in ("            
                +" SELECT order_details.Product_id "
                +" FROM order_details "
                +" LEFT JOIN order_placed "
                +" ON order_placed.Order_id=order_details.Order_id "
                +" WHERE DATEDIFF(NOW(), order_placed.Date_of_order)<365)";

        try {
            conn = DBInfo1.getConn();
            statement = conn.prepareStatement(query);

            int resultSet = statement.executeUpdate();
            System.out.println("RESULT UPDATED = " + resultSet);
        } catch (SQLException e) {

            throw new SQLException();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        DBInfo1.closeConection(conn);

    }

    /**
     * Select and display the category title of all top parent categories sorted
     * alphabetically and the count of their child categories.
     * 
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public static void categorySort() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        final String query;
        query = "SELECT a.parent_name AS'Top_Category', COUNT(b.category_id) AS 'Category_Count' "
                + "FROM parent_category a " + "INNER JOIN  parent_category b " + "ON a.parent_id = b.category_id "
                +" where b.parent_id=0 "
                + "GROUP BY (b.category_id) " + "ORDER BY a.parent_name";

        System.out.println(query);
        try {

            con = DBInfo1.getConn();
            ps = con.prepareStatement(query);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                Category category = new Category();
                category.setCountCategory(resultSet.getInt("Category_Count"));
                category.setName(resultSet.getString("Top_Category"));
                System.out.println(category.toString());

            }
        } catch (SQLException e) {

            throw new SQLException();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        DBInfo1.closeConection(con);
    }
}
