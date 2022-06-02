<%@ page import="chapter2.tasks.TaskManager" %><%--
  Created by IntelliJ IDEA.
  User: Nari
  Date: 5/22/2022
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
  <%@include file="boots.jsp"%>
</head>
<body>
<div class="container"></div>
<%@include file="navbar2.jsp"%>

<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <div class="col-6 mx-auto">
                <%
                    TaskManager task = (TaskManager) request.getAttribute("task");
                   if (task!=null) {
                %>
                <form action="/save" method="post">
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Наименование : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" hidden name="task_id" required value="<%=task.getId()%>">
                            <input type="text" class="form-control" name="task_name" required
                                   placeholder="Name: " value="<%=task.getName()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Описание : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                                        <textarea type="text" class="form-control" name="task_description"
                                                  required placeholder="Description: "><%=task.getDescription("description")%></textarea>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Крайний срок : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="text" class="form-control" name="task_deadline"
                                   value="<%=task.getDeadlineDate()%>">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>Выполнено : </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <select class="form-select" name="task_status">
                                <option>YES</option>
                                <option>NO</option>
                            </select>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-2 d-flex">
                            <button class="btn btn-success">Сохранить</button>
                            <button  name="task_id" class="btn btn-danger ms-3" formaction="/delete" formmethod="post">Удалить</button>
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
