package chapter3.servlets;

import chapter3.db.DBConnector;
import chapter3.tasks.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/delete_student")
public class DeleteServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("student_id"));
  Students student = DBConnector.getStudent(id);

  if (student != null) {
   DBConnector.deleteStudent(student);
   resp.sendRedirect("/c3home1");
  }

 }
}
