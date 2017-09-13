package com.metacube.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.metacube.DBUtility.DBConnection;
import com.metacube.Model.Title;
/**
 * Helper class to execute Query and wrap results into desired objects / POJOs
 * @author GAURAV TAK
 *
 */
public class LibraryDataHelper {
    Connection mysql_lib_db;
    PreparedStatement query;
    ResultSet resultSet;
    
    /*
     * Fetch all the books published by author, given the name of the author. 
     * Return the books data (List of Titles)
     */
    public List<Title> titlesByAuthor(String authorName) {
        mysql_lib_db = DBConnection.getConnection();
        if(mysql_lib_db == null) {
            System.out.println("Connection was not established: Problem with DataBase Accesss");
            System.exit(0);
        }
        List<Title> titleList = new LinkedList<Title>();
        try {
            query = mysql_lib_db.prepareStatement("SELECT DISTINCT(titles.title_id),titles.title_name,titles.publisher_id,titles.subject_id "+
                    "from authors "+ 
                    "inner join title_author "+ 
                    "on authors.author_id = title_author.author_id "+  
                    "inner join titles "+
                    "on titles.title_id = title_author.title_id "+
                    "where author_name =?");
            query.setString(1, authorName);
            ResultSet resultSet = query.executeQuery();
            Title titleObject;
            while(resultSet.next()) {
                titleObject = new Title();
                titleObject.setTitleId(resultSet.getInt("title_id"));
                titleObject.setTitleName(resultSet.getString("title_name"));
                titleObject.setPublisherId(resultSet.getInt("publisher_id"));
                titleObject.setSubjectId(resultSet.getInt("subject_id"));
                titleList.add(titleObject);
            }
            query.close();
            resultSet.close();     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                mysql_lib_db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return titleList;
    }
    
    /*
     * Given the name of the book, to be issued by an existing member.
     * Return flag to indicate whether the  the book has been issued or not.
     */
    public boolean isBookIssued(String titleName,String memberName) {
        mysql_lib_db = DBConnection.getConnection();
        if(mysql_lib_db == null) {
            System.out.println("Connection was not established: Problem with DataBase Accesss");
            System.exit(0);
        }
        boolean flag =false;
        try {
            query = mysql_lib_db.prepareStatement("Select member_id from Members where member_name = ? limit 1");
            query.setString(1, memberName);
            resultSet = query.executeQuery();
            if(resultSet.next()) { // required to position the cursor at first row
                int memberID = resultSet.getInt("member_id");
                query = mysql_lib_db.prepareStatement("SELECT Books.accession_no FROM Titles "+
                        "INNER JOIN Books on Books.title_id = titles.title_id where title_name = ? "+
                        "AND Books.status = ? limit 1");
                query.setString(1, titleName);
                query.setString(2, "A");
                resultSet = query.executeQuery();
                if(resultSet.next()) {
                    int accession_no =resultSet.getInt("accession_no");
                    query = mysql_lib_db.prepareStatement("INSERT INTO book_issue(accession_no,member_id) values (?,?)");
                    query.setInt(1,accession_no);
                    query.setInt(2,memberID);
                    int rowInserted = query.executeUpdate();
                    if(rowInserted == 1) {
                        flag = true;
                    }
                } else {
                    flag = false;
                    System.out.println("No available books for this title");
                }
            } else {
                flag = false;
                System.out.println("A member with this name does not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                mysql_lib_db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
    
    /*
     * Delete all those books which were not issued in last 1 year. 
     * Return the number of books deleted
     */
    public int deleteUnpopularBooks() {
        mysql_lib_db = DBConnection.getConnection();
        if(mysql_lib_db == null) {
            System.out.println("Connection was not established: Problem with DataBase Accesss");
            System.exit(0);
        }
        PreparedStatement updateQuery;
        int no_of_books_deleted = 0;
        try {
            updateQuery = mysql_lib_db.prepareStatement("DELETE from books "+ 
                "where books.accession_no not in ("+ 
                    "SELECT book_issue.accession_no " +
                    "from book_issue "+
                    "where DATEDIFF(NOW(),book_issue.issue_date) < 366 )");
            no_of_books_deleted = updateQuery.executeUpdate(); 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                mysql_lib_db.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return no_of_books_deleted;
    }
}
