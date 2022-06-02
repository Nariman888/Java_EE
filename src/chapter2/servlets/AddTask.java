package chapter2.servlets;

import chapter2.db.DBManager;
import chapter2.tasks.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/addTask")
public class AddTask extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name=req.getParameter("task_name");
String description=req.getParameter("task_description");
String deadlineDate = req.getParameter("task_deadline");

TaskManager task = new TaskManager();
task.setName(name);
task.setDescription(description);
task.setDeadlineDate(deadlineDate);

DBManager.addTask(task);

resp.sendRedirect("/home2");
 }
}
