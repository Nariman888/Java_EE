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


@WebServlet(value = "/sprint_brands_details")
public class BrandsDetailsServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String id=req.getParameter("brand_id");
Long brandsId=null;
try{
brandsId=Long.parseLong(id);
}catch (Exception e) {
}

Brands brands = DBConnector.getBrand(brandsId);
if (brands!=null) {
req.setAttribute("one_brand",brands);
req.getRequestDispatcher("/sprint.brandlist_details.jsp").forward(req,resp);
} else {
req.getRequestDispatcher("/404.jsp").forward(req,resp);
}
  }
 }