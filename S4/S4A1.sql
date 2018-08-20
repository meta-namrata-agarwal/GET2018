#SESSION 4 ASSIGNMENT 1

USE STOREFRONT1;
/* 1. Create a function to calculate number of orders in a month. Month and year will be input parameter to function.*/

DROP FUNCTION IF EXISTS numberOfOrder ;

DROP FUNCTION IF EXISTS monthWithMaximumOrder;
DELIMITER $$
CREATE FUNCTION numberOfOrder(month int, year int) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE orderCount  int;   
    SET orderCount=0;
    SELECT COUNT(*) INTO orderCount FROM order_placed
    WHERE EXTRACT(MONTH FROM Date_of_order)=month AND
            EXTRACT(year FROM Date_of_order)=year;
            
    return orderCount;
END $$
    

SELECT numberOfOrder(8,2018) AS ID;

/* 2. Create a function to return month in a year having maximum orders. Year will be input parameter.*/

DELIMITER $
CREATE FUNCTION monthWithMaximumOrder(yr INT) RETURNS INT  DETERMINISTIC
BEGIN
    DECLARE month INT;
    SELECT  maxCount.maxMonth  INTO month FROM (
    SELECT COUNT(Date_of_order) AS COUNT , MONTH(Date_of_order) as maxMonth FROM order_placed
    WHERE YEAR(Date_of_order) IN (yr)
    GROUP BY MONTH(Date_of_order)
    ) maxCount
    ORDER BY maxCount.count desc
    limit 1;
    RETURN month;

END$
SELECT monthWithMaximumOrder(2018);
