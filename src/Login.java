import com.mysql.cj.protocol.Resultset;
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


        //////////////////////////////////////////////////

        //label for username
        username = new JLabel(" Username: ");
        username.setBounds(180, 210,170,50);
        username.setForeground(new Color(112,112,112));
        username.setBackground(Color.blue);
        username.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
        username.setFont(new Font("Arial",Font.BOLD,28));
        frame.add(username);

        //label for passsword
        password = new JLabel(" Password: ");
        password.setBounds(180, 280,170,50);
        password.setForeground(new Color(112,112,112));
        password.setBackground(Color.blue);
        password.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
        password.setFont(new Font("Arial",Font.BOLD,28));
        frame.add(password);

        //Textfield for username
        e_username = new TextField();
        e_username.setBounds(410, 210,300,50);
        e_username.setFont(new Font("Arial",Font.BOLD,30));
        frame.add(e_username);

        //passwordfield for password
        e_password = new JPasswordField();
        e_password.setBounds(410, 280,300,50);
        frame.add(e_password);


        //Button for Login
        login = new JButton(" Login");
        login.setFont(new Font("arial",Font.BOLD,27));
        login.setForeground(new Color(5,169,53));
        login.setBackground(Color.white);
        login.setBounds(492, 370,135,42);
        frame.add(login);

        //Button for Signup
        sign_up = new JButton("Sign up?/Register");
        sign_up.setFont(new Font("arial",Font.BOLD,27));
        sign_up.setForeground(Color.red);
        sign_up.setBackground(Color.white);
        sign_up.setBounds(418, 430,280,42);
        frame.add(sign_up);

        forgot_pass = new JButton("Forgot password?");
        forgot_pass.setFont(new Font("arial",Font.BOLD,27));
        forgot_pass.setForeground(Color.ORANGE);
        forgot_pass.setBackground(Color.white);
        forgot_pass.setBounds(418, 490,280,42);
        frame.add(forgot_pass);


        // adding actionlistener
        login.addActionListener(this);
        sign_up.addActionListener(this);
        forgot_pass.addActionListener(this);




        getContentPane().setBackground(Color.white);

        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {



        try{

            conn c1= new conn();
            String username = e_username.getText();
            String password = e_password.getSelectedText();
            String q = "select * from user_info where username = '"+username+"' and password = '"+password+ "'";
            Resultset rs = (Resultset) c1.s.executeQuery(q);

            if (e.getSource()==login){


            }
            else if(e.getSource()==sign_up){
                new sign_up().setVisible(true);
                frame.setVisible(false);


            }




        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }








    public static  void main( String [] args){
        new Login();


    }



}


