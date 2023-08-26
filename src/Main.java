

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        new intro();
//        IdAndPasswords idandpasswords = new IdAndPasswords();
//        String temp1, temp2, temp3;
//        temp1 = "";
//        temp2 = "";
//        temp3 = "";
//
//        LoginPage loginPage = new LoginPage(idandpasswords.getLoginInfo(), temp1, temp2, temp3, Color.WHITE, Color.BLACK);


//        try (Connection connection = dataSource.getConnection()) {
//            // Perform a database operation
//            Statement statement = connection.createStatement();
//
//
//        }
//    catch(SQLException ex)
//
//    {
//        ex.printStackTrace();
//    }


//        try {
//
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12591157", "sql12591157", "ZVDs9aXxAn");
//            Statement statement = connection.createStatement();
////         creating a DataBase
////            String createDbSql = "CREATE DATABASE qasimnamazi";
////            statement.executeUpdate(createDbSql);
//
////            String createTableSql = "CREATE TABLE info (accountNo INT PRIMARY KEY NOT NULL , name VARCHAR(255) NOT NULL ,nic BIGINT NOT NULL UNIQUE,gender VARCHAR(10) NOT NULL,balance INT NOT NULL, address VARCHAR(255) NOT NULL)";
////            statement.executeUpdate(createTableSql);
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Main obj=new Main();

        new JFrame();



        try {
//

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();
            IdAndPasswords idandpasswords = new IdAndPasswords();
            String temp1, temp2, temp3;
            temp1 = "";
            temp2 = "";
            temp3 = "";
            Font font = new Font(Font.SERIF,Font.ITALIC,30);
//            Font font=null;

            LoginPage loginPage = new LoginPage(idandpasswords.getLoginInfo(), temp1, temp2, temp3, Color.WHITE, Color.BLACK,font);


        } catch (Exception e) {

            IdAndPasswords idandpasswords = new IdAndPasswords();
            String temp1, temp2, temp3;
            temp1 = "";
            temp2 = "";
            temp3 = "";
            Font font = new Font(Font.SERIF,Font.ITALIC,30);

            LoginPage loginPage = new LoginPage(idandpasswords.getLoginInfo(), temp1, temp2, temp3, Color.WHITE, Color.BLACK,font);

//
            JOptionPane.showMessageDialog(null, "Check your internet connection", "Database error", JOptionPane.INFORMATION_MESSAGE);
            String[] options = {"refresh", "exit"};
            int choice = JOptionPane.showOptionDialog(null, "Do you want to refresh?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == JOptionPane.YES_OPTION) {
                loginPage.frame.dispose();
                obj.main(args);
            } else {
                loginPage.frame.dispose();

            }



        }

    }
}