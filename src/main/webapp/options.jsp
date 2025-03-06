<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Options</title>

<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f8f9fa;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        text-align: center;
    }
    .container {
        background: #ffffff;
        padding: 25px;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        width: 380px;
    }
    h2 {
        color: #343a40;
        margin-bottom: 20px;
        font-size: 22px;
    }
    form {
        margin: 10px 0;
    }
    button {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        font-weight: 500;
        transition: background 0.3s, transform 0.2s;
        margin-top: 5px;
    }
    button:hover {
        transform: translateY(-2px);
    }
    
    /* Professional color scheme */
    .btn-primary { background-color: #0056b3; color: #fff; } /* Dark blue */
    .btn-primary:hover { background-color: #004494; }

    .btn-secondary { background-color: #6c757d; color: #fff; } /* Dark gray */
    .btn-secondary:hover { background-color: #565e64; }

    .btn-success { background-color: #198754; color: #fff; } /* Deep green */
    .btn-success:hover { background-color: #146c43; }

    .btn-warning { background-color: #ffc107; color: #212529; } /* Gold */
    .btn-warning:hover { background-color: #d39e00; }

    .btn-info { background-color: #0dcaf0; color: #fff; } /* Cyan */
    .btn-info:hover { background-color: #0ba8c4; }
</style>

</head>
<body>
    <div class="container">
        <h2>Select a Transaction</h2>
        
        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="deposit">
            <button class="btn-primary" type="submit">Deposit</button>
        </form>

        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="withdraw">
            <button class="btn-secondary" type="submit">Withdraw</button>
        </form>

        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="transfer">
            <button class="btn-success" type="submit">Transfer</button>
        </form>

        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="transactions">
            <button class="btn-info" type="submit">Transaction History</button>
        </form>

        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="update">
            <button class="btn-warning" type="submit">Update Account</button>
        </form>

        <form action="transactionServlet" method="post">
            <input type="hidden" name="action" value="account_details">
            <button class="btn-success" type="submit">Account Details</button>
        </form>
    </div>
</body>
</html>
