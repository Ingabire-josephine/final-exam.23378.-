package dao;

import models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/auca_library_db";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "admin";

    private static final String INSERT_USER_SQL = "INSERT INTO userss (username, address, phone, role, password) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM userss WHERE username = ? AND password = ?";
    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM userss";

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

    public boolean registerUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.setString(5, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Example for retrieving user by username and password
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("role"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Example for retrieving all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("role"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
