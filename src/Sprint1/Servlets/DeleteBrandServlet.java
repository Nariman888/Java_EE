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


@WebServlet(value = "/sprint_delete_brand")
public class DeleteBrandServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("brand_id"));
  Brands brand = DBConnector.getBrand(id);

  if (brand != null) {
   boolean del = true;
   String redirect = "/sprint_brandlist";
   ArrayList<Items> items =DBConnector.getAllItems();

   if (items != null) {
    for (Items item : items) {
     if (item.getBrand().getId() == id) {
      redirect = "/sprint_brands_details?brand_id=" + id + "&wrong";
      del = false;
      break;
     }
    }
   }
   if (del) DBConnector.deleteBrand(brand);
   resp.sendRedirect(redirect);
  }
 }
}
