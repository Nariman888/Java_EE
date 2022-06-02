<%@ page import="chapter2.tasks.TaskManager" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/22/2022
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TaskManager</title>
    <%@include file="boots.jsp"%>
</head>
<body>
<div class="container">
<%@include file="navbar2.jsp"%>
<div class="container pt-4">
    <div class="container pb-2">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" >+ Добавить задание</button>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/addTask" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Новое задание</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Наименование: </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="text" class="form-control" name="task_name">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Описание: </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <textarea type="text" class="form-control" name="task_description"></textarea>
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">
                                            <label>Крайний срок: </label>
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-12">
                                            <input type="date" class="form-control" name="task_deadline">
                                        </div>
                                    </div>
                                    <div class="row mt-3">
                                        <div class="col-12">

                                        </div>
                                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary">Добавить</button>
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
                <th>Нименование</th>
                <th>Крайний срок</th>
                <th>Выполнено</th>
                <th>Детали</th>
            </tr>
            </thead>
            <tbody class="color1">
            <% ArrayList<TaskManager> allTasks = (ArrayList<TaskManager>) request.getAttribute("tasks");
            if(allTasks!=null) {
                for (TaskManager ts:allTasks) {

            %>
            <tr style="padding: 2px;">
                <td><%=ts.getId()%></td>
                <td><%=ts.getName()%></td>
                <td><%=ts.getDeadlineDate()%></td>
                <td><%=ts.getStatus()%></td>
                <td>
                    <a href="/details?id=<%=ts.getId()%>" class="btn btn-primary button_style2 btn-sm">Детали</a>
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
