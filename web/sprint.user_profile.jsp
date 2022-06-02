<%@ page import="Sprint1.model.Users" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/28/2022
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User profile</title>
    <%@include file="bootstr.jsp"%>
</head>
<%@include file="sprint.navbar.jsp"%>
<body>
<%
    Users user = (Users) request.getAttribute("user");
    if (user != null) {
%>
<h2 class="text-center mt-4">Hello <%=user.getFullName()%></h2>
<p class="text-black-50 text-center">This is your profile page</p>
<%
    }
%>
</div>

</body>
</html>
