package chapter3.servlets;

import chapter2.db.DBManager;
import chapter2.tasks.TaskManager;
import chapter3.db.DBConnector;
import chapter3.tasks.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/details33")
public class Details3 extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String id = req.getParameter("student_id");
  Long StudentId = null;
  try {
   StudentId=Long.parseLong(id);
  }catch (Exception e){
   e.printStackTrace();
  }
  Students student = DBConnector.getStudent(StudentId);
  if(student!=null){
   req.setAttribute("student",student);
   req.getRequestDispatcher("/details3.jsp").forward(req,resp);
  }
  req.getRequestDispatcher("/404.jsp");
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 }
}
