<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Merchant Portal</title>

<style>

/* =========================
   COMMON
========================= */

* {
    box-sizing: border-box;
}

html,
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background: #f5f6f8;
}


/* =========================
   PAGE
========================= */

.page {
    width: 100%;
    min-height: 100vh;
    padding: 18px 0 35px;
}


/* =========================
   MAIN
========================= */

.main {
    width: calc(100% - 40px);
    max-width: 1400px;
    margin: 0 auto;
}


/* =========================
   ROW
========================= */

.row {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 28px;
    align-items: start;
}

.row + .row {
    margin-top: 28px;
}


/* =========================
   COMMON BOX
========================= */

.box {
    width: 100%;
    background: #ffffff;
    border-radius: 9px;
    padding: 28px;
    box-shadow: 0 2px 12px rgba(0, 0, 0, 0.12);
}


/* =========================
   HEADINGS
========================= */

h2 {
    margin: 0 0 10px;
    color: #172033;
    font-size: 30px;
    line-height: 1.2;
}


/* =========================
   SUBTITLE
========================= */

.subtitle {
    color: #666;
    font-size: 16px;
    margin-bottom: 20px;
}


/* =========================
   FORM ROW
========================= */

.form-row {
    margin-bottom: 13px;
}


/* =========================
   LABEL
========================= */

label {
    display: block;
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 6px;
    color: #111;
}


/* =========================
   INPUT
========================= */

input {
    width: 100%;
    height: 48px;
    padding: 10px 12px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 16px;
    outline: none;
    background: #fff;
}

input:focus {
    border-color: #1976d2;
    box-shadow: 0 0 0 2px rgba(25, 118, 210, 0.12);
}


/* =========================
   SELECT
========================= */

select {
    width: 100%;
    height: 48px;
    padding: 10px 12px;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 16px;
    background: #fff;
    outline: none;
}

select:focus {
    border-color: #1976d2;
}


/* =========================
   BUTTON
========================= */

button {
    width: 100%;
    height: 50px;
    margin-top: 6px;
    background: #1976d2;
    color: white;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    font-weight: bold;
    cursor: pointer;
}

button:hover {
    background: #125aa0;
}


/* =========================
   RESPONSE
========================= */

.response {
    margin-top: 18px;
    padding: 14px;
    background: #f0fff4;
    border: 1px solid #28a745;
    border-radius: 6px;
    font-size: 14px;
}

.response h3 {
    margin: 0 0 10px;
    color: #218838;
    font-size: 18px;
}

.response p {
    margin: 6px 0;
}


/* =========================
   LOGIN RESPONSE
========================= */

.login-response {
    margin-top: 18px;
    padding: 14px;
    background: #f0fff4;
    border: 1px solid #28a745;
    border-radius: 6px;
    color: #218838;
    font-size: 14px;
    word-break: break-word;
}

.login-response h3 {
    margin: 0 0 10px;
    font-size: 18px;
}

.login-box {
    min-height: 380px;
    padding: 32px;
}

.login-box input {
    height: 48px;
}

.login-box button {
    height: 50px;
    margin-top: 15px;
}


/* =========================
   ERROR RESPONSE
========================= */

.error-response {
    margin-top: 18px;
    padding: 14px;
    background: #fff5f5;
    border: 1px solid #dc3545;
    border-radius: 6px;
    color: #dc3545;
    font-size: 14px;
}

.error-response h3 {
    margin: 0 0 10px;
    font-size: 18px;
}


/* =========================
   KYC / APPROVE
========================= */

.kyc-box {
    min-height: 0;
}


/* =========================
   CREATE ORDER
========================= */

.order-box {
    min-height: 0;
}


/* =========================
   ORDER RESPONSE
========================= */

.order-response {
    margin-top: 20px;
    padding: 16px;
    background: #f0fff4;
    border: 1px solid #28a745;
    border-radius: 6px;
    color: #155724;
    font-size: 14px;
}

.order-response h3 {
    margin: 0 0 12px;
    color: #218838;
    font-size: 18px;
}

.order-response p {
    margin: 7px 0;
}


/* =========================
   ORDER ERROR
========================= */

.order-error {
    margin-top: 20px;
    padding: 16px;
    background: #fff5f5;
    border: 1px solid #dc3545;
    border-radius: 6px;
    color: #dc3545;
    font-size: 14px;
}

.order-error h3 {
    margin: 0 0 10px;
    font-size: 18px;
}


/* =========================
   CHECKOUT LINK
========================= */

.checkout-link {
    display: inline-block;
    margin-top: 8px;
    padding: 10px 14px;
    background: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;
    font-weight: bold;
}

.checkout-link:hover {
    background: #218838;
}

.single-order {
    margin-top: 15px;
    padding: 15px;
    background: #ffffff;
    border: 1px solid #ddd;
    border-radius: 6px;
}

.single-order p {
    margin: 7px 0;
    word-break: break-word;
}

.single-order + .single-order {
    margin-top: 15px;
}


/* =========================
   MOBILE
========================= */

@media (max-width: 900px) {

    .main {
        width: calc(100% - 30px);
    }

    .row {
        grid-template-columns: 1fr;
    }

    .row + .row {
        margin-top: 20px;
    }

    .box {
        padding: 22px;
    }

    h2 {
        font-size: 26px;
    }

}

</style>

</head>


<body>

<div class="page">

<div class="main">


<!-- =====================================================
     ROW 1
===================================================== -->

<div class="row">


<!-- =====================================================
     1. REGISTER MERCHANT
===================================================== -->

<div class="box register-box">

    <h2>
        Register Merchant
    </h2>

    <div class="subtitle">
        Create merchant and its first ADMIN portal user
    </div>

    <form
        action="${pageContext.request.contextPath}/api/v1/merchants/ui-register"
        method="post">

        <!-- LEGAL NAME -->

        <div class="form-row">

            <label>
                Legal Name *
            </label>

            <input
                name="legalName"
                placeholder="My New Shop Pvt Ltd"
                required>

        </div>


        <!-- EMAIL -->

        <div class="form-row">

            <label>
                Email *
            </label>

            <input
                type="email"
                name="email"
                placeholder="owner@myshop.com"
                required>

        </div>


        <!-- PHONE -->

        <div class="form-row">

            <label>
                Phone *
            </label>

            <input
                name="phone"
                placeholder="9123456780"
                required>

        </div>


        <!-- PAN -->

        <div class="form-row">

            <label>
                PAN Number *
            </label>

            <input
                name="panNumber"
                placeholder="ABCDE1234F"
                required>

        </div>


        <!-- GST -->

        <div class="form-row">

            <label>
                GST Number *
            </label>

            <input
                name="gstNumber"
                placeholder="27ABCDE1234F1Z5"
                required>

        </div>


        <!-- SETTLEMENT ACCOUNT -->

        <div class="form-row">

            <label>
                Settlement Account ID *
            </label>

            <input
                name="settlementAccountId"
                placeholder="NODAL-MERCHANT-2002"
                required>

        </div>


        <!-- ADMIN USERNAME -->

        <div class="form-row">

            <label>
                Admin Username *
            </label>

            <input
                name="adminUsername"
                placeholder="newshopadmin"
                required>

        </div>


        <!-- ADMIN PASSWORD -->

        <div class="form-row">

            <label>
                Admin Password *
            </label>

            <input
                type="password"
                name="adminPassword"
                placeholder="NewShop@123"
                required>

        </div>


        <!-- REGISTER BUTTON -->

        <button type="submit">
            Register Merchant
        </button>

    </form>


    <!-- REGISTRATION RESPONSE -->

    <% if (request.getAttribute("registrationResponse") != null) { %>

    <div class="response">

        <h3>
            Registration Successful
        </h3>

        <p>
            <b>Merchant ID:</b>
            ${registrationResponse.id}
        </p>

        <p>
            <b>Legal Name:</b>
            ${registrationResponse.legalName}
        </p>

        <p>
            <b>Email:</b>
            ${registrationResponse.email}
        </p>

        <p>
            <b>Phone:</b>
            ${registrationResponse.phone}
        </p>

        <p>
            <b>PAN:</b>
            ${registrationResponse.panNumber}
        </p>

        <p>
            <b>GST:</b>
            ${registrationResponse.gstNumber}
        </p>

        <p>
            <b>Settlement ID:</b>
            ${registrationResponse.settlementAccountId}
        </p>

        <p>
            <b>KYC:</b>
            ${registrationResponse.kycStatus}
        </p>

        <p>
            <b>Status:</b>
            ${registrationResponse.status}
        </p>

    </div>

    <% } %>

</div>


<!-- =====================================================
     2. PLATFORM ADMIN LOGIN
===================================================== -->

<div class="box login-box">

    <h2>
        Platform Admin Login
    </h2>

    <div class="subtitle">
        Login to Merchant Portal
    </div>

    <form
        action="${pageContext.request.contextPath}/login"
        method="post">

        <!-- USERNAME -->

        <div class="form-row">

            <label>
                Username
            </label>

            <input
                type="text"
                name="username"
                placeholder="Username"
                required>

        </div>


        <!-- PASSWORD -->

        <div class="form-row">

            <label>
                Password
            </label>

            <input
                type="password"
                name="password"
                placeholder="Password"
                required>

        </div>


        <!-- LOGIN BUTTON -->

        <button type="submit">
            Login
        </button>

    </form>


    <!-- LOGIN RESPONSE -->

    <% if (request.getAttribute("loginResponse") != null) { %>

    <div class="login-response">

        <h3>
            Login Successful
        </h3>

        <p>
            <b>Access Token:</b>
            ${loginResponse.accessToken}
        </p>

        <p>
            <b>Token Type:</b>
            ${loginResponse.tokenType}
        </p>

        <p>
            <b>Expires In:</b>
            ${loginResponse.expiresInSeconds}
            seconds
        </p>

        <p>
            <b>Merchant ID:</b>
            ${loginResponse.merchantId}
        </p>

        <p>
            <b>Role:</b>
            ${loginResponse.role}
        </p>

    </div>

    <% } %>

</div>

</div>


<!-- =====================================================
     ROW 2
===================================================== -->

<div class="row">


<!-- =====================================================
     3. UPDATE KYC STATUS
===================================================== -->

<div class="box kyc-box">

    <h2>
        Update KYC Status
    </h2>

    <div class="subtitle">
        Platform Admin - Update Merchant KYC
    </div>

    <form
        action="${pageContext.request.contextPath}/api/v1/admin/merchants/ui-kyc"
        method="post">

        <!-- MERCHANT ID -->

        <div class="form-row">

            <label>
                Merchant ID *
            </label>

            <input
                type="number"
                name="merchantId"
                placeholder="1010"
                required>

        </div>


        <!-- KYC STATUS -->

        <div class="form-row">

            <label>
                KYC Status *
            </label>

            <select
                name="kycStatus"
                required>

                <option value="APPROVED">
                    APPROVED
                </option>

                <option value="REJECTED">
                    REJECTED
                </option>

                <option value="PENDING">
                    PENDING
                </option>

            </select>

        </div>


        <!-- REMARKS -->

        <div class="form-row">

            <label>
                Remarks *
            </label>

            <input
                type="text"
                name="remarks"
                placeholder="Documents verified"
                required>

        </div>


        <!-- UPDATE BUTTON -->

        <button type="submit">
            Update KYC
        </button>

    </form>


    <!-- KYC RESPONSE -->

    <% if (request.getAttribute("kycResponse") != null) { %>

    <div class="response">

        <h3>
            KYC Updated Successfully
        </h3>

        <p>
            <b>Merchant ID:</b>
            ${kycResponse.id}
        </p>

        <p>
            <b>Legal Name:</b>
            ${kycResponse.legalName}
        </p>

        <p>
            <b>Email:</b>
            ${kycResponse.email}
        </p>

        <p>
            <b>Phone:</b>
            ${kycResponse.phone}
        </p>

        <p>
            <b>PAN:</b>
            ${kycResponse.panNumber}
        </p>

        <p>
            <b>GST:</b>
            ${kycResponse.gstNumber}
        </p>

        <p>
            <b>KYC Status:</b>
            ${kycResponse.kycStatus}
        </p>

        <p>
            <b>Status:</b>
            ${kycResponse.status}
        </p>

    </div>

    <% } %>

</div>


<!-- =====================================================
     4. APPROVE MERCHANT
===================================================== -->

<div class="box kyc-box">

    <h2>
        Approve Merchant Status
    </h2>

    <div class="subtitle">
        Platform Admin - Approve Status
    </div>

    <form
        action="${pageContext.request.contextPath}/api/v1/admin/merchants/ui-approve"
        method="post">

        <!-- MERCHANT ID -->

        <div class="form-row">

            <label>
                Merchant ID *
            </label>

            <input
                type="number"
                name="merchantId"
                placeholder="1002"
                required>

        </div>


        <!-- STATUS -->

        <div class="form-row">

            <label>
                Status *
            </label>

            <select
                name="status"
                required>

                <!-- ACTIVE REMAINS DEFAULT -->

                <option value="ACTIVE" selected>
                    ACTIVE
                </option>

                <option value="INACTIVE">
                    INACTIVE
                </option>

            </select>

        </div>


        <!-- APPROVE BUTTON -->

        <button type="submit">
            Approve Merchant
        </button>

    </form>


    <!-- APPROVE RESPONSE -->

    <% if (request.getAttribute("approveResponse") != null) { %>

    <div class="response">

        <h3>
            Merchant Approved Successfully
        </h3>

        <p>
            <b>Merchant ID:</b>
            ${approveResponse.id}
        </p>

        <p>
            <b>Legal Name:</b>
            ${approveResponse.legalName}
        </p>

        <p>
            <b>Email:</b>
            ${approveResponse.email}
        </p>

        <p>
            <b>Phone:</b>
            ${approveResponse.phone}
        </p>

        <p>
            <b>PAN:</b>
            ${approveResponse.panNumber}
        </p>

        <p>
            <b>GST:</b>
            ${approveResponse.gstNumber}
        </p>

        <p>
            <b>KYC Status:</b>
            ${approveResponse.kycStatus}
        </p>

        <p>
            <b>Status:</b>
            ${approveResponse.status}
        </p>

    </div>

    <% } %>


    <!-- APPROVE ERROR -->

    <% if (request.getAttribute("approveError") != null) { %>

    <div class="error-response">

        <h3>
            Approval Failed
        </h3>

        <p>
            ${approveError}
        </p>

    </div>

    <% } %>

</div>

</div>
<!-- =====================================================
     IMPORTANT:
     ROW 2 ENDS HERE
===================================================== -->


<!-- =====================================================
     ROW 3
===================================================== -->

<div class="row">


<!-- =====================================================
     5. CREATE ORDER
===================================================== -->

<div class="box order-box">

    <h2>
        Create Order
    </h2>

    <div class="subtitle">
        Create a new merchant order
    </div>


    <form
        action="${pageContext.request.contextPath}/merchant/create-order"
        method="post">


        <!-- ORDER REFERENCE -->

        <div class="form-row">

            <label>
                Order Reference *
            </label>

            <input
                type="text"
                id="orderRef"
                name="orderRef"
                placeholder="ORD-2026-000123"
                required>

        </div>


        <!-- AMOUNT -->

        <div class="form-row">

            <label>
                Amount *
            </label>

            <input
                type="number"
                id="amount"
                name="amount"
                placeholder="1499.00"
                step="0.01"
                min="0.01"
                required>

        </div>


        <!-- CURRENCY -->

        <div class="form-row">

            <label>
                Currency *
            </label>

            <select
                id="currency"
                name="currency"
                required>

                <option value="INR">
                    INR
                </option>

            </select>

        </div>


        <!-- CUSTOMER EMAIL -->

        <div class="form-row">

            <label>
                Customer Email *
            </label>

            <input
                type="email"
                id="customerEmail"
                name="customerEmail"
                placeholder="customer@example.com"
                required>

        </div>


        <!-- CREATE ORDER BUTTON -->

        <button
            type="submit"
            id="createOrderButton">

            Create Order

        </button>

    </form>


    <!-- =================================================
         CREATE ORDER RESPONSE
    ================================================= -->

    <% if (request.getAttribute("orderResponse") != null) { %>

    <div id="orderResponse" class="response">

        <h3>
            Order Created Successfully
        </h3>

        <p>
            <b>Order Reference:</b>
            ${orderResponse.orderRef}
        </p>

        <p>
            <b>Merchant ID:</b>
            ${orderResponse.merchantId}
        </p>

        <p>
            <b>Amount:</b>
            ${orderResponse.amount}
        </p>

        <p>
            <b>Currency:</b>
            ${orderResponse.currency}
        </p>

        <p>
            <b>Status:</b>
            ${orderResponse.status}
        </p>

        <p>
            <b>PG Transaction Reference:</b>
            ${orderResponse.pgTxnRef}
        </p>

        <p>
            <b>Checkout URL:</b>
            ${orderResponse.checkoutUrl}
        </p>

        <p>
            <b>Created At:</b>
            ${orderResponse.createdAt}
        </p>

        <p>
            <b>Updated At:</b>
            ${orderResponse.updatedAt}
        </p>

    </div>

    <% } %>


    <!-- =================================================
         CREATE ORDER ERROR
    ================================================= -->

    <% if (request.getAttribute("orderError") != null) { %>

    <div class="order-error">

        <h3>
            Order Creation Failed
        </h3>

        <p>
            ${orderError}
        </p>

    </div>

    <% } %>

</div>


<!-- =====================================================
     ROW 3 ENDS HERE
===================================================== -->
    
    <!-- =================================================
         6. MY ORDERS
    ================================================= -->

    <div class="box order-box">

        <h2>
            My Orders
        </h2>

        <div class="subtitle">
            View all orders belonging to this merchant
        </div>


        <!-- LIST ORDERS BUTTON -->

        <form
            action="${pageContext.request.contextPath}/merchant/my-orders"
            method="get">

            <button type="submit">
                List Of My Orders
            </button>

        </form>


        <!-- =================================================
             ORDERS RESPONSE
        ================================================= -->

        <% if (request.getAttribute("order") != null) { %>

            <div class="order-response">

                <h3>
                    My Orders
                </h3>

                <%
                    List<com.example.model.Merchant_Order> orders =
                        (List<com.example.model.Merchant_Order>)
                        request.getAttribute("order");
                %>


                <% if (orders.isEmpty()) { %>

                    <p>
                        No orders found for this merchant.
                    </p>

                <% } else { %>


                    <% for (com.example.model.Merchant_Order order : orders) { %>

                        <div class="single-order">

                            <p>
                                <b>Order Reference:</b>
                                <%= order.getOrder_ref() %>
                            </p>

                            <p>
                                <b>Merchant ID:</b>
                                <%= order.getMerchant_id() %>
                            </p>

                            <p>
                                <b>Amount:</b>
                                <%= order.getAmount() %>
                            </p>

                            <p>
                                <b>Currency:</b>
                                <%= order.getCurrency() %>
                            </p>

                            <p>
                                <b>Status:</b>
                                <%= order.getStatus() %>
                            </p>

                            <p>
                                <b>PG Transaction Reference:</b>
                                <%= order.getPg_txn_ref() %>
                            </p>

                            <p>
                                <b>Checkout URL:</b>
                                /pg/api/v1/authenticate/<%= order.getPg_txn_ref() %>
                            </p>

                            <p>
                                <b>Created At:</b>
                                <%= order.getCreated_at() %>
                            </p>

                            <p>
                                <b>Updated At:</b>
                                <%= order.getUpdated_at() %>
                            </p>

                        </div>

                    <% } %>

                <% } %>

            </div>

        <% } %>

    </div>

</div>
    
</div>
</div>
<!-- MAIN ENDS -->


<!-- PAGE ENDS -->

</body>

</html>
