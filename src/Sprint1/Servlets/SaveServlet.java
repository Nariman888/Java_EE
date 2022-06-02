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


@WebServlet(value = "/sprint_save_items")
public class SaveServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("item_id"));
  String name = req.getParameter("item_name");
  String desc = req.getParameter("item_description");
  String price = req.getParameter("item_price");
  Long brand_id = Long.parseLong(req.getParameter("brand_id"));

  Brands brand = DBConnector.getBrand(brand_id);

  if (brand != null) {

   Items item = DBConnector.getItem(id);

   if (item != null) {
    item.setName(name);
    item.setDescription(desc);
    item.setPrice(Double.parseDouble(price));
    item.setBrand(brand);

    DBConnector.saveItem(item);
   }

   resp.sendRedirect("/sprint_admin");
  }
 }
}
