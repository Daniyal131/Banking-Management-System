import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class ChangePassword {
    JFrame frame = new JFrame();
    JLabel Current = new JLabel(" Current password");
    JLabel newpass = new JLabel(" New password");
    JLabel confirmnewpass = new JLabel("Confirm password");
    JTextField currenttextfield = new JTextField();
    JTextField newpasstextfield = new JTextField();
    JTextField confirmtextfiels = new JTextField();
    JButton  back=new JButton("Back ");
    JButton update=new JButton("Update");

    ChangePassword(String temp1, String temp2, String temp3,String Userid,String Password, Color background, Color foreground, Font font) {


        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setTitle("Update Password");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(Current);
        frame.add(newpass);
        frame.add(confirmnewpass);

        frame.add(confirmtextfiels);
        frame.add(newpasstextfield);
        frame.add(back);
        frame.add(update);
        update.setBounds(600,500,120,50);
        update.setFont(font);
        update.setForeground(foreground);
        update.setBackground(background);
        update.setBorder(BorderFactory.createLineBorder(background));
        update.setFocusable(false);

        update.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                update.setBackground(foreground);
                update.setForeground(background);
                update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                update.setBackground(background);
                update.setForeground(foreground);
                update.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {
                if (Password.equals(currenttextfield.getText()))
                {
                    if(newpasstextfield.getText().equals("") || confirmtextfiels.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "password not match", "Password error", JOptionPane.INFORMATION_MESSAGE);
                        newpasstextfield.setText("");
                        confirmtextfiels.setText("");
                        newpasstextfield.requestFocus();
                    }
                    else if(newpasstextfield.getText().equals(confirmtextfiels.getText()))
                    {
                        IdAndPasswords idandpasswords = new IdAndPasswords();
                        passwordtodatabase(newpasstextfield.getText(),temp1,temp2,temp3,font);
                        JOptionPane.showMessageDialog(null, "Password Updated Succesfully", "Password Update", JOptionPane.INFORMATION_MESSAGE);

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "password not match", "Password error", JOptionPane.INFORMATION_MESSAGE);
                        newpasstextfield.setText("");
                        confirmtextfiels.setText("");
                        newpasstextfield.requestFocus();
                    }
                }
                else {
                        JOptionPane.showMessageDialog(null, "Current password is Wrong!", "Password error", JOptionPane.INFORMATION_MESSAGE);
                        currenttextfield.setText("");
                        currenttextfield.requestFocus();
                }
            }
        });

        back.setBounds(5,620,120,50);
        back.setFont(font);
       back.setForeground(foreground);
        back.setBackground(background);
        back.setBorder(BorderFactory.createLineBorder(background));
        back.setFocusable(false);

        back.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
            public void mouseEntered(MouseEvent evt) {

                back.setBackground(foreground);
                back.setForeground(background);
                back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                back.setBackground(background);
                back.setForeground(foreground);
                back.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }


            public void mouseClicked(MouseEvent e) {
                IdAndPasswords idandpasswords = new IdAndPasswords();
                frame.dispose();
                new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

            }
        });
        Current.setBounds(300, 200, 400, 50);
        Current.setFont(font);
        Current.setForeground(foreground);
        newpass.setBounds(300, 300, 400, 50);
        newpass.setFont(font);
        newpass.setForeground(foreground);
        confirmnewpass.setBounds(300, 400, 400, 50);
        confirmnewpass.setFont(font);
        confirmnewpass.setForeground(foreground);


        currenttextfield.setBounds(600, 200, 200, 50);
        currenttextfield.setFont(font);
        currenttextfield.setHorizontalAlignment(JTextField.CENTER);
        currenttextfield.setForeground(foreground);
        currenttextfield.setBackground(background);
        currenttextfield.setSelectionColor(foreground);
        currenttextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        currenttextfield.setCaretColor(foreground);
        currenttextfield.requestFocus();
      currenttextfield.addKeyListener(new KeyAdapter() {   // Key listener used for overseeing all the keyboard related actions
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) ||(c == KeyEvent.VK_ENTER) )) {

                    if(!(c=='.'))
                    {
                        JOptionPane.showMessageDialog(null,"Only Numbers!");

                    }
                    e.consume();
                }
            }

        });
      currenttextfield.addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
             if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_ENTER)
             {
                 newpasstextfield.requestFocus();
             }
          }
      });


        newpasstextfield.setBounds(600, 300, 200, 50);
        newpasstextfield.setFont(font);
        newpasstextfield.setHorizontalAlignment(JTextField.CENTER);
        newpasstextfield.setForeground(foreground);
        newpasstextfield.setBackground(background);
        newpasstextfield.setSelectionColor(foreground);
        newpasstextfield.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        newpasstextfield.setCaretColor(foreground);
        newpasstextfield.addKeyListener(new KeyAdapter() {   // Key listener used for overseeing all the keyboard related actions
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) ||(c== KeyEvent.VK_ENTER) )) {

                    if(!(c=='.'))
                    {
                        JOptionPane.showMessageDialog(null,"Only Numbers!");

                    }
                    e.consume();
                }
            }
        });
        newpasstextfield.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                   confirmtextfiels.requestFocus();
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    currenttextfield.requestFocus();
                }

            }
        });

        confirmtextfiels.setBounds(600, 400, 200, 50);
        confirmtextfiels.setFont(font);
        confirmtextfiels.setHorizontalAlignment(JTextField.CENTER);
        confirmtextfiels.setForeground(foreground);
        confirmtextfiels.setBackground(background);
        confirmtextfiels.setSelectionColor(foreground);
        confirmtextfiels.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        confirmtextfiels.setCaretColor(foreground);
        confirmtextfiels.addKeyListener(new KeyAdapter() {   // Key listener used for overseeing all the keyboard related actions
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)||(c == KeyEvent.VK_ENTER)   )) {

                    if(!(c=='.'))
                    {
                        JOptionPane.showMessageDialog(null,"Only Numbers!");

                    }
                    e.consume();
                }
            }
        });
        confirmtextfiels.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode()==KeyEvent.VK_ENTER)
                {

                    if (Password.equals(currenttextfield.getText()))
                    {
                        if(newpasstextfield.getText().equals("") || confirmtextfiels.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "password not match", "Password error", JOptionPane.INFORMATION_MESSAGE);
                            newpasstextfield.setText("");
                            confirmtextfiels.setText("");
                            newpasstextfield.requestFocus();
                        }
                        else if(newpasstextfield.getText().equals(confirmtextfiels.getText()))
                        {
                            IdAndPasswords idandpasswords = new IdAndPasswords();
                            passwordtodatabase(newpasstextfield.getText(),temp1,temp2,temp3,font);
                            JOptionPane.showMessageDialog(null, "Password Updated Succesfully", "Password Update", JOptionPane.INFORMATION_MESSAGE);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "password not match", "Password error", JOptionPane.INFORMATION_MESSAGE);
                            newpasstextfield.setText("");
                            confirmtextfiels.setText("");
                            newpasstextfield.requestFocus();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Current password is Wrong!", "Password error", JOptionPane.INFORMATION_MESSAGE);
                        currenttextfield.setText("");
                        currenttextfield.requestFocus();
                    }


                }
                else if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    newpasstextfield.requestFocus();
                }

            }
        });

        frame.add(currenttextfield);
    }
    public void passwordtodatabase(String pass,String temp1,String temp2 ,String temp3,Font font)
    {
        try {


            long b=Long.parseLong(pass);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();

            String updatepass = "UPDATE Bank SET Cnic ="+b+" WHERE AccountNo =999999";
            statement.executeUpdate(updatepass);
            connection.close();
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);




        } catch (Exception e) {
            System.out.println(e);

        }

    }
}

