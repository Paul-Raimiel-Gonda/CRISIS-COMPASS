package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Encapsulating database details
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/schemaname";
    private static final String DATABASE_USER = "username";
    private static final String DATABASE_PASSWORD = "password";

    // Singleton instance of the DatabaseConnection
    private static DatabaseConnection instance;
    private Connection connection;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private DatabaseConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection: " + e.getMessage());
            throw e; // Re-throwing the exception for higher-level handling
        }
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.connection == null || instance.connection.isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }


     // Returns the current database connection.
    public Connection getConnection() {
        return connection;
    }

    // Closes the database connection if it is open.
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close database connection: " + e.getMessage());
        }
    }
}
