package com.liceu.userdatabase.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/blog?user=root&password=root";
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}