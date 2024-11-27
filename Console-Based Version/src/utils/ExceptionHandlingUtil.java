package utils;

import java.sql.SQLException;

/**
 * Utility class for handling exceptions.
 */
public class ExceptionHandlingUtil {

    /**
     * Centralized method for handling SQLException and printing relevant details.
     *
     * @param e The SQLException to handle.
     */
    public static void handleSQLException(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("VendorError: " + e.getErrorCode());
        e.printStackTrace();
    }

    /**
     * Centralized method for handling general exceptions and printing relevant details.
     *
     * @param e The Exception to handle.
     */
    public static void handleException(Exception e) {
        System.err.println("Exception: " + e.getMessage());
        e.printStackTrace();
    }
}
