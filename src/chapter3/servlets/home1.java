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
import java.util.ArrayList;


@WebServlet(value = "/c3home1")
public class home1 extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
ArrayList<Students> allStudents = DBConnector.getAllStudents();
req.setAttribute("students",allStudents);
req.getRequestDispatcher("/home1.jsp").forward(req,resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }
}
