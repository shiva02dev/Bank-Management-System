<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
<div style="color:black;margin:auto;        
            background-color:yellow; 
            hight:400px;width:300px;
            pading:top ;border:1px solid black;">
<h2>Login</h2>
<form action="loginServlet" method="post">
    E-mail: <input type="text" name="email" required placeholder="Enter Email"/><br/><br>
    Password: <input type="password" name="password" required placeholder="Enter Password" /><br/><br>
    <input type="submit" value="Login" />
</form><br>
<a href="register.jsp">Register</a><br><br>
<!--<a href="checkbalance.jsp">Check Balance</a>-->
</div>
</body>
</html>
