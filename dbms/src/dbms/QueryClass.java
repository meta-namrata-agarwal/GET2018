package dbms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class QueryClass {

    // SESSION 5 Assignment 1
    /**
     * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
     * that user which are in shipped state. Orders should be sorted by order
     * date column in chronological order.
     */
    public void orderDetailsByUserId(int userID) {

        System.out.println("123");
        final String query;
        query = "SELECT  OP.Order_id,OP.Date_of_order,"
                + "  SUM(OD.QUANTITY*OD.PRICE) as price " + "FROM PRODUCT P"
                + " LEFT JOIN order_details OD"
                + " ON OD.Product_id=P.Product_id"
                + " LEFT JOIN order_placed OP" + " ON OP.Order_id=OD.Order_id"
                + " LEFT JOIN USER" + " ON USER.User_id=OP.User_id"
                + " WHERE  user.user_id=? AND OD.Order_status=\"SHIPPED\""
                + " GROUP BY OD.Product_id, OD.Order_id"
                + " ORDER BY OP.Date_of_order DESC";

        try (Connection con = DBInfo1.getConn();
                PreparedStatement ps = con.prepareStatement(query);) {

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

            e.printStackTrace();
        }

    }

    // ASSIGNMENT 2
    /**
     * Insert five or more images of a product using batch insert technique.
     * */

    public void batchInsertImage(List<Image> listImage) {

        final String query;
        query = "INSERT INTO product_image(Product_id,Image_id,Image) VALUES(?,?,?)";

        try (

        Connection conn = DBInfo1.getConn();

        PreparedStatement statement = conn.prepareStatement(query);) {
            try {
                conn.setAutoCommit(false);
                System.out.println("The SQL query is: " + query); // Echo For
                // debugging
                System.out.println();

                for (int i = 0; i < listImage.size(); i++) {

                    statement.setInt(1, listImage.get(i).getProductId());
                    statement.setInt(2, listImage.get(i).getImageId());
                    statement.setString(3, listImage.get(i).getBlobImage());
                    statement.addBatch();
                }
                int result[] = statement.executeBatch();
                System.out.println("The number of rows inserted: "
                        + result.length);
                conn.commit();
                System.out.println();

            } catch (SQLException ex) {
                ex.printStackTrace();
                conn.rollback();
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // aSSIGNMENT 3
    /**
     * Delete all those products which were not ordered by any Shopper in last 1
     * year. Return the number of products deleted.
     */

    public void deleteProductsNotOrderedInYear() {
        final String query;

        query = "UPDATE PRODUCT P"
                + " INNER JOIN ORDER_deTAILS O"
                + " ON P.Product_id=O.Product_id"
                + " INNER JOIN order_placed OP"
                + " ON OP.Order_id=O.Order_id"
                + " SET ISACTIVE=0"
                + " WHERE  ISACTIVE = 1 AND DATEDIFF(NOW(), OP.Date_of_order)>365";

        try (Connection con = DBInfo1.getConn();
                PreparedStatement ps = con.prepareStatement(query);) {

            int resultSet = ps.executeUpdate();
            System.out.println("RESULT UPDATED = "+resultSet);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}