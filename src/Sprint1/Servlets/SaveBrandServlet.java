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


@WebServlet(value = "/sprint_save_brand")
public class SaveBrandServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  Long id = Long.parseLong(req.getParameter("brand_id"));
  String name = req.getParameter("brand_name");
  String country = req.getParameter("brand_country");

  Brands brand = DBConnector.getBrand(id);

  if (brand != null) {
   brand.setName(name);
   brand.setCountry(country);

   DBConnector.saveBrand(brand);

   resp.sendRedirect("/sprint_brandlist");
  }
 }
}
