package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Utility class for handling password hashing and validation.
 */
public class PasswordUtil {


     //Hashes a password using SHA-256 algorithm.
     //param password The password to hash.
     //return The hashed password in Base64 encoding.
    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }

     // @param password The password to check.
     // @param hashedPassword The stored hashed password.
     // @return true if passwords match, otherwise false.
    public static boolean verifyPassword(String password, String hashedPassword) {
        String hashedInputPassword = hashPassword(password);
        return hashedInputPassword != null && hashedInputPassword.equals(hashedPassword);
    }
}
