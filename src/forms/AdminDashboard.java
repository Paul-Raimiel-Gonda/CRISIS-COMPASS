package forms;
import javax.swing.*;

public class AdminDashboard {
    private JPanel adminPanel;

    public JPanel getPanel() {
        return adminPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setContentPane(new AdminDashboard().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}