CREATE DATABASE ShoppingDB;

USE ShoppingDB;

CREATE TABLE Product(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(90),
price DOUBLE,
imageUrl VARCHAR(256)
);

INSERT INTO Product(name,price,imageUrl)
VALUES("Reebok Jacket",1999.00,"../assets/productImages/1.jpg"),
("Reebok Shoes",2999.00,"../assets/productImages/2.jpg"),
("Adidas Lower",1299.00,"../assets/productImages/3.jpg"),
("Puma Shoes",2999.00,"../assets/productImages/4.jpg"),
("TagHeuer Watch",11999.00,"../assets/productImages/5.jpg"),
("JackNJones Tee",899.00,"../assets/productImages/6.jpg"),
("Mufti Shirt",999.00,"../assets/productImages/7.jpg"),
("Safari Bagpack",1099.00,"../assets/productImages/8.jpg");


