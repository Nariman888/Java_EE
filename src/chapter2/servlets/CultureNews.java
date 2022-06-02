package chapter2.servlets;

import chapter2.db.DBManager;
import chapter2.tasks.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/culture_news")
public class CultureNews extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  ArrayList<News> allNews = DBManager.getAllNews();
  req.setAttribute("news",allNews);
  req.getRequestDispatcher("/c2t1Culture.jsp").forward(req,resp);
 }

 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 }
}
