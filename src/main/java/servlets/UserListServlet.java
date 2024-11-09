package servlets;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listOfUsers")
public class UserListServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userLists = userDao.getAllUsers();
        System.out.println("Number of users retrieved: " + (userLists != null ? userLists.size() : "null"));

        if (userLists != null) {
            request.setAttribute("userList", userLists);
            request.getRequestDispatcher("listUsers.jsp").forward(request, response); // Forwarding to JSP
        } else {
            response.sendRedirect("errorPage.jsp"); // Redirect to error page if list is null
        }
    }
}
