import javax.swing.*;
import forms.*;


public class GAME {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME: Gaming Access and Media Emporium - Login");
        frame.setContentPane(new LoginForm(frame).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}