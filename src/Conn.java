import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    public  Connection getconn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/oop_bank","root","password_123");
            return c;

        }
        catch (Exception exception){
            exception.printStackTrace();
            return null;

        }

    }


}
