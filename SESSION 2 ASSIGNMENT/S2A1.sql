/*SESSION 2 Assignment 1
 1. Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments. 
(Write all CREATE commands in a SQL file and run that SQL File).
*/
CREATE DATABASE storefront;  #database created

USE storefront;

create table Product(
Product_id  int not null AUTO_INCREMENT PRIMARY KEY,
Name varchar(60) not null,
Stock INT UNSIGNED NOT NULL,
Price float not null,
Date_stock_added date,
Description varchar(100)
);


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
Usertype ENUM("ADMIN","USER"),
First_name VARCHAR(50) NOT NULL,
Last_name  VARCHAR(50) NOT NULL,
INDEX User_name ( First_name, Last_name),
Email VARCHAR(30) NOT NULL UNIQUE,
Mobile INT(10) NOT NULL,
Password VARCHAR(30) NOT NULL UNIQUE ,
Registration_date Date NOT NULL,
PRIMARY KEY(User_id)
);

CREATE TABLE Order_placed(
User_id  INT NOT NULL,
Order_id INT NOT NULL unique AUTO_INCREMENT,
Date_of_order DATE NOT NULL,
Bill_amount DOUBLE NOT NULL,
Address  VARCHAR(150) NOT NULL,
PRIMARY KEY(Order_id),
FOREIGN KEY(User_id) REFERENCES user(User_id)
);

CREATE TABLE Order_details(
Order_id INT ,
Product_id INT NOT NULL,
QUANTITY INT NOT NULL,
PRICE FLOAT NOT NULL,
Order_status ENUM("SHIPPED","RETURNED","CANCELLED","PLACED") NOT NULL,
FOREIGN KEY(ORDER_ID) REFERENCES ORDER_PLACED(ORDER_ID),
FOREIGN KEY(Product_id) REFERENCES Product(Product_id)
);
DROP TABLE Order_details

CREATE TABLE user_address(
User_id INT NOT NULL UNIQUE,
Plot_no varchar(10),
Street varchar(20),
City varchar(20),
State varchar(20),
Pin_code varchar(10),
FOREIGN KEY(User_id) REFERENCES user(User_id)
);


/*
2. Write a command to display all the table names present in StoreFront.
*/

SHOW TABLES;

/*
 3. Write a command to remove Product table of the StoreFront database.
*/

SET FOREIGN_KEY_CHECKS=0; DROP TABLE product;

/*
 4. Create the Product table again.
*/


SET FOREIGN_KEY_CHECKS=1; create table Product(
Product_id  int not null AUTO_INCREMENT PRIMARY KEY,
Name varchar(60) not null,
Stock INT UNSIGNED NOT NULL,
Price float not null,
Date_stock_added date,
Description varchar(100)
);


ALTER TABLE Parent_Category
DROP COLUMN Serial_no;

ALTER TABLE PRODUCT_CATEGORY
DROP COLUMN Category_name;


