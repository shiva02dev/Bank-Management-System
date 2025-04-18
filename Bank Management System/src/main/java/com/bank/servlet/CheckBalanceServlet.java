package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.dao.DBConnection;
import com.bank.dao.UserDAO;
import com.bank.model.Transaction;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkBalance")
public class CheckBalanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

       // UserDAO userDAO = new UserDAO();
      try {
             Connection con=DBConnection.getConnection();
             
             PreparedStatement ps= con.prepareStatement("select * from users where name=?");
             PreparedStatement ps1= con.prepareStatement("select * from transactions where name=?");
             ps.setString(1, name);
            // ps.setString(2, password);
             ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	ps1.setString(1,password);
        	 ResultSet rs1 = ps1.executeQuery();
        	if(rs1.next()) {
        	int res= rs1.getInt("amount");
            request.setAttribute("balance",res);
            request.getRequestDispatcher("balance.jsp").forward(request, response);
        	}else {
        		System.out.println("user not found");
        	}
        } else {
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
      }
        catch (Exception e) {
			// TODO: handle exception
		}
    }
}

