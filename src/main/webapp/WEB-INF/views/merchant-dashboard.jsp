<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Merchant Dashboard</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background: #f5f6f8;
            margin: 0;
        }

        .header {
            background: #1976d2;
            color: white;
            padding: 20px 40px;
        }

        .container {
            width: 90%;
            margin: 30px auto;
        }

        .card {
            background: white;
            padding: 25px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }

        button {
            padding: 12px 20px;
            margin-right: 10px;
            background: #1976d2;
            color: white;
            border: none;
            border-radius: 5px;
        }

    </style>

</head>

<body>

<div class="header">

    <h2>Merchant Admin Dashboard</h2>

</div>


<div class="container">

    <div class="card">

        <h3>
            Welcome, ${sessionScope.username}
        </h3>

        <p>
            Merchant ID:
            <strong>${sessionScope.merchantId}</strong>
        </p>

        <p>
            Role:
            <strong>${sessionScope.role}</strong>
        </p>

    </div>


    <div class="card">

        <h3>Merchant Operations</h3>

        <button>
            Create Order
        </button>

        <button>
            View Orders
        </button>

        <button>
            Merchant Profile
        </button>

    </div>

</div>

</body>

</html>
