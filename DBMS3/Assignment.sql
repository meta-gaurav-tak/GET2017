
-- ################### Assignment 1 ################### ----

-- QUERY 1 --

-- supporting query for query 1 --
-- query to add a book which is issued 4 months back and not yet returned --
INSERT INTO book_issue 
(issue_date, accession_no, member_id) VALUES ('2017-05-05 16:22:11', 8001, 101);

/* 
Write a command to display information on books issued for more than two months. 
The information should include member_nm, member id, title nm, accession no, issue_dt, due_dt, 
and issued for how many months and be sorted on member_nm, and within member_nm on title_nm. 
*/

SELECT Members.member_id,Members.member_name, Titles.title_name, 
Book_issue.accession_no,Book_issue.issue_date,
Book_issue.due_date,DATEDIFF(NOW(), book_issue.issue_date)/30 AS IssuedFor
FROM book_issue 
LEFT JOIN book_return ON
book_issue.accession_no = book_return.accession_no AND
book_issue.member_id = book_return.member_id AND
book_issue.issue_date = book_return.issue_date
INNER JOIN Members ON 
book_issue.member_id = Members.member_id
INNER JOIN Books ON
book_issue.accession_no = books.accession_no
INNER JOIN Titles On
Books.title_id = Titles.title_id
WHERE book_return.return_date IS NULL AND DATEDIFF(NOW(), book_issue.issue_date) > 60
ORDER BY MEmbers.member_name, Titles.title_name;

-- Query 2 --

/*
Write a command to display those rows from members table having maximum 
length for member name. Information should contain member_nm and length of 
member_nm. 
*/

Select member_name,LENGTH(member_name) 
FROM Members where LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM Members);

-- Query 3 --

/*
Write a command to display count of number of books issued so far. 
*/

SELECT COUNT(*) FROM book_issue;


--  ################# Assignment 2 ################### -----

-- Query 1 --

/*
Write a command to display subjectwise information on number of books purchased. 
The information should include subject_nm,subject_id,number of books purchased. 
*/

SELECT COUNT(Books.accession_no), Subjects.subject_name, Books.purchase_date FROM Subjects 
LEFT JOIN Titles 
ON Subjects.subject_id = Titles.subject_id
LEFT JOIN Books 
ON Books.title_id = Titles.title_id where Books.purchase_date IS NOT NULL
GROUP BY Subjects.subject_id ;

-- Query 2 --

/*
Write a command to display those rows from the book_issue table where a book can be returned after two months. 
That is, the difference in due_dt and issue_dt is greater than two months. 
*/

SELECT * FROM Book_issue WHERE DATEDIFF(due_date, issue_date) > 60;

-- Query 3 --
/*
Write a SELECT command to display the list of books 
having price greater than the minimum price of books purchased so far.
*/

SELECT * FROM Books WHERE price > (SELECT MIN(price) FROM Books);


-- ##################### Assignment 3 ######################## ---

-- Query 1 --

/* 
Write a SELECT command to display total number. of students,
total number of faculty and total number of others in library information system in a single row. 
*/

/*SELECT sum(count_m)  from (SELECT Count(member_id) as count_m FROM Members 
GROUP BY category HAVING CATEGORY not in ('F','S') ) as x;*/

-- as rows --
SELECT COUNT(category) as total_number,category
from members
Group by category NOT in ('F','S')  , category in ('F'), category in ('S');

-- as column --
SELECT 
COUNT(if(category = 'F', category, null)) AS FACULTY,
COUNT(if(category = 'S', category, null)) AS STUDENTS,
COUNT(if(category <> 'F' && category <> 'S'  , category, null)) AS OTHERS
FROM Members;

-- Query 2 --

/* 
Display the information of those titles that have been issued more than 2 times.  
*/

SELECT COUNT(bi.accession_no), t.title_name FROM book_issue as bi
LEFT JOIN Books as b ON
bi.accession_no = b.accession_no
LEFT JOIN titles as t ON
b.title_id = t.title_id
GROUP BY t.title_id Having COUNT(bi.accession_no) > 2;
 

-- Query 3--

/*
Write a command to display information on books issued to members of category other than "F" (Faculty). 
*/

SELECT book_issue.issue_date,book_issue.due_date,book_issue.accession_no,Members.member_name,Members.category 
FROM book_issue
INNER JOIN members ON
book_issue.member_id = Members.member_id
WHERE Members.category <> ("F");

-- Query 4 --

/*
Write a command to display information on those authors for which at least one book has been purchased. 
*/

/* required to demonstrate query 4 results correctness*/
-- entry for a book which is not yet purchased --
INSERT INTO books (accession_no, status, price, title_id) VALUES (8021, 'A', 1000, 502);

SELECT DISTINCT(authors.author_id), authors.author_name FROM Books
INNER JOIN title_author ON
Books.title_id = title_author.title_id
INNER JOIN authors ON
authors.author_id = title_author.author_id
WHERE Books.purchase_date IS NOT NULL;



