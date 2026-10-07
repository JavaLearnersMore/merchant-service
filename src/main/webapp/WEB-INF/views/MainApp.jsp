<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Merchant Portal</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/MainApp.css">

</head>

<body>

<div class="page">

    <div class="main">

        <h1>Merchant Portal</h1>


        <!-- ================================================= -->
        <!-- ROW 1 -->
        <!-- ================================================= -->

        <div class="row">


            <!-- REGISTER MERCHANT -->

            <div class="box">

                <h2>Register Merchant</h2>

                <form id="registerMerchantForm">

                    <div class="form-row">

                        <label>Legal Name</label>

                        <input type="text"
                               id="legalName"
                               name="legalName"
                               required
                               minlength="2"
                               maxlength="100">

                    </div>


                    <div class="form-row">

                        <label>Email</label>

                        <input type="email"
                               id="email"
                               name="email"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Phone</label>

                        <input type="text"
                               id="phone"
                               name="phone"
                               required>

                    </div>


                    <div class="form-row">

                        <label>PAN Number</label>

                        <input type="text"
                               id="panNumber"
                               name="panNumber"
                               required>

                    </div>


                    <div class="form-row">

                        <label>GST Number</label>

                        <input type="text"
                               id="gstNumber"
                               name="gstNumber"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Settlement Account ID</label>

                        <input type="text"
                               id="settlementAccountId"
                               name="settlementAccountId"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Admin Username</label>

                        <input type="text"
                               id="adminUsername"
                               name="adminUsername"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Admin Password</label>

                        <input type="password"
                               id="adminPassword"
                               name="adminPassword"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Role</label>

                        <select id="role"
                                name="role"
                                required>

                            <option value="">
                                Select Role
                            </option>

                            <option value="ADMIN">
                                ADMIN
                            </option>

                            <option value="MERCHANT">
                                MERCHANT
                            </option>

                        </select>

                    </div>


                    <button type="submit">
                        Register Merchant
                    </button>

                </form>


                <div id="registrationResponse"
                     class="response">
                </div>

            </div>



            <!-- PLATFORM ADMIN LOGIN -->

            <div class="box login-box">

                <h2>Platform Admin Login</h2>

                <form id="adminLoginForm">

                    <div class="form-row">

                        <label>Username</label>

                        <input type="text"
                               id="adminLoginUsername"
                               name="username"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Password</label>

                        <input type="password"
                               id="adminLoginPassword"
                               name="password"
                               required>

                    </div>


                    <button type="submit">
                        Login
                    </button>

                </form>


                <div id="adminLoginResponse"
                     class="response">
                </div>

            </div>

        </div>



        <!-- ================================================= -->
        <!-- ROW 2 -->
        <!-- ================================================= -->

        <div class="row">


            <!-- MERCHANT LOGIN -->

            <div class="box login-box">

                <h2>Merchant Login</h2>

                <form id="merchantLoginForm">

                    <div class="form-row">

                        <label>Username</label>

                        <input type="text"
                               id="merchantLoginUsername"
                               name="username"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Password</label>

                        <input type="password"
                               id="merchantLoginPassword"
                               name="password"
                               required>

                    </div>


                    <button type="submit">
                        Login
                    </button>

                </form>


                <div id="merchantLoginResponse"
                     class="response">
                </div>

            </div>



            <!-- UPDATE KYC -->

            <div class="box kyc-box">

                <h2>Update KYC Status</h2>

                <form id="kycForm">

                    <div class="form-row">

                        <label>Merchant ID</label>

                        <input type="number"
                               id="kycMerchantId"
                               required>

                    </div>


                    <div class="form-row">

                        <label>KYC Status</label>

                        <select id="kycStatus"
                                required>

                            <option value="">
                                Select Status
                            </option>

                            <option value="PENDING">
                                PENDING
                            </option>

                            <option value="APPROVED">
                                APPROVED
                            </option>

                            <option value="REJECTED">
                                REJECTED
                            </option>

                        </select>

                    </div>


                    <div class="form-row">

                        <label>Remarks</label>

                        <textarea id="kycRemarks"
                                  rows="4">
                        </textarea>

                    </div>


                    <button type="submit">
                        Update KYC
                    </button>

                </form>


                <div id="kycResponse"
                     class="response">
                </div>

            </div>

        </div>



        <!-- ================================================= -->
        <!-- ROW 3 -->
        <!-- ================================================= -->

        <div class="row">


            <!-- APPROVE MERCHANT -->

            <div class="box">

                <h2>Approve Merchant Status</h2>

                <form id="approveMerchantForm">

                    <div class="form-row">

                        <label>Merchant ID</label>

                        <input type="number"
                               id="approveMerchantId"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Status</label>

                        <select id="approveStatus"
                                required>

                            <option value="">
                                Select Status
                            </option>

                            <option value="ACTIVE">
                                ACTIVE
                            </option>

                            <option value="INACTIVE">
                                INACTIVE
                            </option>

                        </select>

                    </div>


                    <button type="submit">
                        Update Merchant Status
                    </button>

                </form>


                <div id="approveResponse"
                     class="response">
                </div>

            </div>



            <!-- CREATE ORDER -->

            <div class="box order-box">

                <h2>Create Order</h2>

                <form id="createOrderForm">

                    <div class="form-row">

                        <label>Order Reference</label>

                        <input type="text"
                               id="orderRef"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Amount</label>

                        <input type="number"
                               id="orderAmount"
                               step="0.01"
                               min="0"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Currency</label>

                        <input type="text"
                               id="orderCurrency"
                               value="INR"
                               required>

                    </div>


                    <div class="form-row">

                        <label>Customer Email</label>

                        <input type="email"
                               id="customerEmail"
                               required>

                    </div>


                    <button type="submit">
                        Create Order
                    </button>

                </form>


                <div id="orderResponse"
                     class="response">
                </div>

            </div>

        </div>



        <!-- ================================================= -->
        <!-- ROW 4 -->
        <!-- ================================================= -->

        <div class="row">


            <!-- MY ORDERS -->

            <div class="box">

                <h2>My Orders</h2>

                <button type="button"
                        id="myOrdersButton">

                    Get My Orders

                </button>


                <div id="myOrdersResponse"
                     class="response">
                </div>

            </div>

      <c:if test="${not empty orders}">

    <div class="box">

        <h2>My Orders</h2>

        <table class="orders-table">

            <thead>
                <tr>
                    <th>Order Ref</th>
                    <th>Amount</th>
                    <th>Currency</th>
                    <th>Status</th>
                    <th>Customer Email</th>
                    <th>PG Txn Ref</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                </tr>
            </thead>

            <tbody>

                <c:forEach var="order" items="${orders}">

                    <tr>

                        <td>${order.order_ref}</td>

                        <td>${order.amount}</td>

                        <td>${order.currency}</td>

                        <td>${order.status}</td>

                        <td>${order.customer_email}</td>

                        <td>${order.pg_txn_ref}</td>

                        <td>${order.created_at}</td>

                        <td>${order.updated_at}</td>

                    </tr>

                </c:forEach>

            </tbody>

        </table>

    </div>

</c:if>


            <!-- GET SINGLE ORDER -->

            <div class="box">

                <h2>Get Single Order</h2>

                <form id="singleOrderForm">

                    <div class="form-row">

                        <label>Order Reference</label>

                        <input type="text"
                               id="singleOrderRef"
                               required>

                    </div>


                    <button type="submit">
                        Get Order
                    </button>

                </form>


                <div id="singleOrderResponse"
                     class="response">
                </div>

            </div>

        </div>



        <!-- ================================================= -->
        <!-- ROW 5 -->
        <!-- ================================================= -->

        <div class="row">


            <!-- MERCHANT MANAGEMENT -->

            <div class="box">

                <h2>Merchant Management</h2>

                <div class="form-row">

                    <label>Merchant ID</label>

                    <input type="number"
                           id="managementMerchantId"
                           required>

                </div>


                <button type="button"
                        id="getMerchantButton">

                    Get Merchant

                </button>


                <button type="button"
                        id="suspendMerchantButton">

                    Suspend Merchant

                </button>


                <div id="merchantManagementResponse"
                     class="response">
                </div>

            </div>



            <!-- WEBHOOK -->

            <div class="box">

                <h2>Set Webhook Callback URL</h2>

                <form id="webhookForm">

                    <div class="form-row">

                        <label>Callback URL</label>

                        <input type="url"
                               id="webhookUrl"
                               placeholder="https://example.com/webhook"
                               required>

                    </div>


                    <button type="submit">
                        Save Webhook
                    </button>

                </form>


                <div id="webhookResponse"
                     class="response">
                </div>

            </div>

        </div>

    </div>

</div>

<!-- ============================================================= -->
<!-- JAVASCRIPT -->
<!-- ============================================================= -->

<script>

    /*
     * Context path of Spring Boot application.
     *
     * Example:
     * http://localhost:8080/merchant-service
     *
     * contextPath = /merchant-service
     */
    const contextPath = "${pageContext.request.contextPath}";


    /*
     * ============================================================
     * API URL CONFIGURATION
     * ============================================================
     *
     * Keep all API URLs here.
     *
     * Replace only the URLs marked with:
     *
     *      CHANGE_IF_REQUIRED
     *
     * with your actual REST controller mappings.
     */

    const API = {

        registerMerchant:
            contextPath + "/api/v1/merchants/register",

        adminLogin:
            contextPath + "/api/v1/auth/login",

        merchantLogin:
            contextPath + "/api/v1/auth/login",

        updateKyc:
            contextPath + "/api/v1/admin/merchants/kyc",

        createOrder:
            contextPath + "/api/v1/orders",

        myOrders:
            contextPath + "/api/v1/orders",
            
        getOrder:
            contextPath + "/api/v1/orders",

        getMerchant:
            contextPath + "/api/v1/admin/Getmerchant",

        suspendMerchant:
            contextPath + "/api/v1/admin/SuspendMerchant",

        webhook:
            contextPath + "/api/v1/webhook-config"

    };
    
    /* JSP / UI URLs */

    const UI = {

        myOrdersPage:
            contextPath + "/merchant/my-orders"

    };


    /*
     * ============================================================
     * TOKEN FUNCTIONS
     * ============================================================
     */


    function getAdminToken() {

        const token =
            sessionStorage.getItem("adminAccessToken");

        if (!token) {

            alert("Please first login as platform admin.");

            return null;
        }

        return token;
    }


    function getMerchantToken() {

        const token =
            sessionStorage.getItem("merchantAccessToken");

        if (!token) {

            alert("Please first login as merchant.");

            return null;
        }

        return token;
    }



    /*
     * ============================================================
     * COMMON API CALL FUNCTION
     * ============================================================
     */

    async function callApi(url, options = {}) {

        try {

            const response =
                await fetch(url, options);


            const contentType = response.headers.get("content-type") || "";


            let data;


            if (contentType.includes("application/json")) {

                data = await response.json();

            } else {

                data = await response.text();

            }


            if (!response.ok) {

                throw {

                    status: response.status,

                    data: data

                };

            }


            return data;


        } catch (error) {

            throw error;

        }

    }



    /*
     * ============================================================
     * DISPLAY API RESPONSE
     * ============================================================
     */

    function showResponse(elementId, data, success = true) {

        const element =
            document.getElementById(elementId);


        element.className =
            success
                ? "response success-response"
                : "response error-response";


        let output;


        if (typeof data === "string") {

            output = data;

        } else {

            output =
                JSON.stringify(data, null, 4);

        }


        element.innerHTML =
            "<pre>" +
            escapeHtml(output) +
            "</pre>";

    }



    /*
     * ============================================================
     * HTML ESCAPE
     * ============================================================
     */

    function escapeHtml(value) {

        return String(value)

            .replace(/&/g, "&amp;")

            .replace(/</g, "&lt;")

            .replace(/>/g, "&gt;")

            .replace(/"/g, "&quot;")

            .replace(/'/g, "&#039;");

    }



    /*
     * ============================================================
     * 1. REGISTER MERCHANT
     * ============================================================
     */

    document
        .getElementById("registerMerchantForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const merchantData = {

                legalName:
                    document.getElementById("legalName").value.trim(),

                email:
                    document.getElementById("email").value.trim(),

                phone:
                    document.getElementById("phone").value.trim(),

                panNumber:
                    document.getElementById("panNumber").value.trim(),

                gstNumber:
                    document.getElementById("gstNumber").value.trim(),

                settlementAccountId:
                    document.getElementById("settlementAccountId").value.trim(),

                adminUsername:
                    document.getElementById("adminUsername").value.trim(),

                adminPassword:
                    document.getElementById("adminPassword").value,

                role:
                    document.getElementById("role").value

            };


            try {

                const data =
                    await callApi(

                        API.registerMerchant,

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json"

                            },

                            body:
                                JSON.stringify(merchantData)

                        }

                    );


                showResponse(
                    "registrationResponse",
                    data,
                    true
                );


                document
                    .getElementById("registerMerchantForm")
                    .reset();


            } catch (error) {

                showResponse(
                    "registrationResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 2. PLATFORM ADMIN LOGIN
     * ============================================================
     */

    document
        .getElementById("adminLoginForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const loginData = {

                username:
                    document
                        .getElementById("adminLoginUsername")
                        .value
                        .trim(),

                password:
                    document
                        .getElementById("adminLoginPassword")
                        .value

            };


            try {

                const data =
                    await callApi(

                        API.adminLogin,

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json"

                            },

                            body:
                                JSON.stringify(loginData)

                        }

                    );


                /*
                 * Store JWT token in browser session.
                 */

                if (data.accessToken) {

                    sessionStorage.setItem(
                        "adminAccessToken",
                        data.accessToken
                    );

                }


                showResponse(
                    "adminLoginResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "adminLoginResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 3. MERCHANT LOGIN
     * ============================================================
     */

    document
        .getElementById("merchantLoginForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const loginData = {

                username:
                    document
                        .getElementById("merchantLoginUsername")
                        .value
                        .trim(),

                password:
                    document
                        .getElementById("merchantLoginPassword")
                        .value

            };


            try {

                const data =
                    await callApi(

                        API.merchantLogin,

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json"

                            },

                            body:
                                JSON.stringify(loginData)

                        }

                    );


                /*
                 * Store merchant JWT.
                 */

                if (data.accessToken) {

                    sessionStorage.setItem(
                        "merchantAccessToken",
                        data.accessToken
                    );

                }


                showResponse(
                    "merchantLoginResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "merchantLoginResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 4. UPDATE KYC
     * ============================================================
     */

    document
        .getElementById("kycForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const token =
                getAdminToken();


            if (!token) {

                return;

            }


            const kycData = {

                merchantId:
                    Number(
                        document
                            .getElementById("kycMerchantId")
                            .value
                    ),

                kycStatus:
                    document
                        .getElementById("kycStatus")
                        .value,

                remarks:
                    document
                        .getElementById("kycRemarks")
                        .value
                        .trim()

            };


            try {

                const data =
                    await callApi(

                        API.updateKyc,

                        {

                            method: "PUT",

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token

                            },

                            body:
                                JSON.stringify(kycData)

                        }

                    );


                showResponse(
                    "kycResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "kycResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 5. APPROVE / UPDATE MERCHANT STATUS
     * ============================================================
     */

     document
     .getElementById("approveMerchantForm")
     .addEventListener("submit", async function(event) {

         event.preventDefault();

         const token = getAdminToken();

         if (!token) {
             return;
         }

         const merchantId =
             Number(
                 document.getElementById("approveMerchantId").value
             );

         const status = document.getElementById("approveStatus").value;

         const statusData = {
             status: status
         };

         try {

             const data = await callApi(

                 contextPath + "/api/v1/admin/merchants/" + merchantId + "/approve",

                 {
                     method: "PUT",

                     headers: {
                         "Content-Type": "application/json",
                         "Authorization": "Bearer " + token
                     },

                     body: JSON.stringify(statusData)
                 }

             );

             showResponse(
                 "approveResponse",
                 data,
                 true
             );

         } catch (error) {

             showResponse(
                 "approveResponse",
                 error.data || error,
                 false
             );
         }
     });


    /*
     * ============================================================
     * 6. CREATE ORDER
     * ============================================================
     */

    document
        .getElementById("createOrderForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const token =
                getMerchantToken();


            if (!token) {

                return;

            }


            const orderData = {

                orderRef:
                    document
                        .getElementById("orderRef")
                        .value
                        .trim(),

                amount:
                    Number(
                        document
                            .getElementById("orderAmount")
                            .value
                    ),

                currency:
                    document
                        .getElementById("orderCurrency")
                        .value
                        .trim(),

                customerEmail:
                    document
                        .getElementById("customerEmail")
                        .value
                        .trim()

            };


            try {

                const data =
                    await callApi(

                        API.createOrder,

                        {

                            method: "POST",
                            
                            

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token

                            },

                            body:
                                JSON.stringify(orderData)

                        }

                    );


                showResponse(
                    "orderResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "orderResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 7. GET MY ORDERS
     * ============================================================
     */

//     document
//         .getElementById("myOrdersButton")
//         .addEventListener("click", async function() {


//             const token =
//                 getMerchantToken();


//             if (!token) {

//                 return;

//             }


//             try {

//                 const data =
//                     await callApi(

//                         API.myOrders,

//                         {

//                             method: "GET",

//                             headers: {

//                                 "Authorization":
//                                     "Bearer " + token

//                             }

//                         }

//                     );


//                 showResponse(
//                     "myOrdersResponse",
//                     data,
//                     true
//                 );


//             } catch (error) {

//                 showResponse(
//                     "myOrdersResponse",
//                     error.data || error,
//                     false
//                 );

//             }

//         });
    
    document
    .getElementById("myOrdersButton")
    .addEventListener("click", function() {

        window.location.href = UI.myOrdersPage;

    });



    /*
     * ============================================================
     * 8. GET SINGLE ORDER
     * ============================================================
     */

     document
     .getElementById("singleOrderForm")
     .addEventListener("submit", async function(event) {

         event.preventDefault();

         const token = getMerchantToken();

         if (!token) {
             return;
         }

         const orderRef =
             document
                 .getElementById("singleOrderRef")
                 .value
                 .trim();

         if (!orderRef) {
             showResponse(
                 "singleOrderResponse",
                 "Order reference is required",
                 false
             );
             return;
         }

         try {

             const data = await callApi(
                 API.getOrder +
                 "/" +
                 encodeURIComponent(orderRef),

                 {
                     method: "GET",

                     headers: {
                         "Authorization": "Bearer " + token
                     }
                 }
             );

             showResponse(
                 "singleOrderResponse",
                 data,
                 true
             );

         } catch (error) {

             showResponse(
                 "singleOrderResponse",
                 error.data || error,
                 false
             );
         }
     });


    /*
     * ============================================================
     * 9. GET MERCHANT
     * ============================================================
     */

    document
        .getElementById("getMerchantButton")
        .addEventListener("click", async function() {


            const token =
                getAdminToken();


            if (!token) {

                return;

            }


            const merchantId =
                document
                    .getElementById("managementMerchantId")
                    .value;


            if (!merchantId) {

                alert("Please enter merchant ID.");

                return;

            }


            try {

                const data =
                    await callApi(

                        API.getMerchant +
                        "/" +
                        encodeURIComponent(merchantId),

                        {

                            method: "GET",

                            headers: {

                                "Authorization":
                                    "Bearer " + token

                            }

                        }

                    );


                showResponse(
                    "merchantManagementResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "merchantManagementResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 10. SUSPEND MERCHANT
     * ============================================================
     */

    document
        .getElementById("suspendMerchantButton")
        .addEventListener("click", async function() {


            const token =
                getAdminToken();


            if (!token) {

                return;

            }


            const merchantId =
                document
                    .getElementById("managementMerchantId")
                    .value;


            if (!merchantId) {

                alert("Please enter merchant ID.");

                return;

            }


            const confirmed =
                confirm(
                    "Are you sure you want to suspend this merchant?"
                );


            if (!confirmed) {

                return;

            }


            const suspendData = {

                merchantId:
                    Number(merchantId)

            };


            try {

                const data =
                    await callApi(

                    		 API.suspendMerchant +
                             "/" +
                             encodeURIComponent(merchantId),

                        {

                            method: "POST",

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token

                            },

                            body:
                                JSON.stringify(suspendData)

                        }

                    );


                showResponse(
                    "merchantManagementResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "merchantManagementResponse",
                    error.data || error,
                    false
                );

            }

        });



    /*
     * ============================================================
     * 11. WEBHOOK CONFIGURATION
     * ============================================================
     */

    document
        .getElementById("webhookForm")
        .addEventListener("submit", async function(event) {

            event.preventDefault();


            const token =
                getMerchantToken();


            if (!token) {

                return;

            }


            const webhookData = {

                url:
                    document
                        .getElementById("webhookUrl")
                        .value
                        .trim()

            };


            try {

                const data =
                    await callApi(

                        API.webhook,

                        {

                            method: "PUT",

                            headers: {

                                "Content-Type":
                                    "application/json",

                                "Authorization":
                                    "Bearer " + token

                            },

                            body:
                                JSON.stringify(webhookData)

                        }

                    );


                showResponse(
                    "webhookResponse",
                    data,
                    true
                );


            } catch (error) {

                showResponse(
                    "webhookResponse",
                    error.data || error,
                    false
                );

            }

        });

</script>

</body>

</html>