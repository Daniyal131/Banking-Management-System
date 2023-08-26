
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EditAccountInfo {


    JFrame frame = new JFrame();

    JFrame AccountFrame = new JFrame();

    JLabel EnterAccountNumber = new JLabel();

    JLabel DisplayAccountNumber = new JLabel();

    JLabel EnterAccountHolderName = new JLabel();

    JTextField AccountNumberTextField = new JTextField();

    JTextField DisplayAccountNumberTextField = new JTextField();


    JTextField HolderNameTextField = new JTextField();

    JButton EditAccount = new JButton();

    JButton DisplayEditAccount = new JButton();

    JButton BackButton = new JButton();

    JButton DisplayBackButton = new JButton();

    EditAccountInfo(String temp1, String temp2, String temp3,Color Dark,Color foreground,Font font)
    {

        EditAccountNumber(temp1, temp2, temp3, Dark,foreground,font);

    }


    void DisplayEditAccount(String temp1, String temp2, String temp3,Color background,Color foreground,Font font)
    {

        frame.add(EnterAccountHolderName);
        frame.add(EnterAccountNumber);
        frame.add(AccountNumberTextField);
        frame.add(HolderNameTextField);
        frame.add(EditAccount);
        frame.add(BackButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setTitle("Account Detail Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);

        EnterAccountNumber.setBounds(400, 100, 250, 50);
        EnterAccountNumber.setText("Enter Account No:");
        EnterAccountNumber.setFont(font);
        EnterAccountNumber.setForeground(foreground);
        EnterAccountNumber.setBackground(background);

        AccountNumberTextField.setBounds(650, 100, 300, 50);
        AccountNumberTextField.setFont(font);
        AccountNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        AccountNumberTextField.setForeground(foreground);
        AccountNumberTextField.setBackground(background);
        AccountNumberTextField.setSelectionColor(foreground);
        AccountNumberTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNumberTextField.setCaretColor(foreground);
        AccountNumberTextField.setEditable(false);



        EnterAccountHolderName.setBounds(400, 200, 230, 50);
        EnterAccountHolderName.setText("Holder's Name:");
        EnterAccountHolderName.setFont(font);
        EnterAccountHolderName.setForeground(foreground);

        HolderNameTextField.setBounds(650, 200, 300, 50);
        HolderNameTextField.setFont(font);
        HolderNameTextField.setHorizontalAlignment(JTextField.CENTER);
        HolderNameTextField.setForeground(foreground);
        HolderNameTextField.setBackground(background);
        HolderNameTextField.setSelectionColor(foreground);
        HolderNameTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        HolderNameTextField.setCaretColor(foreground);

        HolderNameTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= 'A') && (c <= 'z' || c <= 'Z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE) )) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Enter only Alphabet","Holder's name field error",JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }
            }


        });





        EditAccount.setBounds(700, 500, 250, 50);
        EditAccount.setFont(font);
        EditAccount.setText("Edit Account");
        EditAccount.setBackground(background);
        EditAccount.setForeground(foreground);
        EditAccount.setBorder(BorderFactory.createLineBorder(background, 2, false));
        EditAccount.setFocusable(false);

        EditAccount.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                EditAccount.setBackground(foreground);
                EditAccount.setForeground(background);
                EditAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                EditAccount.setBackground(background);
                EditAccount.setForeground(foreground);
                EditAccount.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            @Override
            public void mouseClicked(MouseEvent e) {


                try {

                    String name=HolderNameTextField.getText();
//                    String address=AddressTextField.getText();
                    int id=Integer.parseInt(AccountNumberTextField.getText());


                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
                    Statement statement = connection.createStatement();

                    String updateSql = "UPDATE Bank SET Name= '"+name+"' WHERE AccountNo = "+id;
                    statement.executeUpdate(updateSql);
//                    String updateSqladd = "UPDATE Bank SET Address= '"+address+"' WHERE AccountNo = "+id;
//                    statement.executeUpdate(updateSqladd);

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Account edited successfully!","Account Edited",JOptionPane.INFORMATION_MESSAGE);


                    EditAccount.setEnabled(false);
                   AccountNumberTextField.setText("");
                    DisplayAccountNumberTextField.setText("");
//                    AddressTextField.setText("");
                    HolderNameTextField.setText("");





                }
                catch (Exception j) {
                    j.printStackTrace();

                }
            }
        });

        BackButton.setBounds(500, 500, 150, 50);
        BackButton.setFont(font);
        BackButton.setText("Back");
        BackButton.setBackground(background);
        BackButton.setForeground(foreground);
        BackButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        BackButton.setFocusable(false);

        BackButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                BackButton.setBackground(foreground);
                BackButton.setForeground(background);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                BackButton.setBackground(background);
                BackButton.setForeground(foreground);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }


            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new MainMenu(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
            }
        });
    }

    void EditAccountNumber(String temp1, String temp2, String temp3,Color background,Color foreground,Font font)
    {

        AccountFrame.add(DisplayAccountNumber);
        AccountFrame.add(DisplayAccountNumberTextField);
        AccountFrame.add(DisplayBackButton);
        AccountFrame.add(DisplayEditAccount);

        AccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AccountFrame.setSize(1280, 720);
        AccountFrame.setLayout(null);
        AccountFrame.setTitle("Account Detail Panel");
        AccountFrame.setResizable(false);
        AccountFrame.setLocationRelativeTo(null);

        AccountFrame.setVisible(true);
        AccountFrame.getContentPane().setBackground(background);
        AccountFrame.getContentPane().setForeground(foreground);


        DisplayAccountNumber.setBounds(550, 300, 350, 50);
        DisplayAccountNumber.setText("Enter Account No:");
        DisplayAccountNumber.setFont(font);
        DisplayAccountNumber.setForeground(foreground);
        DisplayAccountNumber.setBackground(background);

        DisplayAccountNumberTextField.setBounds(550, 350, 300, 50);
        DisplayAccountNumberTextField.setFont(font);
        DisplayAccountNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        DisplayAccountNumberTextField.setForeground(foreground);
        DisplayAccountNumberTextField.setBackground(background);
        DisplayAccountNumberTextField.setSelectionColor(foreground);
        DisplayAccountNumberTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        DisplayAccountNumberTextField.setCaretColor(foreground);

        DisplayAccountNumberTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {

                    JOptionPane.showMessageDialog(null,"Invalid Number!");
                    e.consume();
                }
            }


            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {

                    try {


                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12591157" , "sql12591157" , "ZVDs9aXxAn");
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("select * from Bank");

                        int check=0;
                        while (resultSet.next())
                        {
                            if(String.valueOf(resultSet.getInt(1)).equals(DisplayAccountNumberTextField.getText()))
                            {
                                AccountNumberTextField.setText(String.valueOf(resultSet.getInt(1)));
                                HolderNameTextField.setText(resultSet.getString(2));
//                                AddressTextField.setText(resultSet.getString(6));
                                check=1;
                                AccountFrame.dispose();
                                DisplayEditAccount(temp1, temp2, temp3,background,foreground,font);
                                break;
                            }

                        }
                        if(check==0)
                        {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(frame,"Account Doesn't Exist","Delete Account",JOptionPane.INFORMATION_MESSAGE);
                            DisplayAccountNumberTextField.setText("");
                        }




                    }
                    catch (Exception j)
                    {
                        j.printStackTrace();

                    }
                }
            }
        });



        final int MaxCharacters = 5;

        // Create the DocumentFilter
        DocumentFilter Filter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Limit the number of characters
                if (fb.getDocument().getLength() + string.length() > MaxCharacters) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Account No Must Be Of 5 digits","Account No error!",JOptionPane.INFORMATION_MESSAGE);

                    return;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Limit the number of characters
                if (fb.getDocument().getLength() + text.length() - length > MaxCharacters ) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Account No Must Be Of 5 digits","Account No error!",JOptionPane.INFORMATION_MESSAGE);

                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        };

        // Set the DocumentFilter on the text field's document
        ((AbstractDocument) DisplayAccountNumberTextField.getDocument()).setDocumentFilter(Filter);

        DisplayBackButton.setBounds(0, 625, 200, 50);
        DisplayBackButton.setText("Back");
        DisplayBackButton.setFont(font);
        DisplayBackButton.setBackground(background);
        DisplayBackButton.setForeground(foreground);
        DisplayBackButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        DisplayBackButton.setFocusable(false);

        DisplayBackButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                DisplayBackButton.setBackground(foreground);
                DisplayBackButton.setForeground(background);
                DisplayBackButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                DisplayBackButton.setBackground(background);
                DisplayBackButton.setForeground(foreground);
                DisplayBackButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) {

                if(e.getSource()==DisplayBackButton)
                {
                    AccountFrame.dispose();
                    new MainMenu(temp1,temp2,temp3,AccountFrame.getContentPane().getBackground(),AccountFrame.getContentPane().getForeground(),font);
                }
            }
        });

        DisplayEditAccount.setBounds(1050, 625, 200, 50);
        DisplayEditAccount.setText("Continue");
        DisplayEditAccount.setFont(font);
        DisplayEditAccount.setBackground(background);
        DisplayEditAccount.setForeground(foreground);
        DisplayEditAccount.setBorder(BorderFactory.createLineBorder(background, 2, false));
        DisplayEditAccount.setFocusable(false);

        DisplayEditAccount.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                DisplayEditAccount.setBackground(foreground);
                DisplayEditAccount.setForeground(background);
                DisplayEditAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                DisplayEditAccount.setBackground(background);
                DisplayEditAccount.setForeground(foreground);
                DisplayEditAccount.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }


            public void mouseClicked(MouseEvent j) {

                try {


                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from Bank");
                    int check=0;
                    while (resultSet.next())
                    {
                        if(String.valueOf(resultSet.getInt(1)).equals(DisplayAccountNumberTextField.getText()))
                        {
                            AccountNumberTextField.setText(String.valueOf(resultSet.getInt(1)));
                            HolderNameTextField.setText(resultSet.getString(2));
//                            AddressTextField.setText(resultSet.getString(6));
                            check=1;
                            AccountFrame.dispose();
                            DisplayEditAccount(temp1, temp2, temp3,background,foreground,font);
                            break;
                        }

                    }
                    if(check==0)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(frame,"Account Doesn't Exist","Delete Account",JOptionPane.INFORMATION_MESSAGE);
                        DisplayAccountNumberTextField.setText("");
                    }




                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }


            }


        });

    }

    }




