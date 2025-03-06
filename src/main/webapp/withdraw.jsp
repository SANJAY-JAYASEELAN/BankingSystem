<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Amount</title>

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
            font-size: 22px;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ced4da;
            border-radius: 5px;
            font-size: 16px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #dc3545;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background 0.3s ease-in-out;
        }
        button:hover {
            background-color: #c82333;
        }
        .back-button {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #6c757d;
            color: white;
            border-radius: 5px;
            transition: background 0.3s ease-in-out;
        }
        .back-button:hover {
            background-color: #5a6268;
        }
    </style>

</head>
<body>
    <div class="container">
        <h2>Withdraw Funds</h2>
        <form action="transactionHandlingServlet" method="post">
            <input type="hidden" name="action" value="withdraw">
            <input type="number" step="0.01" name="amount" placeholder="Enter amount" required>
            <button type="submit">Confirm Withdrawal</button>
        </form>
        <a class="back-button" href="options.jsp">Back</a>
    </div>
</body>
</html>
