-- ################## Assignment 1 ################# --
-- Query 1 --

/* 
Write a SELECT command to display name of those members
who belong to the category as to which member
“Jon Snow” belongs.
Note: Solve the problem using subquery.
*/

SELECT member_name,category FROM Members where category = (
    SELECT category FROM Members where member_name = "Gaurav Tak"
    );


-- Query 2 --

/*
Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery.
*/

SELECT T.title_name, M.member_name,BI.issue_date,BI.due_date FROM Book_issue as BI 
LEFT JOIN MEMBERS as M
ON M.member_id = BI.member_id 
NATURAL JOIN BOOKS 
NATURAL JOIN Titles as T
where not exists (
    SELECT * FROM Book_return as BR where 
    BI.accession_no = BR.accession_no AND BI.issue_date = BR.issue_date AND BI.member_id = BR.member_id 
);

-- Query 3 --

/*
Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.
*/

SELECT T.title_name, M.member_name,BI.issue_date,BI.due_date, BI.accession_no 
FROM Book_issue as BI 
LEFT JOIN MEMBERS as M
ON M.member_id = BI.member_id 
NATURAL JOIN BOOKS 
NATURAL JOIN Titles as T where exists (
    SELECT * FROM Book_return as BR 
    where BR.return_date > BI.due_date 
    AND BR.issue_date = BI.issue_date 
    AND BR.member_id = BI.member_id
    AND BR.accession_no = BR.accession_no
);


-- Query 4 --

/*
Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchased so far.

*/
SELECT * FROM Books WHERE price = (SELECT max(price) from Books where purchase_date is not null);

-- Query 5 --

/*
Write a SELECT command to display the second maximum price
of a book.
*/

SELECT max(price) as SECOND_MAX_PRICE FROM BOOKS WHERE price <> ( SELECT max(price) from Books );


-- ############################## Assignment 2 ###############################---

-- Query 1 --

/*
Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/

CREATE VIEW  Member_Issue_Detail AS
SELECT member_name, accession_no, issue_date, due_date 
FROM Book_issue JOIN Members
ON Members.member_id = book_issue.member_id; 

SELECT * FROM Member_Issue_Detail;


-- Query 2 --

/*
Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O

*/

CREATE VIEW Category_WISE_MEMBER AS
SELECT 
    member_name,member_id, CASE category WHEN "F" THEN "Faculty" WHEN "S" THEN "Students" ELSE "Others" END
FROM Members;

SELECT * FROM Category_WISE_MEMBER;


-- Query 3 --
 
 /*
Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date.
 */

CREATE VIEW BOOKS_INFO AS
SELECT subject_name,title_name,BI.accession_no,M.member_name,category, BI.issue_date, due_date,return_date 
FROM Subjects as S 
INNER JOIN Titles as T
ON S.subject_id = T.subject_id
INNER JOIN Books as B
ON T.title_id = B.title_id
INNER JOIN Book_issue as BI
ON B.accession_no = BI.accession_no
LEFT JOIN Book_return as BR 
ON BI.accession_no = BR.accession_no AND BI.issue_date = BR.issue_date AND BI.member_id = BR.member_id
INNER JOIN Members as M 
ON M.member_id = BI.member_id;

SELECT * FROM BOOKS_INFO;