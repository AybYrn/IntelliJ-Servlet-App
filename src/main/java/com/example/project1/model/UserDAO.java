package com.example.project1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum UserDAO {
    instance;
    private final Connection connection;

    UserDAO() {

        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:hsqldb:hsql://localhost/dishesDB",
                    "SA",
                    "");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
