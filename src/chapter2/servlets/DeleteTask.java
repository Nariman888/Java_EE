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


@WebServlet(value = "/delete")
public class DeleteTask extends HttpServlet {
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

  DBManager.deleteTask(taskId);

  resp.sendRedirect("/home2");
 }
}
