<!DOCTYPE html>
<html>
<head><title>Register</title></head>
<body>
<div style="color:black;margin:auto;        
            background-color:lightblue; 
            hight:600px;width:300px;
            pading:auto;border:1px solid black;">
<h2>Register</h2>
<form action="RegisterServlet" method="post">
    Name: <input type="text" name="name" required placeholder="Enter Name" /><br><br>
    E-mail: <input type="text" name="email" required placeholder="Enter Email"/><br><br>
    Password: <input type="password" name="password" required placeholder="Enter Password" /><br><br>
    <input type="submit" value="Register" />
</form><br>
<a href="login.jsp">Login</a>
</div>
</body>
</html>

