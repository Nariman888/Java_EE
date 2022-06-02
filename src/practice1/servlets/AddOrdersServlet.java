package practice1.servlets;

import practice1.application.ZAKAZ;
import practice1.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/addorder")
public class AddOrdersServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String name = req.getParameter("name");
  String surname = req.getParameter("surname");
  String food = req.getParameter("food");
  resp.setContentType("text/html");
  ZAKAZ zakaz=new ZAKAZ();
  zakaz.setName(name);
  zakaz.setSurname(surname);
  zakaz.setFood(food);

  DBManager.addOrders(zakaz);

  PrintWriter out = resp.getWriter();
  out.print("<h1>"+name+" "+surname+" ordered "+food+"</h1>");
 }
}
