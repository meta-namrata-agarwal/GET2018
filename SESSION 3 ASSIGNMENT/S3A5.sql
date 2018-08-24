USE storefront;

#SESSION3 ASSIGNMENT 5
/*Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days*/

drop view ORDER_INFO
CREATE VIEW  ORDER_INFO
AS
 SELECT product.Product_id AS 'ID',product.Name AS title,order_details.PRICE AS PRICE, USER.First_name AS 'FIRST NAME', USER.Last_name AS 'LAST NAME', USER.Email AS 'EMAIL',order_placed.Date_of_order AS 'DATE', order_details.Order_status AS 'STATUS'
FROM product
INNER JOIN order_details
ON order_details.Product_id=product.Product_id
INNER JOIN order_placed
ON order_details.Order_id=order_placed.Order_id
INNER JOIN USER
ON USER.User_id=order_placed.User_id
WHERE DATEDIFF(NOW(), order_placed.Date_of_order)<60
ORDER BY order_placed.Date_of_order;


SELECT * FROM ORDER_INFO;

/* 2. Use the above view to display the Products(Items) which are in ‘shipped’ state.
*/

SELECT ID , TITLE FROM ORDER_INFO
WHERE STATUS="shipped";

/* 3. Use the above view to display the top 5 most selling products.*/

SELECT Id , Title ,COUNT(Id) FROM Order_info
GROUP BY Id
ORDER BY COUNT(Id) DESC
LIMIT 5;

