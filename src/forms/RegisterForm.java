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

    public RegisterForm() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    registerUser(username, password);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                }
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
                JOptionPane.showMessageDialog(null, "Registration successful!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "User registration failed: " + e.getMessage());
        }
    }

    public JPanel getPanel() {
        return registerPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register Form");
        frame.setContentPane(new RegisterForm().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
