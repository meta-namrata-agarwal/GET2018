package dbms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        QueryClass.orderDetailsByUserId(8);

        Image image1 = new Image(1, 6, "image1.jpg");
        Image image2 = new Image(1, 7, "image2.jpg");
        Image image3 = new Image(2, 8, "image3.jpg");
        Image image4 = new Image(8, 9, "image4.jpg");
        Image image5 = new Image(7, 10, "image5.jpg");
        List<Image> list = new ArrayList<Image>();
        list.add(image1);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);
        QueryClass.batchInsertImage(list);

        QueryClass.deleteProductsNotOrderedInYear();
        QueryClass.categorySort();

    }

}
