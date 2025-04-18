package com.bank.dao;

import com.bank.model.Transaction;
import com.bank.model.User;
import java.sql.*;

public class UserDAO {
    public boolean registerUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            return stmt.executeUpdate() > 0;
        }
    }

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User( rs.getString("name"), rs.getString("email"),
                        rs.getString("password"));
            }
        }
        return null;
    }
    
    
    
    public User getUserByNameAndPassword(String name, String password) {
        User user = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                Transaction trans = new Transaction();
                user.setName(rs.getString("NAME"));
                trans.setAmount(rs.getDouble("AMOUNT"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

