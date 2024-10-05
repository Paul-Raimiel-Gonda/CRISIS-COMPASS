package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterForm {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JPanel registerPanel;
    private JLabel REGISTERMENULabel;
    private JButton returnButton;
    private JFrame frame;

    // Updated constructor to accept the current frame
    public RegisterForm(JFrame frame) {
        this.frame = frame;

        // Register button functionality
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    registerUser(username, password);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!");
                }
            }
        });

        // Return button functionality
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnToLoginForm(); // Return to the login form
            }
        });
    }

    // Register users into the 'users' table
    private void registerUser(String username, String password) {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(frame, "Registration successful!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "User registration failed: " + e.getMessage());
        }
    }

    // Method to handle return to the login form
    private void returnToLoginForm() {
        // Close the current RegisterForm frame
        frame.dispose();

        // Create and show the LoginForm
        JFrame loginFrame = new JFrame("Login Form");
        loginFrame.setContentPane(new LoginForm(loginFrame).getPanel());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setSize(1920, 1080);// Make fullscreen
        loginFrame.setVisible(true);
    }

    public JPanel getPanel() {
        return registerPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register Form");
        frame.setContentPane(new RegisterForm(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
}
