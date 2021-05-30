package com.liceu.userdatabase.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Databasesqlite {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            //jdbc:sqlite:D:/Documentos/Trabajos/Servidors/PracticaNotas/database.db
            String url = "jdbc:sqlite:D:/Documentos/Trabajos/Servidors/PracticaNotas/database.db";
            if (connection == null) {
                    Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(url);
            }
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
