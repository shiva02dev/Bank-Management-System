package com.bank.dao;

import com.bank.model.Transaction;
import java.sql.*;
import java.util.*;

public class TransactionDAO {
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (name,type, amount) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
        	stmt.setString(1, transaction.getName());
            stmt.setString(2, transaction.getType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.executeUpdate();
        }
    }

    public List<Transaction> getUserTransactions(String name) throws SQLException {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE  = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Transaction(rs.getString("name"),
                                         rs.getString("type"), rs.getDouble("amount")));
            }
        }
        return list;
    }
    
}
