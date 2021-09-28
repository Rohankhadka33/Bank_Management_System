
import javafx.scene.control.PasswordField;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame implements ActionListener {

    private JLabel username,password;
    private TextField e_username;
    private JPasswordField e_password;
    private JButton login,sign_up,forgot_pass;
    private JFrame frame;
    private JLabel back_image;
    private JPanel panel;


    public Login() {

        frame = new JFrame();
        frame.setTitle("Bank Management System");
        frame.setSize(900, 600);
        frame.setResizable(false);


        //making window to appear in the centre of screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()));
        int y = (int) ((dimension.getHeight() - frame.getHeight()));
        frame.setLocation(x / 2, y / 2);

