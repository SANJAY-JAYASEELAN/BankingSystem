<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Banking System</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        text-align: center;
    }
    .container {
        background: white;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        width: 300px;
    }
    h2 {
        color: #333;
    }
    button {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    .login-btn {
        background-color: #007bff;
        color: white;
    }
    .login-btn:hover {
        background-color: #0056b3;
    }
    .register-btn {
        background-color: #28a745;
        color: white;
    }
    .register-btn:hover {
        background-color: #218838;
    }
</style>

</head>
<body>
    <div class="container">
        <h2>Welcome to Our Banking System</h2>
        <button class="login-btn" onclick="window.location.href='login.jsp';">Login</button>
        <button class="register-btn" onclick="window.location.href='register.jsp';">Register</button>
    </div>
</body>
</html>
