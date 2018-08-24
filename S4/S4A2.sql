#SESSION 4 ASSIGNMENT 2

/*1. Create a Stored procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to function.*/
DROP PROCEDURE IF EXISTS monthlySales;
DROP PROCEDURE IF EXISTS orderDetailStatus;

DELIMITER $$
CREATE PROCEDURE monthlySales(inputYear INT, inputMonth INT)
BEGIN
SELECT SUM(order_details.QUANTITY*order_details.PRICE) AS SUM, SUM( order_details.QUANTITY) , MONTH(order_placed.Date_of_order),
order_details.Product_id 
FROM order_details
LEFT JOIN order_placed
ON order_placed.Order_id=order_details.Order_id
WHERE year(order_placed.Date_of_order)  IN (inputYear) AND MONTH(order_placed.Date_of_order)  IN (inputMonth) AND order_details.Order_status="SHIPPED"
GROUP BY  order_details.Product_id;
END$$

CALL monthlySales(2018,8);

/* 2. Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. 
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date*/

DELIMITER $
CREATE PROCEDURE orderDetailStatus( in startdate DATE,in  endDate DATE)
BEGIN 
 IF(startdate > endDate)
 THEN
 SET startdate=endDate-INTERVAL DAY(endDate) DAY;
 END IF;

    SELECT order_details.Order_id,user.First_name,user.Last_name order_details, product.Name, 
        SUM(order_details.QUANTITY*order_details.PRICE) AS SUM, order_placed.Address
        FROM product
        LEFT JOIN order_details
        ON order_details.Product_id=product.Product_id
        LEFT JOIN order_placed
        ON order_placed.Order_id=order_details.Order_id
        LEFT JOIN USER
        ON user.User_id=order_placed.User_id
        WHERE order_placed.Date_of_order BETWEEN startdate AND endDate
        GROUP  by user.User_id
        ORDER BY user.First_name;
END $

CALL  orderDetailStatus('2018-9-1','2018-8-20');