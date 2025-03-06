<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>

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
        padding: 25px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 350px;
        text-align: center;
    }
    h2 {
        color: #343a40;
        font-size: 22px;
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
    .btn-confirm {
        background-color: #0056b3; /* Dark blue */
        color: #ffffff;
    }
    .btn-confirm:hover {
        background-color: #004494;
    }
</style>

</head>
<body>
    <div class="container">
        <h2>Deposit Funds</h2>
        <form action="transactionHandlingServlet" method="post">
            <input type="hidden" name="action" value="deposit">
            <input type="number" step="0.01" name="amount" placeholder="Enter amount" required>
            <button class="btn-confirm" type="submit">Confirm Deposit</button>
        </form>
    </div>
</body>
</html>
