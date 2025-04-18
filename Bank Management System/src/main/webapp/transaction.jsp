<%@ page import="com.bank.model.User" %>
<%-- <%
   /*  HttpSession  = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    } */
%> --%>
<!DOCTYPE html>
<html>
<head><title>Transaction</title></head>
<body>
<div style="color:black;margin:auto;        
            background-color:pink; 
            hight:500px;width:300px;
            pading:auto;border:1px solid black;">
<h2>New Transaction</h2>
<form action="TransactionServlet" method="post">
    Type:
    <select name="type">
        <option value="Deposit">Deposit</option>
        <option value="Withdraw">Withdraw</option>
    </select><br/><br>
    Amount: <input type="number" name="amount" step="0.01" required placeholder="Enter Amount"/><br/><br>
    <input type="submit" value="Submit" />
</form>

    <p style="color:green;"><%= request.getAttribute("message") %></p>

<a href="dashboard.jsp">Back to Dashboard</a>
</div>
</body>
</html>
