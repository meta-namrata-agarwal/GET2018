/*Assignment 1
creation of all the tables of store front*/

CREATE DATABASE storefront  #database created

USE storefront;

create table Product(
Product_id  int not null AUTO_INCREMENT PRIMARY KEY,
Name varchar(60) not null,
Stock INT UNSIGNED NOT NULL,
Price float not null,
Date_stock_added date,
Description varchar(100)
);
DESC Product;

CREATE TABLE PRODUCT_IMAGE(
Product_id INT NOT NULL,
Image_id INT NOT NULL AUTO_INCREMENT,
Image BLOB NOT NULL,
PRIMARY KEY(Image_id),
FOREIGN KEY(Product_id) REFERENCES Product(Product_id)
);



CREATE TABLE Parent_Category(
Serial_no INT NOT NULL ,
Category_id INT NOT NULL,
Category_name VARCHAR(50) NOT NULL,
Parent_id INT NOT NULL,
Parent_name VARCHAR(50) NOT NULL,
PRIMARY KEY(Category_id)
);
CREATE TABLE PRODUCT_CATEGORY(
Serial_no INT NOT NULL AUTO_INCREMENT,
Product_id INT NOT NULL,
Category_id INT NOT NULL,
Category_name VARCHAR(50) NOT NULL,
PRIMARY KEY(serial_no),
FOREIGN KEY(Product_id) REFERENCES Product(Product_id),
FOREIGN KEY(Category_id) REFERENCES Parent_Category(Category_id)
);

ALTER TABLE PRODUCT_CATEGORY
ADD CONSTRAINT FK_PRODUCT
FOREIGN KEY (Product_id) REFERENCES Product(Product_id);

CREATE TABLE user(
User_id INT NOT NULL AUTO_INCREMENT,
Email VARCHAR(30) NOT NULL UNIQUE,
Password VARCHAR(30) NOT NULL UNIQUE,
Usertype ENUM("ADMIN","USER"),
First_name VARCHAR(50) NOT NULL,
Last_name  VARCHAR(50) NOT NULL,
INDEX User_name ( First_name, Last_name),
Registration_date Date NOT NULL,
Mobile INT(10) NOT NULL,
PRIMARY KEY(User_id)
);

CREATE TABLE Order_placed(
User_id  INT NOT NULL,
Order_id INT NOT NULL UNIQUE AUTO_INCREMENT,
Date_of_order DATE NOT NULL,
Bill_amount DOUBLE NOT NULL,
Order_status ENUM("SHIPPED","RETURNED","CANCELLED") NOT NULL,
Address  VARCHAR(150) NOT NULL,
PRIMARY KEY(Order_id),
FOREIGN KEY(User_id) REFERENCES user(User_id)
);

CREATE TABLE Order_details(
Order_id INT NOT NULL UNIQUE,
Product_id INT NOT NULL UNIQUE,
Price FLOAT NOT NULL,
FOREIGN KEY(Order_id) REFERENCES Order_placed(Order_id),
FOREIGN KEY(Product_id) REFERENCES Product(Product_id)
);



CREATE TABLE user_address(
User_id INT NOT NULL UNIQUE,
Plot_no varchar(10),
Street varchar(20),
City varchar(20),
State varchar(20),
Pin_code varchar(10));
FOREIGN KEY(User_id) REFERENCES user(User_id)
);

SHOW TABLES;




/*Assignment 2
insertion of data into tables of store front*/

INSERT INTO Product (Product_id,Name,Stock,Price,Date_stock_added,Description)
           values
	   (1,'Earphones',5,350.0,'2017-01-01','bluetooth earhones'),
           (2,'Watch',13,2000.0,'2018-01-23','titan watch 1 year warranty'),
           (3,'Mobile cover',4,250.0,'2018-4-7','samsung galaxy s7'),
           (4,'Travelling bag',10,1570.0,'2018-3-12','bag with wheels'),
           (5,'Toy car',12,350.0,'2018-2-19','blue colour'),
           (6,'Toy bike',6,400.0,'2-18-1-12','black colour'),
           (7,'Helmet',11,350.0,'2018-01-30','female helmet'),
           (8,'T-shirt',10,700.0,'2018-07-01','female polo T-shirt'),
           (9,'Bottle',11,500.0,'2018-01-21','milton'),
           (10,'Data cable',33,250.0,'2018-05-01','lenovo'),
	   (11,'SAMSUNG',30,15000,'2018-1-12','INFINITY J7 HD DISPLAY DUAL CAMERA');
UPDATE Product
SET Stock=Stock+40;

ALTER TABLE Parent_Category
DROP COLUMN Serial_no;

SELECT * from Product;
INSERT INTO Parent_Category(Category_id, Category_name,Parent_id,Parent_name)
VALUES(2,'ACCESSORIES',1,'ELECTRONICS'),
(3,'MOBILE CASE',2,'ACCESSORIES'),
(4,'SAMSUNG',20,'MOBILE'),
(5,'WATCH',5,'WATCH'),
(6,'FEMALE WATCH',5,'WATCH'),
(7,'FASTRACK',5,'WATCH'),
(8,'BAG',8,'BAG'),
(9,'TROLLEY',8,'BAG'),
(10,'TOY',10,'TOY'),
(11,'TOY BOYS',10,'TOY'),
(12,'TOY CAR',11,'TOY BOYS'),
(13,'HEAD GEAR',13,'HEAD GEAR'),
(14,'FASHION',14,'FASHION'),
(15,'WOMEN FASHION',14,'FASHION'),
(16,'MEN FASHION',14,'FASHION'),
(17,'TEES',15,' WOMEN FASHION'),
(18,'MILTON',18,'MILTON'),
(19,'BOTTLE',18,'MILTON'),
(20,'MOBILE',1,'ELECTRONICS');

ALTER TABLE PRODUCT_CATEGORY
DROP COLUMN Category_name;
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
	11,11,20);


INSERT INTO PRODUCT_IMAGE(Product_id,Image_id,Image)
VALUES(8,1,LOAD_FILE('C://Users//Admin//Desktop//TSHIRT.JPG')),
(8,2,LOAD_FILE('C://Users//Admin//Desktop//TSHIRT.JPG')),
(1,3,LOAD_FILE('C://Users//Admin//Desktop//EARPHONE.JPG')),
(1,4,LOAD_FILE('C://Users//Admin//Desktop//EARPHONE.JPG'));

SELECT * FROM  PRODUCT;


SELECT Product_id ,Name, Price, Date_stock_added
  FROM Product 
ORDER BY Date_stock_added
 DESC
 LIMIT 5;


SELECT Product.name, Product.Product_id, Product.Price, PRODUCT_CATEGORY.Category_id, Parent_Category.Category_name, Parent_Category.Parent_name,Product.Date_stock_added
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
ORDER BY Product.Date_stock_added DESC
LIMIT 5;


SELECT Product.Name 
FROM Product
LEFT JOIN PRODUCT_IMAGE
ON Product.Product_id=PRODUCT_IMAGE.Product_id 
WHERE PRODUCT_IMAGE.Image IS NULL;


SELECT Product.Name, Product.Product_id, Parent_Category.Parent_name, Parent_Category.Category_name
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
WHERE Parent_Category.Parent_id =1;


SELECT Product.Name,Product.Product_id,Product.Description,Product.Price
FROM Product
LEFT JOIN PRODUCT_CATEGORY 
ON Product.Product_id = PRODUCT_CATEGORY.Product_id 
LEFT JOIN Parent_Category
ON PRODUCT_CATEGORY.Category_id = Parent_Category.Category_id  
WHERE Parent_Category.Category_name='MOBILE';


SELECT Product.Name FROM Product
WHERE Stock<50;

UPDATE Product SET Stock=Stock+100;