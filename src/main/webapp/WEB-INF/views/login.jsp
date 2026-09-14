<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Merchant Login</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background: #f5f6f8;
            margin: 0;
            padding: 40px;
        }

        .container {
            width: 400px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h2 {
            color: #172033;
        }

        .form-row {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input {
            width: 100%;
            height: 40px;
            padding: 8px 10px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            height: 44px;
            background: #1976d2;
            color: white;
            border: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .success {
            color: green;
            margin-bottom: 20px;
        }

    </style>

</head>

<body>

<div class="container">

    <h2>Merchant Login</h2>

    <% if ("true".equals(request.getParameter("registered"))) { %>

        <div class="success">
            Registration successful.
            Please login.
        </div>

    <% } %>

    <form action="${pageContext.request.contextPath}/login"
          method="post">

        <div class="form-row">

            <label>Username</label>

            <input type="text"
                   name="username"
                   required>

        </div>

        <div class="form-row">

            <label>Password</label>

            <input type="password"
                   name="password"
                   required>

        </div>

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>

</html>