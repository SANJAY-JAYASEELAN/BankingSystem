<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: white;
        padding: 20px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
        text-align: center;
        width: 300px;
    }
    h2 {
        color: #333;
    }
    input {
        width: 100%;
        padding: 8px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
    .new-user-btn {
        background-color: #28a745;
    }
    .new-user-btn:hover {
        background-color: #218838;
    }
</style>

</head>
<body>
    <div class="container">
        <h2>Login Page</h2>
        <form action="Servlet" method="post">
            <input type="hidden" value="login" name="action">
            <label>Account Number:</label>
            <input type="number" name="account_number" required/>
            <label>Password:</label>
            <input type="password" name="password" required/>
            <button type="submit">Login</button>
            <button type="button" class="new-user-btn" onclick="window.location.href='register.jsp';">New User?</button>
        </form>
    </div>
</body>
</html>
