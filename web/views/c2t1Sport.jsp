<%@ page import="java.util.ArrayList" %>
<%@ page import="chapter2.tasks.News" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/21/2022
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="boots.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container w-100" style="padding-top: 16px">
<div class="row-cols-1">
    <%
        ArrayList<News> allNews=(ArrayList<News>) request.getAttribute("news");
        if(allNews!=null){
            for (News nw:allNews) {
                if(nw.getCategory().equalsIgnoreCase("sport")) {
    %>
    <div class="bg-danger w-100" >
        <div>
        <h3><%out.print(nw.getTitle());%></h3>
        </div>
        <div>
        <p><%=(nw.getContent())%></p>
        </div>
        <div>
        <p><label>Author:</label> <%=(nw.getAuthor())%></p>
        </div>
    </div>
<%
                }
            }
        }

%>
</div>

</div>
<div class="container">
<footer class="bg-light text-center text-lg-start">
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2022 Copyright:
        <a class="text-dark" href="#">Task1.com</a>
    </div>
    <!-- Copyright -->
</footer>
</div>

</body>
</html>
