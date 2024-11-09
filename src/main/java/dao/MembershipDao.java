package dao;

import models.MembershipRequestModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembershipDao {
    private final String jdbcURL = "jdbc:postgresql://localhost:5432/auca_library_db";
    private final String jdbcUsername = "postgres";
    private final String jdbcPassword = "admin"; // Use the updated password h

    private static final String INSERT_MEMBERSHIP_SQL = "INSERT INTO memberships (studentid, membershipType, isApproved) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_REQUESTS = "SELECT id, studentid, membershipType, isApproved FROM memberships;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");  // Explicitly load PostgreSQL driver
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Database connection established.");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database. Please check the JDBC URL, username, and password.");
            e.printStackTrace();
        }
        if (connection == null) {
            System.err.println("Connection is null. Please verify database availability and credentials.");
        }
        return connection;
    }

    public void addMembershipRequest(MembershipRequestModel request) {
        Connection connection = getConnection();
        if (connection == null) {
            System.err.println("Database connection failed. Cannot proceed with adding membership request.");
            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEMBERSHIP_SQL)) {
            System.out.println("Executing insert with studentId: " + request.getStudentId() + " and membershipType: " + request.getMembershipType());

            preparedStatement.setInt(1, request.getStudentId());
            preparedStatement.setString(2, request.getMembershipType());
            preparedStatement.setBoolean(3, request.isApproved());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            if (rowsAffected == 0) {
                System.err.println("No rows inserted. Check if the data meets database constraints.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<MembershipRequestModel> getAllRequests() throws SQLException {
        List<MembershipRequestModel> requests = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REQUESTS)) {
            if (connection == null) {
                System.err.println("Connection failed. Cannot execute SELECT statement.");
                return requests;
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int studentId = rs.getInt("studentId");
                String membershipType = rs.getString("membershipType");
                boolean isApproved = rs.getBoolean("isApproved");
                requests.add(new MembershipRequestModel(id, studentId, membershipType, isApproved));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public void approveRequest(int id) throws SQLException {
        String updateSQL = "UPDATE memberships SET isApproved = true WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
            if (connection == null) {
                System.err.println("Connection failed. Cannot execute UPDATE statement.");
                return;
            }
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
