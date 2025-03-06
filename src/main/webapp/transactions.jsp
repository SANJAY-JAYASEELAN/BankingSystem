<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>

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
            width: 450px;
            text-align: center;
        }
        h2 {
            color: #343a40;
            font-size: 22px;
            margin-bottom: 20px;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            background: #e9ecef;
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
            font-size: 16px;
            color: #495057;
        }
        .no-data {
            color: #dc3545;
            font-size: 16px;
            font-weight: bold;
        }
        .back-button {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #007bff;
            color: white;
            border-radius: 5px;
            transition: background 0.3s ease-in-out;
        }
        .back-button:hover {
            background-color: #0056b3;
        }
    </style>

</head>
<body>
    <div class="container">
        <h2>Transaction History</h2>
        <ul>
            <% 
                java.util.List<String> stringList = (java.util.List<String>) request.getAttribute("stringList");
                if (stringList != null && !stringList.isEmpty()) {
                    for (String str : stringList) { 
            %>
                        <li><%= str %></li>
            <% 
                    } 
                } else { 
            %>
                    <li class="no-data">No data available</li>
            <% 
                } 
            %>
        </ul>
        <a class="back-button" href="options.jsp">Back</a>
    </div>
</body>
</html>
