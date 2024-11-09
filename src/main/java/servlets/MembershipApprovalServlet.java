package servlets;

import dao.MembershipDao;
import models.MembershipRequestModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/approveMembership")
public class MembershipApprovalServlet extends HttpServlet {
    private final MembershipDao membershipDao = new MembershipDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<MembershipRequestModel> requests = membershipDao.getAllRequests();
            request.setAttribute("requests", requests);
            request.getRequestDispatcher("viewRequests.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentIdParam = request.getParameter("studentId");
        String membershipType = request.getParameter("membershipType");

        if (studentIdParam != null && !studentIdParam.isEmpty()) {
            try {
                int studentId = Integer.parseInt(studentIdParam);
                MembershipRequestModel newRequest = new MembershipRequestModel(studentId, membershipType, false);

                membershipDao.addMembershipRequest(newRequest);
                response.sendRedirect("studentDashboard.jsp");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp"); // Redirect to an error page or display an error message

                e.printStackTrace();
            }
        } else {
            // Handle missing or empty "studentId" parameter
            System.err.println("Student ID is missing or empty.");
            response.sendRedirect("error.jsp");
        }
    }
}
