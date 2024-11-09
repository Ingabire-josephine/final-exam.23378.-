package servlets;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate user based on username and password
        User user = userDao.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            // Redirect based on user role
            String role = user.getRole().toLowerCase();

            if ("librarian".equals(role)) {
                response.sendRedirect("librarianDashboard.jsp");
            } else if ("student".equals(role) || "lecturer".equals(role)) {
                response.sendRedirect("studentDashboard.jsp");
            } else if ("dean".equals(role) || "manager".equals(role) || "hod".equals(role)) {
                response.sendRedirect("hodDashboard.jsp");
            } else {
                response.sendRedirect("login.jsp"); // Redirect to login if role is unknown
            }
        } else {
            // Redirect back to login page with error message if login fails
            response.sendRedirect("index.jsp?error=true");
        }
    }
}
