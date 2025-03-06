<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f8f9fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .container {
        background: #ffffff;
        padding: 30px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 400px;
        text-align: center;
    }
    h2 {
        color: #343a40;
        font-size: 24px;
        margin-bottom: 20px;
    }
    input {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }
    button {
        width: 100%;
        padding: 12px;
        margin-top: 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        font-weight: 500;
        transition: background 0.3s, transform 0.2s;
    }
    button:hover {
        transform: translateY(-2px);
    }
    
    /* Button Colors */
    .btn-submit {
        background-color: #28a745; /* Green */
        color: #ffffff;
    }
    .btn-submit:hover {
        background-color: #218838;
    }
</style>

</head>
<body>
    <div class="container">
        <h2>Create Your Account</h2>
        <form action="Servlet" method="post">
            <input type="hidden" value="register" name="action">
            <input type="text" name="first_name" placeholder="First Name" required>
            <input type="text" name="last_name" placeholder="Last Name">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password" required>
            <input type="number" name="initial_deposit" step="0.01" placeholder="Initial Deposit" required>
            <button class="btn-submit" type="submit">Register</button>
        </form>
    </div>
</body>
</html>
