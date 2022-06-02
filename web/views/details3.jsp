<%@ page import="chapter3.tasks.Students" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/25/2022
  Time: 3:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../bootstr.jsp"%>
</head>
<body>
<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <div class="col-6 mx-auto">
                <%
                    Students students = (Students) request.getAttribute("student");
                    if (students!=null) {
                %>
                <form action="/edit" method="get">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>NAME </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" hidden name="student_id" required value="<%=students.getId()%>">
                            <input type="text" class="form-control" name="student_name" required
                                   placeholder="Name: " value="<%=students.getName()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>SURNAME</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                                        <input type="text" class="form-control" name="student_surname"
                                               value=" <%=students.getSurname()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>BIRTHDATE: </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="student_birthdate"
                                   value="<%=students.getBirthdate()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>CITY:</label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="student_city"
                            value="<%=students.getCity()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-primary">EDIT STUDENT</button>
                        </div>
                    </div>
                </form>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
