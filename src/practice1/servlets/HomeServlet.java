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
import java.util.ArrayList;

@WebServlet(value = "/wer")
public class HomeServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  ArrayList<ZAKAZ> allOrders = DBManager.getAllOrders();

  PrintWriter out =resp.getWriter();
  out.print("<html>");
  out.print("<head>");
  out.print("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" " +
          "rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" "
          + "crossorigin=\"anonymous\">");
  out.print("</head>");
  out.print("<body>");
  out.print("<form action = '/addorder' method = 'post'> ");
  out.print("<table class=\"table table-dark table-striped\">");
  out.print("<tbody>");
  out.print("<tr><th>NAME : </th><th><input type = 'text' placeholder = 'Insert name' name = 'name'></tr>");
  out.print("<tr><th>SURNAME : </th><th><input type = 'text' placeholder = 'Insert name' name = 'surname'></tr>");
  out.print("<tr><th>FOOD : </th><th><select name = 'food'><option>Burger - 2000 KZT</option>");
  out.print("<option>Pizza - 3000 KZT</option>");
  out.print("<option>Doner - 1200 KZT</option>");
  out.print("</select></th></tr>");
  out.print("<tr><th><button>ADD ITEM</button></th></tr>");
  out.print("</tbody>");
  out.print("</table>");
  out.print("</form>");

  out.print("</body>");
  out.print("</html>");

 }


 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

 }
}
