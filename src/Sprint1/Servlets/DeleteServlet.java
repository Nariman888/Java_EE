package Sprint1.Servlets;

import Sprint1.DB.DBConnector;
import Sprint1.model.Items;
import Sprint1.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/sprint_delete_items")
public class DeleteServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("item_id"));
  Items item = DBConnector.getItem(id);

  if (item != null) {
   DBConnector.deleteItem(item);
   resp.sendRedirect("/sprint_admin");
  }
 }
}
