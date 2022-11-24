package com.example.project1.model;

import java.sql.*;
import java.util.ArrayList;

public enum DishDAO {
    instance;
    private final Connection connection;
    DishDAO() {
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

    public ArrayList<Dish> getDishes(int id) {
        ArrayList<Dish> dishArr = new ArrayList<>();
        PreparedStatement pstmt = null;

        try {

            pstmt = this.connection.prepareStatement("SELECT * FROM dishes WHERE USER_ID = ?");
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();

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
                System.out.println(dishArr.get(dishArr.size()-1));
            }

            pstmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return dishArr;
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

            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return dishArr;
    }

    public Dish insertDish(int user_id, String dish_name, String provided_by, String ingredient, String instructions,
                           String photo,int rate){
        PreparedStatement pstm = null;
        Dish dish = null;
        try{
            pstm = this.connection.prepareStatement("INSERT INTO DISHES (USER_ID, DISH_NAME, PROVIDED_BY, INGREDIENT, INSTRUCTION, PHOTO, NUMBER_OF_RATE, AVG_RATE) " +
                                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

            pstm.setInt(1, user_id);
            pstm.setString(2, dish_name);
            pstm.setString(3, provided_by);
            pstm.setString(4, ingredient);
            pstm.setString(5, instructions);
            pstm.setString(6, photo);
            pstm.setInt(7, 1);
            pstm.setInt(8, rate);

            pstm.execute();
            dish = new Dish(user_id, dish_name, provided_by, ingredient, instructions, photo,1,rate);

            pstm.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return dish;
    }

}
