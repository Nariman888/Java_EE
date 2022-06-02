package Sprint1.Servlets;

import Sprint1.DB.DBConnector;
import Sprint1.model.Brands;
import Sprint1.model.Items;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/sprint_items_details")
public class ItemsDetailsServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String id=req.getParameter("items_id");
Long itemId=null;
try{
itemId=Long.parseLong(id);
}catch (Exception e) {
}

Items items=DBConnector.getItem(itemId);
if (items!=null) {
ArrayList<Brands>brands =DBConnector.getAllBrands();
req.setAttribute("all_brands",brands);
 req.setAttribute("one_item", items);
 req.getRequestDispatcher("/sprint.details.jsp").forward(req, resp);
} else {
 req.getRequestDispatcher("/404.jsp").forward(req, resp);
}
  }
 }