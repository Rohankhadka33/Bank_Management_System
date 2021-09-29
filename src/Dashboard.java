import javax.swing.*;
import java.awt.*;
import java.sql.*;


@SuppressWarnings("All")
public class Dashboard extends JFrame {

    private JLabel fullName, userName, email, cont_no, add,welc;

    private int valx = 60, valy = 70;
    Conn c2 = new Conn();

    private JFrame D_frame;
    public static String user_em,user_pass, fullName_str, userName_str, cont_no_str, add_str;






    public Dashboard(String g_email,String g_password) throws SQLException {
        this.user_em=g_email;
        this.user_pass=g_password;

        // getting information of the user
        try {
            Connection connection = c2.getconn();
            PreparedStatement checkUser = connection.prepareStatement("SELECT * from user_info WHERE email = ? and password = ?");
            checkUser.setString(1,user_em);
            checkUser.setString(2,user_pass);
            ResultSet resultSet = checkUser.executeQuery();
            if (resultSet.next()){
                userName_str = resultSet.getString("username");
                fullName_str = resultSet.getString("Fullname");
                cont_no_str = resultSet.getString("contactno");
                add_str = resultSet.getString("adress");
                resultSet.close();
                checkUser.close();
                connection.close();
            }
            else{
                JOptionPane.showMessageDialog(null,"User not found");
                connection.close();
            }








        } catch (SQLException ae) {
            ae.printStackTrace();
        }









        D_frame = new JFrame();
        D_frame.setTitle("Dashboard");
        D_frame.setSize(900, 600);
        D_frame.setResizable(false);
        D_frame.setLayout(null);


        D_frame.getContentPane().setBackground(Color.decode("#3B92A3"));

        D_frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        //making window to appear in the centre of screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - D_frame.getWidth()));
        int y = (int) ((dimension.getHeight() - D_frame.getHeight()));
        D_frame.setLocation(x / 2, y / 2);
        String firstname = "";

        if (fullName_str!=null ){
            String[] tokens = fullName_str.split(" ");
            for (int i = tokens.length - 1; i >= 0; i--) {
                firstname = tokens[i];
            }
        }


        //welcome
        String a= "Welcome To User Credentials Saving System, "+firstname;
        welc = new JLabel(a);
        welc.setFont(new Font("Arial", Font.BOLD, 25));
        welc.setBounds(valx, valy-60, 800, 50);
        welc.setForeground(Color.decode("#2E1AE2"));
        D_frame.add(welc);


        //label for nam
        fullName = new JLabel(" Full Name: "+fullName_str);
        fullName.setFont(new Font("Arial", Font.BOLD, 30));
        fullName.setBounds(valx, valy, 500, 50);
        D_frame.add(fullName);
        //showing fullname
//        fullName = new JLabel(" Full Name: " );
//        fullName.setFont(new Font("Arial", Font.BOLD, 30));
//        fullName.setBounds(valx, valy, 190, 50);
//        D_frame.add(fullName);

        //label for username
        userName = new JLabel(" UserName: "+userName_str);
        userName.setFont(new Font("Arial", Font.BOLD, 30));
        userName.setBounds(valx, valy + 80, 500, 50);
        D_frame.add(userName);
        //showing username
//        userName = new JLabel(" UserName: ");
//        userName.setFont(new Font("Arial", Font.BOLD, 30));
//        userName.setBounds(valx, valy + 80, 190, 50);
//        D_frame.add(userName);
//


        //label for email
        email = new JLabel(" Email: "+user_em);
        email.setFont(new Font("Arial", Font.BOLD, 30));
        email.setBounds(valx, valy + 160, 500, 50);
        D_frame.add(email);
        //showing email
//        email = new JLabel(" Email: ");
//        email.setFont(new Font("Arial", Font.BOLD, 30));
//        email.setBounds(valx, valy + 160, 190, 50);
//        D_frame.add(email);

        //label for contact no
        cont_no = new JLabel(" Contact: "+cont_no_str);
        cont_no.setFont(new Font("Arial", Font.BOLD, 30));
        cont_no.setBounds(valx, valy + 240, 500, 50);
        D_frame.add(cont_no);
//        //showing contactno
//        cont_no = new JLabel(" Contact:  ");
//        cont_no.setFont(new Font("Arial", Font.BOLD, 30));
//        cont_no.setBounds(valx, valy + 240, 190, 50);
//        D_frame.add(cont_no);

        //label for address
        add = new JLabel(" Address: "+add_str);
        add.setFont(new Font("Arial", Font.BOLD, 30));
        add.setBounds(valx, valy + 320, 500, 50);
        D_frame.add(add);



        D_frame.setLayout(null);
        D_frame.setVisible(true);


    }




    public static void main(String[] args) throws SQLException {

        Dashboard ds = new Dashboard(user_em,user_pass);


    }

}