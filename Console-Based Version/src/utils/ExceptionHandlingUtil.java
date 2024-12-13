package utils;
import java.sql.SQLException;

public class ExceptionHandlingUtil {

    public static void handleSQLException(SQLException e) {
        System.err.println("SQLException: " + e.getMessage());
        System.err.println("SQLState: " + e.getSQLState());
        System.err.println("VendorError: " + e.getErrorCode());
        e.printStackTrace();
    }

    public static void handleException(Exception e) {
        System.err.println("Exception: " + e.getMessage());
        e.printStackTrace();
    }
    public static void clearScreen() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void handleNumberFormatException(NumberFormatException e) {
        System.err.println("Invalid number format: " + e.getMessage());
    }
}
