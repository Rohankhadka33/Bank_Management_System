import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

@SuppressWarnings("All")
public class sign_up extends JFrame implements ActionListener {
    Conn c2 = new Conn();

    private JFrame signup_frame;

    private JLabel fullName, userName, email, cont_no, add, pass;
    private JTextField e_fullName, e_userName, e_email, e_contact, e_add, e_pass;

    private int valx = 100, valy = 40;
    private JButton confirm_reg, Exit, Back;
    //for border
    private int bx = (valx + 170), by = valy + 360;

    //email
    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    public sign_up() {
        signup_frame = new JFrame();
        signup_frame.setTitle("Registration");
        signup_frame.setSize(900, 600);
        signup_frame.setResizable(false);

        signup_frame.getContentPane().setBackground(Color.decode("#CAB525"));

        //putting the window in centre of the screen.
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - signup_frame.getWidth()));
        int y = (int) ((dimension.getHeight() - signup_frame.getHeight()));

        signup_frame.setLocation(x / 2, y / 2);

        // LABEL =========================================================================================================================
        //labeling for registration
        fullName = new JLabel(" Full Name ");
        fullName.setFont(new Font("Arial", Font.BOLD, 30));
        fullName.setBounds(valx, valy, 190, 50);
        fullName.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        fullName.setBackground(Color.decode("#76655B"));
        signup_frame.add(fullName);

        //label for username
        userName = new JLabel(" UserName: ");
        userName.setFont(new Font("Arial", Font.BOLD, 30));
        userName.setBounds(valx, valy + 60, 190, 50);
        userName.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(userName);

        //label for email
        email = new JLabel(" Email: ");
        email.setFont(new Font("Arial", Font.BOLD, 30));
        email.setBounds(valx, valy + 120, 190, 50);
        email.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(email);

        //label for contact no
        cont_no = new JLabel(" Contact:  ");
        cont_no.setFont(new Font("Arial", Font.BOLD, 30));
        cont_no.setBounds(valx, valy + 180, 190, 50);
        cont_no.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(cont_no);

        //label for address
        add = new JLabel(" Address: ");
        add.setFont(new Font("Arial", Font.BOLD, 30));
        add.setBounds(valx, valy + 240, 190, 50);
        add.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(add);

        //label for password
        pass = new JLabel(" Password: ");
        pass.setFont(new Font("Arial", Font.BOLD, 30));
        pass.setBounds(valx, valy + 300, 190, 50);
        pass.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(pass);


        // BUTTON=================================================================================================================
        //Confirm button
        confirm_reg = new JButton(" Confirm Registration ");
        confirm_reg.setFont(new Font("Arial", Font.BOLD, 30));
        confirm_reg.setBounds(bx, by, 350, 50);
        confirm_reg.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(confirm_reg);

        //Back button
        Back = new JButton(" Back ");
        Back.setFont(new Font("Arial", Font.BOLD, 30));
        Back.setBounds(bx, by + 55, 350, 50);
        Back.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(Back);

        //Exit button
        Exit = new JButton(" Exit ");
        Exit.setFont(new Font("Arial", Font.BOLD, 30));
        Exit.setBounds(bx, by + 110, 350, 50);
        Exit.setBorder(BorderFactory.createLineBorder(Color.white, 6, true));
        signup_frame.add(Exit);

        // Textfield=================================================================================================================================


        e_fullName = new JTextField();
        e_fullName.setBounds(valx + 230, valy, 480, 48);
        e_fullName.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_fullName);


        e_userName = new JTextField();
        e_userName.setBounds(valx + 230, valy + 60, 480, 48);
        e_userName.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_userName);


        e_email = new JTextField();
        e_email.setBounds(valx + 230, valy + 120, 480, 48);
        e_email.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_email);

        e_contact = new JTextField();
        e_contact.setBounds(valx + 230, valy + 180, 480, 48);
        e_contact.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_contact);

        e_add = new JTextField();
        e_add.setBounds(valx + 230, valy + 240, 480, 48);
        e_add.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_add);


        e_pass = new JTextField();
        e_pass.setBounds(valx + 230, valy + 300, 480, 48);
        e_pass.setFont(new Font("Arial", Font.BOLD, 30));
        signup_frame.add(e_pass);


        //addingactionlistner================================================================================================
        confirm_reg.addActionListener(this);
        Back.addActionListener(this);
        Exit.addActionListener(this);


        signup_frame.setLayout(null);
        signup_frame.setVisible(true);


    }






    @Override
    public void actionPerformed(ActionEvent e) {
        //getting data
        String a = e_fullName.getText();
        String b = e_userName.getText();
        String c = e_email.getText();
        String d = e_contact.getText();
        String add_e = e_add.getText();
        String f = e_pass.getText();

        String Null = "";

        boolean bol = !Null.equals(a) && !Null.equals(b) && !Null.equals(c) && !Null.equals(d) && !Null.equals(add_e)
                && !Null.equals(f);



        if (e.getSource() == confirm_reg) {
            if (bol) {

                if (isValid(c)) {
                    if (!(d.length() < 10)) {
                        if (!(d.length() > 10)) {

                            try {
                                Connection connection = c2.getconn();
                                PreparedStatement checkUser = connection.prepareStatement("SELECT email from user_info WHERE email = ?");
                                checkUser.setString(1,c);
                                ResultSet resultSet = checkUser.executeQuery();

//                                String check = "SELECT email from user_info WHERE email=" + c ;
//                                ResultSet result = c2.s.executeQuery(check);

                                if (!resultSet.next()) {
                                    PreparedStatement addUser = connection.prepareStatement("INSERT INTO user_info(Fullname,username,email,contactno,adress,password) VALUES(?,?,?,?,?,?)");
                                    addUser.setString(1,a);
                                    addUser.setString(2,b);
                                    addUser.setString(3,c);
                                    addUser.setString(4,d);
                                    addUser.setString(5,add_e);
                                    addUser.setString(6,f);
                                    addUser.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "Registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Email already exists");
                                }






                            } catch (SQLException ae) {
                                ae.printStackTrace();
                            }



                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Contact Number cannot be more than 10");

                        }


                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Contact Number cannot be less than 10");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid email");
                }

            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all the fields!");
            }

        }

        else if (e.getSource() == Back) {
            signup_frame.setVisible(false);
            signup_frame.dispose();
            new Login();

        }

        else if (e.getSource() == Exit) {
            signup_frame.dispose();
            signup_frame.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new sign_up();
    }
}


