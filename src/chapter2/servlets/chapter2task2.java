package chapter2.servlets;

import chapter2.db.DBConnector;
import chapter2.db.DBManager;
import chapter2.tasks.News;
import chapter2.tasks.TaskManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/home2")
public class chapter2task2 extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
ArrayList<TaskManager> allTasks = DBManager.getAllTasks();
req.setAttribute("tasks",allTasks);
req.getRequestDispatcher("/c2home2.jsp").forward(req,resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }
}
