package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for validating user inputs.
 */
public class InputValidationUtil {

    /**
     * Validates an email address using regex.
     *
     * @param email The email to validate.
     * @return true if the email is valid, otherwise false.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validates a phone number (e.g., for 10 digits).
     *
     * @param phoneNumber The phone number to validate.
     * @return true if the phone number is valid, otherwise false.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
