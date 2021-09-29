package test;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.sql.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class UnitTest {
    boolean isUserAvailable = false;
    boolean result;
    String user = "asd@gmail.com";
    String pass ="sad";

    //actual
    String contactno = "";
    String adress = "";
    String Fullname = "";


    @Before
    public void init() throws SQLException {


        result = false;
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/oop_bank","root","password_123");
        PreparedStatement checkUser = connection.prepareStatement("SELECT * from user_info WHERE email = ? and password = ?");
        checkUser.setString(1,user);
        checkUser.setString(2,pass);
        ResultSet resultSet = checkUser.executeQuery();
        if (resultSet.next()){
            contactno = resultSet.getString("contactno");
            adress = resultSet.getString("adress");
            Fullname = resultSet.getString("Fullname");
            resultSet.close();
            checkUser.close();
            isUserAvailable = true;
            result = true;

        }else {
            resultSet.close();
            checkUser.close();
            connection.close();
        }

    }

    @Test
    public void UserCheck(){
        assertTrue(isUserAvailable);
    }
    @Test
    public void UserContact(){

        assertEquals("0123456789",contactno);
    }
    @Test
    public void UserAddress(){
        assertEquals("sdas",adress);
    }
    @Test
    public void UserFullname(){
        assertEquals("sad",Fullname);
    }

    @Test
    public void LoginCheck(){
        assertTrue(result);
    }

}
