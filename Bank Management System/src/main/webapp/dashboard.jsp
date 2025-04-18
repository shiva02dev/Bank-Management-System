<%@ page import="com.bank.model.User" %>
<%@ page session="false" %>
<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head><title>Dashboard</title></head>
<body>
<div style="color:black;margin:auto;        
            background-color:lightgreen; 
            hight:400px;width:300px;
            pading:auto;border:1px solid black;">
<h2>Welcome, <%= user.getName() %></h2>
<p>YourEmail <%= user.getEmail() %></p>
<a href="checkbalance.jsp">Check Balance</a><br><br>
<a href="transaction.jsp">Make a Transaction</a><br/><br>
<!--<a href="LogoutServlet">Logout</a>-->
<form action="logOut" method="post">
<input type="submit" value="logout">
</form>
</div>
</body>
</html>

