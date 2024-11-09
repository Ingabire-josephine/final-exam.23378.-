package dao;

import models.BorrowModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao {
	 private final String jdbcURL = "jdbc:postgresql://localhost:5432/auca_library_db";
	    private final String jdbcUsername = "postgres";
	    private final String jdbcPassword = "admin";

    private static final String INSERT_BORROW_SQL = "INSERT INTO borrows (bookId, studentId, borrowDate, returnDate, isReturned, fine) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_BORROWS = "SELECT id, bookId, studentId, borrowDate, returnDate, isReturned, fine FROM borrows;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addBorrow(BorrowModel borrow) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_SQL)) {
            preparedStatement.setInt(1, borrow.getBookId());
            preparedStatement.setInt(2, borrow.getStudentId());
            preparedStatement.setDate(3, new java.sql.Date(borrow.getBorrowDate().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(borrow.getReturnDate().getTime()));
            preparedStatement.setBoolean(5, borrow.isReturned());
            preparedStatement.setDouble(6, borrow.getFine());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}