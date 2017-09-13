use library_information_db;

SELECT titles.title_name
from authors 
inner join title_author 
on authors.author_id = title_author.author_id  
inner join titles 
on titles.title_id = title_author.title_id
where author_name = "JK Rowling"; 


Select member_id from Members where member_name = "RAJARAM" limit 1;

SELECT Books.accession_no FROM Titles 
INNER JOIN Books 
on Books.title_id = titles.title_id 
where title_name = "Harry Po" AND Books.status = 'A' limit 1; 


SELECT * from books 
where books.accession_no not in 
(
    SELECT book_issue.accession_no
    from book_issue 
    where DATEDIFF(NOW(),book_issue.issue_date) < 366 
);

INSERT into  books(accession_no,status,purchase_date,price,title_id)
values(8010,'U','2009-01-12',800,505);
INSERT into  books(accession_no,status,price,title_id)
values(8021,'A',1000,502);

DROP Trigger Due_Date_Trigger;

DELIMITER $$
CREATE TRIGGER Due_Date_Trigger 
BEFORE INSERT ON Book_issue  
FOR EACH ROW 
BEGIN   
        IF((select books.status from books where books.accession_no = New.accession_no) <> 'A' ) THEN 
        SET New.accession_no = null;
        ELSE
        SET New.due_date = DATE_ADD(NEW.issue_date , INTERVAl 15 DAY);
        END IF;
END;
$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER Book_Availability_Trigger 
AFTER INSERT ON Book_issue  
FOR EACH ROW 
BEGIN
        UPDATE  Books SET status='U' where Books.accession_no = New.accession_no; 
END;
$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER Book_Availability_Return_Trigger 
AFTER INSERT ON Book_return  
FOR EACH ROW 
BEGIN
        UPDATE  Books SET status='A' where Books.accession_no = New.accession_no; 
END;
$$
DELIMITER ;


INSERT INTO book_issue(accession_no,member_id) values (8002,108);