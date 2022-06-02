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


@WebServlet(value = "/sprint_sign")
public class SignServlet extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  req.getRequestDispatcher("/sprint.sign_in.jsp").forward(req, resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  String email = req.getParameter("user_email");
  String password = req.getParameter("user_password");

  ArrayList<Users> users =DBConnector.getAllUsers();
  if (users != null) {
   for (Users user : users) {
    if (user.getEmail().equals(email) && user.getPassword().equals(password)){
     req.setAttribute("user", user);
     req.getRequestDispatcher("/sprint.user_profile.jsp").forward(req, resp);
    }
   }
  }
  resp.sendRedirect("/sprint_sign?error");
 }
}
