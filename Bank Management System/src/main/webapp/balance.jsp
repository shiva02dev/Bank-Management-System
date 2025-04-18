<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Balance</title></head>
<body>
<div style="color:black;margin:auto;        
            background-color:gray; 
            hight:400px;width:300px;
            pading:auto;border:1px solid black;">
    <h2>Your Balance</h2>
    <p>Balance: $<%= request.getAttribute("balance") %></p>
  <!--  <a href="LogoutServlet">Logout</a>-->
<form action="logOut" method="post">
<input type="submit" value="logout">
</form>
</div>
</body>
</html>
