<%@ page import="chapter3.tasks.Students" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/25/2022
  Time: 2:06 AM
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
    <div class="container pt-4">
        <div class="container pb-2">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" >+ Добавить задание</button>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="/add_student" method="post">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">NEW STUDENT</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="row mt-3">
                                <div class="col-12">
                                    <label>NAME: </label>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <input type="text" class="form-control" name="task_name">
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-12">
                                    <label>SURNAME: </label>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <input type="text" class="form-control" name="task_surname"></input>
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-12">
                                    <label>BIRTHDATE: </label>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <input type="date" class="form-control" name="task_birthdate">
                                </div>
                            </div>
                            <div class="row mt-3">
                                <div class="col-12">
                                    <label>CITY:</label>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <select class="form-select" name="task_city">
                                    <option>Pavlodar</option>
                                    <option>Almaty</option>
                                    <option>Astana</option>
                                    <option>Turkestan</option>
                                    <option>Karaganda</option>
                                    <option>Atyrau</option>
                                    <option>Petropavlsk</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary">ADD STUDENT</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <table class="table table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>SURNAME</th>
                    <th>BIRTHDATE</th>
                    <th>CITY</th>
                </tr>
                </thead>
                <tbody class="color1">
                <% ArrayList<Students> allStudents = (ArrayList<Students>) request.getAttribute("students");
                    if(allStudents!=null) {
                        for (Students s:allStudents) {

                %>
                <tr style="padding: 2px;">
                    <td><%=s.getId()%></td>
                    <td><%=s.getName()%></td>
                    <td><%=s.getSurname()%></td>
                    <td><%=s.getBirthdate()%></td>
                    <td><%=s.getCity()%></td>
                    <td>
                        <a href="/details33?student_id=<%=s.getId()%>" class="btn btn-primary button-style2 btn-sm">DETAILS</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
