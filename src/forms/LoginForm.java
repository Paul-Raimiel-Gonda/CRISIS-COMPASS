package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel loginPanel;
    private JLabel GAMELabel;
    private JFrame frame;

    public LoginForm(JFrame frame) {
        this.frame = frame;  // Initialize the frame reference

        // Login button functionality
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    loginUserOrAdmin(username, password);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter your username and password.");
                }
            }
        });

        // Register button functionality
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegisterForm(); // Call method to open registration form
            }
        });

        // Add a listener to handle window resizing (fullscreen to windowed)
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Check if the window is NOT in fullscreen mode
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH) {
                    // Set the frame to a small minimum size when windowed
                    frame.setSize(1920, 1080); // Minimum size when not fullscreen
                }
            }
        });
    }

    private void openRegisterForm() {
        // Close the current frame (LoginForm) and open RegisterForm
        frame.dispose(); // Close the LoginForm frame
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setContentPane(new RegisterForm(registerFrame).getPanel()); // Pass the registerFrame to RegisterForm
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.pack();
        registerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        registerFrame.setVisible(true);
    }

    // Check if it's a user or admin trying to log in
    private void loginUserOrAdmin(String username, String password) {
        if (checkAdminLogin(username, password)) {
            openAdminDashboard();
        } else if (checkUserLogin(username, password)) {
            openUserDashboard();
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Invalid credentials. Please try again.");
        }
    }

    // Check login for admins
    private boolean checkAdminLogin(String adminUsername, String adminPassword) {
        String query = "SELECT * FROM admins WHERE adminusername = ? AND adminpassword = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, adminUsername);
            stmt.setString(2, adminPassword);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Returns true if admin login is successful
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Admin login failed: " + e.getMessage());
        }
        return false;
    }

    // Check login for regular users
    private boolean checkUserLogin(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Returns true if user login is successful
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "User login failed: " + e.getMessage());
        }
        return false;
    }

    // Open admin dashboard
    private void openAdminDashboard() {
        JFrame adminFrame = new JFrame("Admin Dashboard");
        adminFrame.setContentPane(new AdminDashboard().getPanel());
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.pack();
        adminFrame.setVisible(true);
    }

    // Open user dashboard
    private void openUserDashboard() {
        JFrame userFrame = new JFrame("User Dashboard");
        userFrame.setContentPane(new UserDashboard().getPanel());
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.pack();
        userFrame.setVisible(true);
    }

    public JPanel getPanel() {
        return loginPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setContentPane(new LoginForm(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);// Start in fullscreen
        frame.setVisible(true);
    }
}
