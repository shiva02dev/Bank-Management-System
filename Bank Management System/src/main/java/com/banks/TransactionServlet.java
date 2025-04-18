package com.banks;
import com.bank.dao.TransactionDAO;
import com.bank.model.Transaction;
import com.bank.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        double amount = Double.parseDouble(request.getParameter("amount"));

        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");

        Transaction txn = new Transaction(user.getName(), type, amount);
        TransactionDAO dao = new TransactionDAO();

        try {
            dao.addTransaction(txn);
            request.setAttribute("message", "Transaction successful");
            request.getRequestDispatcher("transaction.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}


