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


@WebServlet(value = "/sprint_brandlist")
public class AdminPanelBrandsServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  ArrayList<Brands> brands = DBConnector.getAllBrands();
  req.setAttribute("all_brands", brands);
  req.getRequestDispatcher("/sprint.brandlist.jsp").forward(req, resp);
 }
}

