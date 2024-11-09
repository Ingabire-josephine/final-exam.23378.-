package dao;

import models.BookModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/auca_library_db";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "admin";
    private static final String INSERT_BOOK_SQL = "INSERT INTO book (bookname, bookauthor, shelfid) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM book;";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void addBook(BookModel book) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getShelfid());
            preparedStatement.executeUpdate();
        }
    }

    public List<BookModel> getAllBooks() throws SQLException {
        List<BookModel> books = new ArrayList<>();
        String query = "SELECT id, bookname, bookauthor, shelfid FROM book";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String bookName = resultSet.getString("bookname");
                String bookAuthor = resultSet.getString("bookauthor");
                int shelfId = resultSet.getInt("shelfid");

                BookModel book = new BookModel(id, bookName, bookAuthor, shelfId);
                books.add(book);
            }
        }
        return books;
    }
}
