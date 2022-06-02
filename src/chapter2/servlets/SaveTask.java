package chapter2.servlets;

import chapter2.db.DBManager;
import chapter2.tasks.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/save")
public class SaveTask extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String id = req.getParameter("task_id");

  Long taskId = null;
  try {
   taskId = Long.parseLong(id);
  } catch (Exception e) {
   PrintWriter out=resp.getWriter();
   out.print("<h1>HELLO Fail!</h1>");
  }

  String name = req.getParameter("task_name");
  String description = req.getParameter("task_description");
  String deadline = req.getParameter("task_deadline");
  String status=req.getParameter("task_status");

  TaskManager task = new TaskManager();
  task.setId(taskId);
  task.setName(name);
  task.setDescription(description);
  task.setDeadlineDate(deadline);
  task.setStatus(status);

  DBManager.saveTask(taskId, task);

  resp.sendRedirect("/home2");
 }
}
