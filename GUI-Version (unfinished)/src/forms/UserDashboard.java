package forms;
import javax.swing.*;

public class UserDashboard {
    private JPanel userPanel;
    private JButton ACCSETTINGSButton;
    private JButton LOGOUTButton;
    private JButton PREPAREDNESSINVENTORYButton;
    private JButton DISASTERREADINESSButton;
    private JButton TRACKDISASTERButton;
    private JButton SUBMITHELPREQUESTButton;

    public JPanel getPanel() {
        return userPanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Dashboard");
        frame.setContentPane(new UserDashboard().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}