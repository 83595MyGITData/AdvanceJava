package com.sunbeam.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
   
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/election_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Admin";

   
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

  
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
