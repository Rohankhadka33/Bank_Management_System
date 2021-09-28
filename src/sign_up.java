import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class sign_up extends JFrame implements ActionListener {

    private JFrame signup_frame;
    private JLabel fullName,userName,email,cont_no,add,pass;
    private JTextField e_fullName,e_userName,e_email,e_contact,e_add,e_pass;

    private int valx=100, valy=40;
    private JButton confirm_reg,Exit,Back;
    //for border
    private int bx=(valx+170), by=valy+360;

    //email
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }




    public sign_up(){
        signup_frame = new JFrame();
        signup_frame.setTitle("Registration");
        signup_frame.setSize(900,600);
        signup_frame.setResizable(false);

        //putting the window in centre of the screen.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()-signup_frame.getWidth()));
        int y = (int) ((dimension.getHeight()-signup_frame.getHeight()));

        signup_frame.setLocation(x/2,y/2);

        // LABEL =========================================================================================================================
        //labeling for registration
        fullName = new JLabel(" Full Name ");
        fullName.setFont(new Font("Arial",Font.BOLD,30));
        fullName.setBounds(valx,valy,190,50);
        fullName.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(fullName);

        //label for username
        userName = new JLabel(" UserName: ");
        userName.setFont(new Font("Arial",Font.BOLD,30));
        userName.setBounds(valx,valy+60,190,50);
        userName.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(userName);

        //label for email
        email = new JLabel(" Email: ");
        email.setFont(new Font("Arial",Font.BOLD,30));
        email.setBounds(valx,valy+120,190,50);
        email.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(email);

        //label for contact no
        cont_no = new JLabel(" Contact:  ");
        cont_no.setFont(new Font("Arial",Font.BOLD,30));
        cont_no.setBounds(valx,valy+180,190,50);
        cont_no.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(cont_no);

        //label for address
        add = new JLabel(" Address: ");
        add.setFont(new Font("Arial",Font.BOLD,30));
        add.setBounds(valx,valy+240,190,50);
        add.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(add);

        //label for password
        pass = new JLabel(" Password: ");
        pass.setFont(new Font("Arial",Font.BOLD,30));
        pass.setBounds(valx,valy+300,190,50);
        pass.setBorder(BorderFactory.createLineBorder(Color.white,6,true));
        signup_frame.add(pass);

