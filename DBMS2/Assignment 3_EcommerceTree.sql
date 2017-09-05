CREATE DATABASE e_commerce;
USE e_commerce;

CREATE TABLE e_commerce(
 serial_no int NOT NULL PRIMARY KEY AUTO_INCREMENT,
 category varchar(45),
 parent_serial_no int,
 CONSTRAINT fk_ser FOREIGN KEY(parent_serial_no) REFERENCES e_commerce(serial_no)
 );
 
 INSERT into e_commerce(category) 
    VALUES ("Mobiles & Tablets");
    
 
 INSERT into e_commerce(category) 
    VALUES ("Computers");

 
 INSERT into e_commerce(category) 
    VALUES ("Home Appliances");


 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Mobiles",1);
    
 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Tablets",1);

 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Accessories",1);


 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Cases & Covers",1);
    
 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Desktop",2);

 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Laptop",2);

 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Laptop Accessories",2);

 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Printers",2);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("TV",3);

 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Air Conditioner",3);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Washing Machine",3);

 
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Smart Phones",4);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Featured Phones",4);
    

 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("2G",5);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("3G",5);
    

 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Keyboard",10);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Mouse",10);
    
INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Headphones",10);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Inkjet",11);

INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Laser",11);
    
INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("LED",12);

INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("LCD",12);
    
 INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Plasma",12);

INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Full Automatic",14);
    
INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Semi Automatic",14);
    

INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Top Load",27);
    
INSERT into e_commerce(category,parent_serial_no) 
    VALUES ("Front Load",27);
    
-- records are sorted in alphabetic order of parent category --
SELECT e.category, IFNULL(m.category,"TOP CATEGORY") as Parent_Category FROM e_commerce as e
LEFT JOIN e_commerce as m ON
e.parent_serial_no = m.serial_no ORDER BY m.category;    
    

/* records for each parent category are sorted in alphabetic order of category 
   maintaining the parent category order on basis of its level */

SELECT e.category, IFNULL(m.category,"TOP CATEGORY") as Parent_Category FROM e_commerce as e
LEFT JOIN e_commerce as m ON
e.parent_serial_no = m.serial_no ORDER BY m.serial_no,e.category;

SELECT e.category, IFNULL(m.category,"TOP CATEGORY") as Parent_Category FROM e_commerce as e
LEFT JOIN e_commerce as m ON
e.parent_serial_no = m.serial_no where m.category is null;
