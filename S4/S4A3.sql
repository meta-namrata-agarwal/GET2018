#SESSION 4 ASSIGNMENT 3

/*Identify the columns require indexing in order, product, category tables and create indexes.
*/
USE storefront1;
ALTER TABLE order_placed add INDEX orderPlacedIndexDate (Date_of_order);

ALTER TABLE order_details ADD INDEX orderDetailsStaus (Order_status);

ALTER TABLE product ADD INDEX productIdIndex (Product_id);

ALTER TABLE product_category ADD INDEX cateogoryProductIdIndex(Product_id);

