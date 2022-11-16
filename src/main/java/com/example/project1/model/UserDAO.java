package com.example.project1.model;

import java.sql.*;

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

    public User checkUserPassword(String email, String pass) {

        PreparedStatement psmt;
        try {
            psmt = connection.prepareStatement("SELECT * FROM user " +
                    "                                                 WHERE USER_EMAIL = ? and USER_PASSWORD = ?");
            psmt.setString(1, email);
            psmt.setString(2, pass);
            ResultSet res = psmt.executeQuery();

            if (res.next()) {
                User user = new User(
                        res.getInt("USER_ID"),
                        res.getString("USER_NAME"),
                        res.getString("USER_EMAIL"),
                        res.getString("USER_PASSWORD")
                );

                psmt.close();
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public User registerUser(String name, String email, String password){
        PreparedStatement pstm;

        try {
            pstm = connection.prepareStatement("INSERT INTO USER (user_name, user_email, user_password) " +
                                                   "VALUES (?, ?, ?)");
            if(!(name.trim().isEmpty())){
                pstm.setString(1, name);
            }
            if(!(email.trim().isEmpty())){
                pstm.setString(2, email);
            }
            if(!(password.trim().isEmpty())){
                pstm.setString(3, password);
            }

            if(pstm.executeUpdate() == 1){
                pstm = connection.prepareStatement("SELECT * FROM USER WHERE USER_EMAIL = ?");
                pstm.setString(1, email);
                ResultSet res = pstm.executeQuery();
                if(res.next()){
                    User user = new User(res.getInt("user_id"),
                                         res.getString("user_name"),
                                         res.getString("user_email"),
                                         res.getString("user_password")
                                );
                    pstm.close();
                    return user;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
