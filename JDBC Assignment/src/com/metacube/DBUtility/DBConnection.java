package com.metacube.DBUtility;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import com.metacube.Utility.DBConstants;
/**
 * Utility class to establish connection with the database
 * @author GAUARV TAK
 *
 */
public class DBConnection {
    
    public static Connection getConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load mysql Driver");
            e.printStackTrace();
            return null;
        }
        
        Connection connection = null;
        try {
            connection = DriverManager
            .getConnection(DBConstants.DBHOST+DBConstants.DBNAME,DBConstants.DB_USERNAME, DBConstants.DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection To Database Failed!");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            return connection;
        } else {
            System.out.println("Failed to make connection!");
            return null;
        }
    }
}
