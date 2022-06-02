package chapter3.servlets;

import chapter3.db.DBConnector;
import chapter3.tasks.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/add_student")
public class AddStudent extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String name = req.getParameter("student_name");
  String surname = req.getParameter("student_surname");
  String birthdate = req.getParameter("student_birthdate");
  String city = req.getParameter("student_city");

  Students student = new Students();
  student.setName(name);
  student.setSurname(surname);
  student.setBirthdate(birthdate);
  student.setCity(city);

  DBConnector.addStudent(student);

  resp.sendRedirect("/c3home1");
 }
}
