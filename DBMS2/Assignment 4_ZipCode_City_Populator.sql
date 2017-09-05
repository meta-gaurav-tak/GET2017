CREATE DATABASE zip_code;
USE zip_code;

CREATE TABLE zip_code (
pin_code int NOT NULL PRIMARY KEY,
city_name varchar(60),
state_name varchar(60)
);

LOAD DATA LOCAL INFILE "E:/SQL assignment2 Updated/DBMS2/pincode_data.csv" 
INTO TABLE zip_code FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\n';

SELECT * from zip_code where pin_code = 307001;
