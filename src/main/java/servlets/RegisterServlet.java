package servlets;

import dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {
            User newUser = new User(username, address, phone, role, password);
            try {
                boolean success = userDao.registerUser(newUser);
                if (success) {
                    response.sendRedirect("register_success.jsp");
                } else {
                    response.sendRedirect("register_failure.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("register_failure.jsp");
            }
        } else {
            response.sendRedirect("register.jsp?error=Passwords do not match");
        }
    }
}
