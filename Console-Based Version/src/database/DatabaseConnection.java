package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Manages the connection to the database.
 * Implements abstraction to hide connection details from other parts of the application.
 */
public class DatabaseConnection {

    // Encapsulating database details
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/Crisis Compass";
    private static final String DATABASE_USER = "raim";
    private static final String DATABASE_PASSWORD = "Dagon086"; // Replace with actual password

    // Singleton instance of the connection
    private static Connection connection;

    /**
     * Establishes a connection to the database, if not already connected.
     *
     * @return the database connection instance
     * @throws SQLException if a connection error occurs
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
                System.out.println("Database connection established successfully.");
            } catch (SQLException e) {
                System.err.println("Failed to establish database connection: " + e.getMessage());
                throw e; // Re-throwing the exception for higher-level handling
            }
        }
        return connection;
    }

    /**
     * Closes the database connection if it is open.
     */
    public static void closeConnection() {
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
