package Sprint1.Servlets;

import Sprint1.DB.DBConnector;
import Sprint1.model.Items;
import chapter3.tasks.Students;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/sprint_home")
public class HomeServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
ArrayList<Items> allItems = DBConnector.getAllItems();
req.setAttribute("all_items",allItems);
req.getRequestDispatcher("/sprint.home.jsp").forward(req,resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }
}
