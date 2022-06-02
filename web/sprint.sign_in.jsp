<%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/28/2022
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <%@include file="bootstr.jsp"%>
</head>
<body>
<%@include file="sprint.navbar.jsp"%>
<div class="bg-white">
    <div class="container">
        <%
            String error = request.getParameter("error");
            if (error != null) {
        %>
        <div class="col-8 row alert alert-danger alert-dismissible fade show mt-3 mx-auto" role="alert">
            <span>Incorrect <b>email</b> and <b>password</b>!!!</span>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
        <%
        } else {
        %>
        <div class="mt-3"></div>
        <%
            }
        %>
        <div class="col-8 card row border-light shadow rounded mx-auto">
            <div class="card-header bg-light">
                Login Page
            </div>
            <div class="card-body">
                <form action="/sprint_sign" method="post">
                    <div class="d-flex flex-row mt-3">
                        <label class="col-2">Email</label>
                        <input type="text" class="form-control" required name="user_email">
                    </div>
                    <div class="d-flex flex-row mt-3">
                        <label class="col-2">Password</label>
                        <input type="password" class="form-control" required name="user_password">
                    </div>
                    <div class="mt-3">
                        <button type="submit" class="btn btn-success btn-sm">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
