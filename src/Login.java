import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("All")
public class Login extends JFrame implements ActionListener {

    Conn c2 = new Conn();

    private JLabel email,password,welc;
    private TextField e_email;
    private JPasswordField e_password;
    private JButton login,sign_up,forgot_pass;
    public JFrame frame;

    private JLabel back_image;
    private JPanel panel;



    public void fr(){
        frame.setVisible(false);

    }



    public Login(){

        frame = new JFrame();
        frame.setTitle("Bank Management System");
        frame.setSize(900,600);
        frame.setResizable(false);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.decode("#eab676"));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Welcoming user

        String a= "Credentials Saving System!";
        welc = new JLabel(a);
        welc.setFont(new Font("Arial", Font.BOLD, 60));
        welc.setBounds(50, 60, 800, 80);
        welc.setForeground(Color.decode("#2E1AE2"));
        frame.add(welc);



        //making window to appear in the centre of screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()-frame.getWidth()));
        int y = (int) ((dimension.getHeight()-frame.getHeight() ));
        frame.setLocation(x/2,y/2);

        //////////////////////////////////////////////////

        //label for username
        email = new JLabel(" Email: ");
        email.setFont(new Font("arial",Font.BOLD,28));
        email.setForeground(Color.black);
        email.setBackground(Color.white);
        email.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
        email.setBounds(180, 210,170,50);
        frame.add(email);


        //label for passsword
        password = new JLabel(" Password: ");
        password.setBounds(180, 280,170,50);
        password.setForeground(new Color(112,112,112));
        password.setForeground(Color.black);
        password.setBorder(BorderFactory.createLineBorder(Color.white,5,true));
        password.setFont(new Font("Arial",Font.BOLD,28));
        frame.add(password);

        //Textfield for username
        e_email = new TextField();
        e_email.setBounds(410, 210,300,50);
        e_email.setFont(new Font("Arial",Font.BOLD,30));
        frame.add(e_email);

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



        // adding actionlistener
        login.addActionListener(this);
        sign_up.addActionListener(this);






        frame.setVisible(true);


    }

    private boolean check() throws SQLException {
        String em= e_email.getText();
        String pa= e_password.getText();
        String Null ="";

        if (em.equals(Null) || pa.equals(Null)) {
            JOptionPane.showMessageDialog(null, "Empty field");
            return false;
        } else {
            String user = e_email.getText();
            String pass = e_password.getText();
            Connection connection = c2.getconn();
            PreparedStatement checkUser = connection.prepareStatement("SELECT email from user_info WHERE email = ? and password = ?");
            checkUser.setString(1, user);
            checkUser.setString(2, pass);
            ResultSet resultSet = checkUser.executeQuery();
            if (resultSet.next()) {
                resultSet.close();
                checkUser.close();
                return true;
            }
            JOptionPane.showMessageDialog(null, "User Doesnot exist");
            return false;
        }
    }



    public String user_email(){
        return this.e_email.getText();
    }

    public String user_password(){
        return this.e_password.getSelectedText();
    }






    @Override
    public void actionPerformed(ActionEvent e) {

//        if( conn!=null){


        try{




            if (e.getSource()==login){
                if (check()){
                    String em = e_email.getText();
                    String pass= e_password.getText();



                    frame.setVisible(false);
                    new Dashboard(em,pass);




                }

            }
            else if(e.getSource()==sign_up){
                frame.dispose();
                frame.setVisible(false);

                new sign_up();


            }
            else{
                frame.setVisible(false);
            }




        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }




    public static void main(String[] args) {
        Login login = new Login();

    }
}






