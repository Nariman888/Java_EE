package chapter3.servlets;

import chapter3.db.DBConnector;
import chapter3.tasks.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/save_student")
public class SaveServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("student_id"));
  String name = req.getParameter("student_name");
  String surname = req.getParameter("student_surname");
  String birthdate = req.getParameter("student_birthdate");
  String city = req.getParameter("student_city");

  Students student = DBConnector.getStudent(id);

  if (student != null) {
   student.setName(name);
   student.setSurname(surname);
   student.setBirthdate(birthdate);
   student.setCity(city);

   DBConnector.saveStudent(student);

   resp.sendRedirect("/c3home1");
  }


 }
}
