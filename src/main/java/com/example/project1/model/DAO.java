package com.example.project1.model;

import java.sql.*;
import java.util.ArrayList;

public enum DAO {
    instance;
    private final Connection connection;
    DAO() {
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

    public ArrayList<Dish> getDishes() {
        ArrayList<Dish> dishArr = new ArrayList<>();
        Statement stmt = null;

        try {

            stmt = this.connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM dishes");

            while(res.next()) {
                dishArr.add(new Dish(
                        res.getInt("dish_id"),
                        res.getString("dish_name"),
                        res.getString("provided_by"),
                        res.getString("ingredient"),
                        res.getString("instruction"),
                        res.getString("photo"),
                        res.getInt("number_of_rate"),
                        res.getInt("avg_rate")));
            }

//            stmt.close();
//            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return dishArr;
    }

}
