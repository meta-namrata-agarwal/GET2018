

#SESSION 3 ASSIGNMENT 4

/*Consider a form where providing a Zip Code populates associated City and
State. 
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

CREATE DATABASE IF NOT EXISTS FormData;

USE FormData;

CREATE TABLE IF NOT EXISTS STATE (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS city (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    state_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(state_id) REFERENCES state(id)
);

CREATE TABLE IF NOT EXISTS zipcode (
    zip VARCHAR(20) NOT NULL,
    city_id INT NOT NULL,
    PRIMARY KEY(zip),
    FOREIGN KEY(city_id) REFERENCES city(id)
);

LOAD DATA  INFILE 'C://Users//Admin//Desktop//SESSION 3 ASSIGNMENT//STATE.txt' INTO TABLE STATE(NAME);
LOAD DATA  INFILE 'C://Users//Admin//Desktop//SESSION 3 ASSIGNMENT//CITY.txt' INTO TABLE CITY(NAME, STATE_ID);
LOAD DATA  INFILE 'C://Users//Admin//Desktop//SESSION 3 ASSIGNMENT//ZIP.txt' INTO TABLE ZIPCODE(ZIP, CITY_ID);

SELECT * FROM CITY

SELECT STATE.NAME AS STATE,CITY.NAME AS CITY,ZIPCODE.ZIP
FROM STATE
LEFT JOIN CITY
ON CITY.STATE_ID=STATE.ID
LEFT JOIN ZIPCODE
ON CITY.ID=ZIPCODE.CITY_ID
ORDER BY STATE.NAME, CITY.NAME
