package servlets;

import dao.BookDao;
import models.BookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/addBook")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final BookDao bookDao = new BookDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String shelfIdParam = request.getParameter("shelfId");

        if (shelfIdParam != null && !shelfIdParam.isEmpty()) {
            try {
                int shelfId = Integer.parseInt(shelfIdParam);
                BookModel newBook = new BookModel(name, author, shelfId);
                bookDao.addBook(newBook);  // Add book to the database
                response.sendRedirect("viewBooks.jsp");  // Redirect to JSP page to display books
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Shelf ID must be a valid integer.");
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding book to the database.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Shelf ID is required.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<BookModel> books = bookDao.getAllBooks();
            request.setAttribute("books", books);
            request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving books from the database.");
        }
    }
}
