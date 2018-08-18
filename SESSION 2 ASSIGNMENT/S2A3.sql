/*SESSION 2 ASSIGNMENT 3*/

/* 1. Display Recent 50 Orders placed (Id, Order Date, Order Total).*/
use storefront;
SELECT ORDER_PLACED.ORDER_ID, ORDER_PLACED.DATE_OF_ORDER, ORDER_PLACED.BILL_AMOUNT
FROM ORDER_PLACED ORDER BY DATE_OF_ORDER DESC LIMIT 2;

/* 2. Display 10 most expensive Orders.*/

SELECT ORDER_PLACED.ORDER_ID,ORDER_PLACED.BILL_AMOUNT FROM ORDER_PLACED
ORDER BY ORDER_PLACED.BILL_AMOUNT DESC 
LIMIT 3;

/* 3. Display all the Orders which are placed more than 10 days old 
and one or more items from those orders are still not shipped.*/

SELECT order_placed.Date_of_order,order_placed.Order_id,Order_details.Product_id,product.Name,Order_details.Order_status
FROM PRODUCT
LEFT JOIN Order_details
ON Order_details.Product_id=product.Product_id
LEFT JOIN order_placed
ON order_placed.Order_id=Order_details.Order_id
WHERE Order_details.Order_status="PLACED" AND order_placed.Date_of_order<DATE_SUB(now(), INTERVAL 10 DAY)

/* 4.Display list of shoppers which haven't ordered anything since last month.*/

/* 5. Display list of shopper along with orders placed by them in last 15 days. */

SELECT U.FIRST_NAME,P.NAME, O.DATE_OF_ORDER
FROM USER U
LEFT JOIN ORDER_PLACED O
ON O.USER_ID=U.USER_ID
LEFT JOIN ORDER_DETAILS OD
ON OD.ORDER_ID=O.ORDER_ID
LEFT JOIN PRODUCT P
ON OD.PRODUCT_ID=P.PRODUCT_ID
WHERE O.DATE_OF_ORDER >DATE_SUB(now(), INTERVAL 15 DAY) ;

/* 6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 8))*/

SELECT P.NAME,OD.QUANTITY, OD.ORDER_ID
FROM PRODUCT P
LEFT JOIN ORDER_DETAILS OD
ON P.PRODUCT_ID=OD.Product_id
WHERE OD.ORDER_STATUS ="SHIPPED" AND OD.Order_id=8;

/* 7. Display list of order items along with order placed date which fall between Rs 50 to Rs 250 price.*/

SELECT P.NAME, OP.DATE_OF_ORDER
FROM PRODUCT P
LEFT JOIN order_details OD
ON OD.Product_id=P.Product_id
LEFT JOIN order_placed OP
ON OD.Order_id=OP.Order_id
WHERE OD.PRICE>200 AND OD.PRICE<400;

/* 8. Update first 20 Order items status to “Shipped” which are placed today.*/
#WRONG


UPDATE  ORDER_DETAILS O
LEFT JOIN ORDER_PLACED OP
ON OP.ORDER_ID=O.ORDER_ID
SET O.ORDER_STATUS="SHPPED"
WHERE OP.DATE_OF_ORDER ='2018-8-17'
LIMIT 3;
