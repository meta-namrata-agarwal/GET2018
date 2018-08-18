use storefront;

#SESSION 3 ASSIGNMENT 3
/* 1. Display Shopper’s information along with number of orders he/she placed during last 30 days*/

SELECT user.User_id,user.First_name,user.Mobile,user.Email ,count(order_placed.Order_id) as order_count
FROM User
join order_placed
on order_placed.User_id=user.User_id
where DATEDIFF(now(),order_placed.Date_of_order)<=30
group by user.User_id

/* 2. Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/

SELECT USER.User_id,USER.First_name,REVENUE
FROM(
SELECT SUM(order_placed.Bill_amount) AS REVENUE,order_placed.Date_of_order AS ORDER_DATE, order_placed.User_id AS USER,order_placed.Order_id AS ID 
FROM order_placed
WHERE DATEDIFF(now(),order_placed.Date_of_order)<=30
GROUP BY order_placed.User_id
ORDER BY REVENUE DESC
LIMIT 5)R
LEFT JOIN USER
ON USER.User_id=R.USER

/* 3. Display top 20 Products which are ordered most in last 60 days along with numbers.*/

SELECT product.Product_id,product.Name,order_placed.Date_of_order AS ORDER_DATE, COUNT(product.Product_id) AS COUNT
FROM product
JOIN order_details
ON order_details.Product_id=PRODUCT.Product_id  
JOIN order_placed
ON order_details.Order_id=order_placed.ORDER_ID
WHERE DATEDIFF(now(),order_placed.Date_of_order)<=60
GROUP BY product.Product_id
ORDER BY COUNT DESC
LIMIT 5

/* 4. Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/

SELECT DATE_FORMAT(order_placed.Date_of_order,"%M-%Y") AS MONTH ,SUM(order_placed.Bill_amount) AS MONTHLY_SALE
FROM order_placed
WHERE DATEDIFF(now(),order_placed.Date_of_order)<=180
GROUP BY DATE_FORMAT(order_placed.Date_of_order,"%M-%Y")
ORDER BY order_placed.Date_of_order DESC

/* 5. */


/* 6. Given a category search keyword, display all the Products present in this category/categories. */

SELECT PRODUCT.Name, product.Product_id, parent_category.Category_name
FROM product
JOIN product_category
ON product_category.Product_id=product.Product_id
JOIN parent_category
ON parent_category.Category_id=product_category.Category_id
WHERE parent_category.Category_name="ACCESSORIES"

/*7. Display top 10 Items which were cancelled most.*/

SELECT PRODUCT.Name, product.Product_id, COUNT(product.Product_id) AS COUNT
FROM product
JOIN order_details
ON order_details.Product_id=product.Product_id
WHERE order_details.Order_status="CANCELLED"
GROUP BY product.Product_id
LIMIT 4