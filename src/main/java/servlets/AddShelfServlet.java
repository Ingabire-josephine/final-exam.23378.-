package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ShelfDao;
import models.Shelf;

//@WebServlet("/addShelf")
public class AddShelfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final ShelfDao shelfDao = new ShelfDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Shelf newShelf = new Shelf(id);

        try {
            shelfDao.addShelf(newShelf);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("librarianDashboard.jsp");
    }
}
