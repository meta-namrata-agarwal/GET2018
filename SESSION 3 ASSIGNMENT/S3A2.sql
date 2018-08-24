USE storefront;
#SESSION 3 ASSIGNMENT 2
/* 1. Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/

SELECT product.Product_id,product.Name, COUNT_ID.COUNT
FROM(SELECT COUNT(product_category.Product_id) AS COUNT, parent_category.Category_name, product_category.Product_id AS ID
FROM product_category
JOIN parent_category
ON product_category.Category_id=parent_category.Category_id
GROUP BY product_category.Category_id
)COUNT_ID
JOIN product
ON product.Product_id=COUNT_ID.ID
WHERE COUNT_ID.COUNT>1;

/*
 2. Display Count of products as per below price range:
Range in Rs.
Count 0 - 100 101 - 500 Above 500
*/

SELECT  '0 - 100' as 'Range in Rs', COUNT(product.Product_id) AS COUNT 
FROM PRODUCT
WHERE product.Price  BETWEEN 0 AND 100
UNION 
SELECT  '101 - 500' as 'Range in Rs', COUNT(product.Product_id) AS COUNT 
FROM PRODUCT
WHERE product.Price  BETWEEN 101 AND 500
UNION 
SELECT  'ABOVE 500' as 'Range in Rs', COUNT(product.Product_id) AS COUNT 
FROM PRODUCT
WHERE product.Price  >500

/* 3. Display the Categories along with number of products under each category.*/

SELECT parent_category.Category_name, COUNT(product_category.Product_id) AS 'NUMBER OF PRODUCT'
FROM parent_category
JOIN product_category
ON product_category.Category_id=parent_category.Category_id
GROUP BY product_category.Category_id


