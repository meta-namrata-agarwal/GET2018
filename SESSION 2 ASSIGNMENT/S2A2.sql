
/*SESSION 2 ASSIGNMENT 2
1. Insert sample data in StoreFront tables by using SQL files.*/
use storefront;

INSERT INTO Product (Product_id,Name,Stock,Price,Date_stock_added,Description)
    values
	   (1,'Earphones',5,350.0,'2017-01-01','bluetooth earhones'),
           (2,'Watch',13,2000.0,'2018-01-23','titan watch 1 year warranty'),
           (3,'Mobile cover',4,250.0,'2018-4-7','samsung galaxy s7'),
           (4,'Travelling bag',10,1570.0,'2018-3-12','bag with wheels'),
           (5,'Toy car',12,350.0,'2018-2-19','blue colour'),
           (6,'Toy bike',6,400.0,'2018-1-12','black colour'),
           (7,'Helmet',11,350.0,'2018-01-30','female helmet'),
           (8,'T-shirt',10,700.0,'2018-07-01','female polo T-shirt'),
           (9,'Bottle',11,500.0,'2018-01-21','milton'),
           (10,'Data cable',33,250.0,'2018-05-01','lenovo'),
	   (11,'SAMSUNG',30,15000,'2018-1-12','INFINITY J7 HD DISPLAY DUAL CAMERA');
       
UPDATE Product
SET Stock=Stock+40;

INSERT INTO Parent_Category(Category_id, Category_name,Parent_id,Parent_name)
VALUES
(1,'ELECTRONICS',0,'ELECTRONICS'),
(2,'ACCESSORIES',1,'ELECTRONICS'),
(3,'MOBILE CASE',2,'ACCESSORIES'),
(4,'SAMSUNG',20,'MOBILE'),
(5,'WATCH',0,'WATCH'),
(6,'FEMALE WATCH',5,'WATCH'),
(7,'FASTRACK',5,'WATCH'),
(8,'BAG',0,'BAG'),
(9,'TROLLEY',8,'BAG'),
(10,'TOY',0,'TOY'),
(11,'TOY BOYS',10,'TOY'),
(12,'TOY CAR',11,'TOY BOYS'),
(13,'HEAD GEAR',0,'HEAD GEAR'),
(14,'FASHION',0,'FASHION'),
(15,'WOMEN FASHION',14,'FASHION'),
(16,'MEN FASHION',14,'FASHION'),
(17,'TEES',15,' WOMEN FASHION'),
(18,'MILTON',0,'MILTON'),
(19,'BOTTLE',18,'MILTON'),
(20,'MOBILE',1,'ELECTRONICS');


INSERT INTO  PRODUCT_CATEGORY(Serial_no, Product_id, Category_id)
	VALUES
	(1,1,2),
	(2,2,6),
	(3,3,3),
	(4,4,9),
	(5,5,12),
	(6,6,11),
	(7,7,13),
	(8,8,17),
	(9,9,2),
	(10,10,2),
	(11,11,20);
    
INSERT INTO PRODUCT_IMAGE(Product_id,Image_id,Image)
VALUES
(5,1,'CAR.JPG'),
(5,2,'CAR1.JPG'),
(1,3,'EARPHN.JPG'),
(1,4,'EARPHONE.JPG'),
(7,5,'HELMET.JPG');


SELECT PRODUCT.NAME, PRODUCT.PRODUCT_ID,ORDER_DETAILS.ORDER_ID
FROM PRODUCT
LEFT JOIN ORDER_DETAILS
ON PRODUCT.PRODUCT_ID=ORDER_DETAILS.PRODUCT_ID
ORDER BY ORDER_DETAILS.PRODUCT_ID DESC;


INSERT INTO ORDER_PLACED(USER_ID,ORDER_ID,DATE_OF_ORDER,BILL_AMOUNT,ADDRESS)
VALUES
(9,8,'2018-8-8',17350,'JAIPUR'),
(1,1,'2018-6-8',17350,'JAIPUR'),
(8,2,'2018-1-4',600,'DELHI'),
(4,5,'2018-7-9',950,'JAIPUR'),
(6,6,'2018-6-9',1050,'DELHI'),
(1,7,'2018-4-8',1233,'DELHI');

INSERT INTO ORDER_PLACED(USER_ID,ORDER_ID,DATE_OF_ORDER,BILL_AMOUNT,ADDRESS)
VALUES
(19,18,CURDATE(),1750,'JAIPUR'),
(11,11,CURDATE(),1350,'KANPUR'),
(13,12,CURDATE(),6000,'KOLKATA'),
(14,15,CURDATE(),950,'JAIPUR'),
(6,16,CURDATE(),150,'MUMBAI'),
(11,17,CURDATE(),133,'DELHI');


INSERT INTO Order_details(order_id,product_id,QUANTITY,ORDER_STATUS,PRICE)
VALUES
(8,2,1,4,2000),(8,10,1,2,250),
(1,1,3,2,350),(1,2,1,3,2000),(1,11,3,2,15000),
(2,3,3,4,250),(2,1,1,1,350),(5,3,3,1,250),(5,5,2,3,350),(5,7,1,4,350),(6,3,3,1,250),(6,8,1,1,700),(7,8,1,2,700),
(18,4,2,4,1570),(18,6,2,4,400),(11,1,2,4,350),(11,5,2,4,350),(12,4,1,4,1570),(15,11,1,4,15000),(16,8,2,4,700),
(17,1,1,4,350);

SELECT * FROM user
LOAD DATA  INFILE 'C://Users//Admin//Downloads//userdata.txt' INTO TABLE user;

DROP TABLE Order_details

/* 2. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.*/

SELECT Product.name, Product.Product_id, Product.Price, PRODUCT_CATEGORY.Category_id, Parent_Category.Category_name, Parent_Category.Parent_name,Product.Date_stock_added
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
ORDER BY Product.Date_stock_added DESC
LIMIT 5;

/* 3. Display the list of products which don't have any images.*/
SELECT Product.Name 
FROM Product
LEFT JOIN PRODUCT_IMAGE
ON Product.Product_id=PRODUCT_IMAGE.Product_id 
WHERE PRODUCT_IMAGE.Image IS   NULL;

/* 4. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/

SELECT P.CATEGORY_ID,P.PARENT_NAME,P.CATEGORY_NAME
FROM PARENT_CATEGORY P
INNER JOIN PARENT_CATEGORY P1
ON P.CATEGORY_ID=P1.PARENT_ID
ORDER BY P1.PARENT_ID;

/* 5. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)*/

SELECT Product.Name, Product.Product_id, Parent_Category.Parent_name, Parent_Category.Category_name
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
WHERE Parent_Category.Parent_id =0;

/* 6. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)*/

SELECT Product.Name,Product.Product_id,Product.Description,Product.Price
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
WHERE Parent_Category.Category_name='MOBILE';

/* 7. Display the list of Products whose Quantity on hand (Inventory) is under 50.*/

SELECT Product.Name FROM Product
WHERE Stock<50;

/* 8. Increase the Inventory of all the products by 100.*/

UPDATE Product SET Stock=Stock+100;