import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AfterCrediting  {


    JFrame frame = new JFrame();
    JLabel BalanceLabel = new JLabel();

    JLabel BalanceAmountLabel = new JLabel();
    JLabel AccountNumber = new JLabel();
    JLabel AccountNumberLabel = new JLabel();
    JLabel AccountHolder = new JLabel();
    JLabel AccountHolderName = new JLabel();

    JButton ContinueButton = new JButton();

    JButton ExitButton = new JButton();

    AfterCrediting(String temp1, String temp2, String temp3,String CreditAmount,int Check,Color Dark,Color foreground,Font font) throws SQLException, ClassNotFoundException {



        DisplayAfterCrediting(temp1, temp2, temp3,CreditAmount,Check,Dark,foreground,font);

        frame.add(BalanceAmountLabel);
        frame.add(BalanceLabel);
        frame.add(AccountHolderName);
        frame.add(AccountHolder);
        frame.add(AccountNumber);
        frame.add(AccountNumberLabel);
        frame.add(ContinueButton);
        frame.add(ExitButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setTitle("After Crediting Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }



    void DisplayAfterCrediting(String temp1, String temp2, String temp3,String CreditAmount,int Check,Color background,Color foreground,Font font) throws SQLException, ClassNotFoundException {



        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);

        AccountNumber.setBounds(400, 100, 230, 50);
        AccountNumber.setText("Account Number:");
        AccountNumber.setFont(font);
        AccountNumber.setForeground(foreground);

        AccountNumberLabel.setBounds(700, 100, 300, 50);
        AccountNumberLabel.setText(temp2);
        AccountNumberLabel.setHorizontalAlignment(JLabel.CENTER);
        AccountNumberLabel.setFont(font);
        AccountNumberLabel.setForeground(foreground);
        AccountNumberLabel.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNumberLabel.setBackground(background);

        AccountHolder.setBounds(400, 200, 230, 50);
        AccountHolder.setText("Holder's Name:");
        AccountHolder.setFont(font);
        AccountHolder.setForeground(foreground);

        AccountHolderName.setBounds(700, 200, 300, 50);
        AccountHolderName.setText(temp1);
        AccountHolderName.setHorizontalAlignment(JLabel.CENTER);
        AccountHolderName.setFont(font);
        AccountHolderName.setForeground(foreground);
        AccountHolderName.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountHolderName.setBackground(background);

        BalanceLabel.setBounds(400, 300, 250, 50);
        BalanceLabel.setText("Credited Balance Is:");
        BalanceLabel.setFont(new Font(Font.SERIF, Font.ITALIC, 30));
        BalanceLabel.setForeground(foreground);

        if (Check==0)
        {


            int Amount=0;
            Amount=Integer.parseInt(temp3)+Integer.parseInt(CreditAmount);


            BalanceAmountLabel.setBounds(700, 300, 300, 50);
            BalanceAmountLabel.setText(String.valueOf(Amount));
            BalanceAmountLabel.setHorizontalAlignment(JLabel.CENTER);
            BalanceAmountLabel.setFont(font);
            BalanceAmountLabel.setForeground(foreground);
            BalanceAmountLabel.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
            BalanceAmountLabel.setBackground(background);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Bank");
                String name = "";
                String email = "";
                int acco = 0;
                while (resultSet.next()) {
                    if (resultSet.getInt(1) == Integer.parseInt(temp1)) {
                        name = resultSet.getString(2);
                        email = resultSet.getString(6);
                        acco = resultSet.getInt(1);
                    }
                }

                GMailSender gMailSender = new GMailSender();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
                Calendar cal = Calendar.getInstance();
                String time = sdf.format(cal.getTime());
                String date = sdf2.format(cal.getTime());

                String to = email;
                String from = "udqbank@gmail.com";
                String subject = "Transaction Alert";
                String text = "Hi " + name + "\nAccount Number "+acco +"\nYour Account has been Credited with Rs :" + Integer.parseInt(CreditAmount) + "\tat : "+time +"  "+ date +"\nYour Updated Balance is Rs: " + Amount + "\nThankyou, UDQ BANK";
                gMailSender.sendEmail(to, from, subject, text);

                EditFile(temp1, Amount);
            }catch (Exception e){
                System.out.println(e);
            }

        }
        else
        {
            int Amount=0;

                Amount = Integer.parseInt(temp3) - Integer.parseInt(CreditAmount);



                BalanceAmountLabel.setBounds(700, 300, 300, 50);
                BalanceAmountLabel.setText(String.valueOf(Amount));
                BalanceAmountLabel.setHorizontalAlignment(JLabel.CENTER);
                BalanceAmountLabel.setFont(font);
                BalanceAmountLabel.setForeground(foreground);
                BalanceAmountLabel.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
                BalanceAmountLabel.setBackground(background);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from Bank");
                String name = "";
                String email = "";
                int acco = 0;
                while (resultSet.next()) {
                    if (resultSet.getInt(1) == Integer.parseInt(temp1)) {
                        name = resultSet.getString(2);
                        email = resultSet.getString(6);
                        acco = resultSet.getInt(1);
                    }
                }

                GMailSender gMailSender = new GMailSender();

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
                Calendar cal = Calendar.getInstance();
                String time = sdf.format(cal.getTime());
                String date = sdf2.format(cal.getTime());

                String to = email;
                String from = "udqbank@gmail.com";
                String subject = "Transaction Alert";
                String text = "Hi " + name + "\nAccount Number "+acco +"\nYour Account has been Debited with Rs :" + Integer.parseInt(CreditAmount) + "\tat : "+time +"  "+ date +"\nYour Updated Balance is Rs: " + Amount + "\nThankyou, UDQ BANK";
                gMailSender.sendEmail(to, from, subject, text);

                EditFile(temp1, Amount);
            }catch (Exception e){
                System.out.println(e);
            }

                EditFile(temp1, Amount);

        }


        ContinueButton.setBounds(700, 500, 350, 50);
        ContinueButton.setFont(font);
        ContinueButton.setText("Continue With Transaction");
        ContinueButton.setBackground(background);
        ContinueButton.setForeground(foreground);
        ContinueButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        ContinueButton.setFocusable(false);

        ContinueButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                ContinueButton.setBackground(foreground);
                ContinueButton.setForeground(background);
                ContinueButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                ContinueButton.setBackground(background);
                ContinueButton.setForeground(foreground);
                ContinueButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {

                frame.dispose();
                try {
                    new Transaction(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        ExitButton.setBounds(400, 500, 150, 50);
        ExitButton.setFont(font);
        ExitButton.setText("Exit");
        ExitButton.setBackground(background);
        ExitButton.setForeground(foreground);
        ExitButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        ExitButton.setFocusable(false);

        ExitButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                ExitButton.setBackground(foreground);
                ExitButton.setForeground(background);
                ExitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                ExitButton.setBackground(background);
                ExitButton.setForeground(foreground);
                ExitButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MainMenu(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);


            }
        });



    }

    void EditFile(String temp1, int Amount)
    {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bank");
            int acc = Integer.parseInt(temp1);
            int Balance = Amount;

            String updateSql = "UPDATE Bank SET Balance = "+Balance+" WHERE AccountNo = "+acc;
            statement.executeUpdate(updateSql);


        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }


}
