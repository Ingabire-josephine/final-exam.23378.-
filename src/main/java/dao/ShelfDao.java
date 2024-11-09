package dao;

import models.Shelf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShelfDao {
	 private final String jdbcURL = "jdbc:postgresql://localhost:5432/auca_library_db";
	    private final String jdbcUsername = "postgres";
	    private final String jdbcPassword = "admin";

    private static final String INSERT_SHELF_SQL = "INSERT INTO shelf (id) VALUES (?);";
    private static final String SELECT_ALL_SHELVES = "SELECT * FROM shelf;";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            System.out.println("Failed to create connection to database.");
            e.printStackTrace();
        }
        return connection;
    }

    public void addShelf(Shelf shelf) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHELF_SQL)) {
            if (connection != null) {
                preparedStatement.setInt(1, shelf.getId());
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Connection is null. Cannot insert data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Shelf> getAllShelves() throws SQLException {
        List<Shelf> shelves = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHELVES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                shelves.add(new Shelf(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shelves;
    }
}
