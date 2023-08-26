
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateAccount {



    JFrame frame = new JFrame();

    JLabel EnterAccountNumber = new JLabel();

    JLabel EnterAccountHolderName = new JLabel();

    JLabel EnterInitialDeposit = new JLabel();

    JLabel CnicLabel = new JLabel();

    JLabel EmailLabel = new JLabel();

    JTextField AccountNumberTextField = new JTextField();

    JTextField HolderNameTextField = new JTextField();

    JTextField InitialDepositTextField = new JTextField();

    JTextField CnicTextField = new JTextField();

    JTextField EmailTestField = new JTextField();

    JButton AddAccount = new JButton();

    JButton BackButton = new JButton();


    CreateAccount(String temp1, String temp2, String temp3, Color background,Color foreground,Font font){

        DisplayCreateAccount(temp1, temp2, temp3, background,foreground,font);

        frame.add(EnterAccountHolderName);
        frame.add(EnterAccountNumber);
        frame.add(EnterInitialDeposit);
        frame.add(AccountNumberTextField);
        frame.add(HolderNameTextField);
        frame.add(InitialDepositTextField);
        frame.add(AddAccount);
        frame.add(BackButton);
        frame.add(CnicTextField);
        frame.add(EmailTestField);
        frame.add(EmailLabel);
        frame.add(CnicLabel);
//        frame.add(Panel);

//        loadingframe.add(loading);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1380, 820);
        frame.setLayout(null);
        frame.setTitle("Account Detail Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }



    void DisplayCreateAccount(String temp1, String temp2, String temp3,Color background,Color foreground,Font font)
    {
        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);

        EnterAccountNumber.setBounds(400, 150, 250, 50);
        EnterAccountNumber.setText("Account No:");
        EnterAccountNumber.setFont(font);
        EnterAccountNumber.setForeground(foreground);
        EnterAccountNumber.setBackground(background);

        AccountNumberTextField.setBounds(600, 150, 300, 50);
        AccountNumberTextField.setFont(font);
        AccountNumberTextField.setHorizontalAlignment(JTextField.CENTER);
        AccountNumberTextField.setForeground(foreground);
        AccountNumberTextField.setBackground(background);
        AccountNumberTextField.setSelectionColor(foreground);
        AccountNumberTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNumberTextField.setCaretColor(foreground);



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
        ((AbstractDocument) AccountNumberTextField.getDocument()).setDocumentFilter(Filter);

        AccountNumberTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
//                String len=AccountNumberTextField.getText();
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame, "Enter only number", "Amount field error!", JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }
//                } else if (len.length()>5)  {
//                    JOptionPane.showMessageDialog(frame, "Account No Must Be Of 5 digits", "Account No error!", JOptionPane.INFORMATION_MESSAGE);
//                }
            }


            public void keyPressed(KeyEvent e) {


                if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN )
                {

                        HolderNameTextField.requestFocus();

                } else if (e.getKeyCode()==KeyEvent.VK_UP) {

                    CnicTextField.requestFocus();
                }

            }
        });





        EmailLabel.setBounds(400, 450, 230, 50);
        EmailLabel.setText("Email:");
        EmailLabel.setFont(font);
        EmailLabel.setForeground(foreground);

        EmailTestField.setBounds(600, 450, 650, 50);
        EmailTestField.setFont(font);
        EmailTestField.setHorizontalAlignment(JTextField.CENTER);


        EmailTestField.setForeground(foreground);
        EmailTestField.setBackground(background);
        EmailTestField.setSelectionColor(foreground);
        EmailTestField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        EmailTestField.setCaretColor(foreground);


        EmailTestField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c=='\'') {

                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode()== KeyEvent.VK_UP) {
                    InitialDepositTextField.requestFocus();
                }
                else if (e.getKeyCode()==KeyEvent.VK_ENTER)
                {



                            if(!((CnicTextField.getText().equals("")) || (AccountNumberTextField.getText().equals("")) || (InitialDepositTextField.getText().equals("")) || (EmailTestField.getText().equals("")) || (HolderNameTextField.getText().equals(""))))
                            {
                                if(CnicTextField.getText().length() != 13 ) {

                                    JOptionPane.showMessageDialog(frame,"Enter 13 Digits CNIC!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                                    CnicTextField.requestFocus();

                                }
                                else if (AccountNumberTextField.getText().length()!=5){
                                    JOptionPane.showMessageDialog(frame,"Enter 5 digit Account number!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                                    AccountNumberTextField.requestFocus();
                                } else if (HolderNameTextField.getText().length() <3) {
                                    JOptionPane.showMessageDialog(frame,"Name must be greater than 3 character ","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                                    HolderNameTextField.requestFocus();
                                }
                                else if(Integer.parseInt(InitialDepositTextField.getText()) < 500)
                                {
                                    JOptionPane.showMessageDialog(frame,"Minimum 500 intial deposit","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                                    InitialDepositTextField.setText("");
                                    InitialDepositTextField.requestFocus();
                                }
                                else {

                                    AddAccountToDatabase();
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(frame,"Enter Complete Information!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                            }





                }
            }
        });



        CnicLabel.setBounds(400, 50, 230, 50);
        CnicLabel.setText("CNIC:");
        CnicLabel.setFont(font);
        CnicLabel.setForeground(foreground);

        CnicTextField.setBounds(600, 50, 300, 50);
        CnicTextField.setFont(font);
        CnicTextField.setHorizontalAlignment(JTextField.CENTER);
        CnicTextField.setForeground(foreground);
        CnicTextField.setBackground(background);
        CnicTextField.setSelectionColor(foreground);
        CnicTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        CnicTextField.setCaretColor(foreground);

        final int maxCharacters = 13;

        // Create the DocumentFilter
        DocumentFilter filter = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Limit the number of characters
                if (fb.getDocument().getLength() + string.length() > maxCharacters) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"CNIC Must Be Of 13 Characters","Cnic error!",JOptionPane.INFORMATION_MESSAGE);

                    return;
                }
                super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Limit the number of characters
                if (fb.getDocument().getLength() + text.length() - length > maxCharacters ) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"CNIC Must Be Of 13 Characters","Cnic error!",JOptionPane.INFORMATION_MESSAGE);

                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        };

        // Set the DocumentFilter on the text field's document
        ((AbstractDocument) CnicTextField.getDocument()).setDocumentFilter(filter);


        CnicTextField.addKeyListener(new KeyAdapter() {
            int KeyCount = 0;

            public void keyTyped(KeyEvent e) {
                KeyCount++;


                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER)  || (c==KeyEvent.VK_D) ||(c ==KeyEvent.VK_TAB))) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame, "Enter only number", "Amount field error!", JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }

            }
            public void keyPressed(KeyEvent e) {
               int c = e.getKeyCode();

               if(c==KeyEvent.VK_DOWN || c ==KeyEvent.VK_ENTER)
               {
                   AccountNumberTextField.requestFocus();
               }

            }


        });


        EnterAccountHolderName.setBounds(400, 250, 230, 50);
        EnterAccountHolderName.setText("Name:");
        EnterAccountHolderName.setFont(font);
        EnterAccountHolderName.setForeground(foreground);

        HolderNameTextField.setBounds(600, 250, 300, 50);
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
                if (!((c >= 'A') && (c <= 'z' || c <= 'Z') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) || (c == KeyEvent.VK_SPACE ))) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Enter only Alphabet","Holder's name field error",JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }
            }


            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER ||e.getKeyCode()==KeyEvent.VK_DOWN  )
                {
                    InitialDepositTextField.requestFocus();
                }
                else if(e.getKeyCode()==KeyEvent.VK_UP)
                {
                    AccountNumberTextField.requestFocus();
                }
        }
        });


        EnterInitialDeposit.setBounds(400, 350, 230, 50);
        EnterInitialDeposit.setText("Balance:");
        EnterInitialDeposit.setFont(font);
        EnterInitialDeposit.setForeground(foreground);

        InitialDepositTextField.setBounds(600, 350, 300, 50);
        InitialDepositTextField.setFont(font);
        InitialDepositTextField.setHorizontalAlignment(JTextField.CENTER);
        InitialDepositTextField.setForeground(foreground);
        InitialDepositTextField.setBackground(background);
        InitialDepositTextField.setSelectionColor(foreground);
        InitialDepositTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        InitialDepositTextField.setCaretColor(foreground);

        InitialDepositTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER) )) {

                    if (!(c=='.')){
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(frame,"Enter only number","Amount field error!",JOptionPane.INFORMATION_MESSAGE);

                    }
                    e.consume();
                }
            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP )
                {
                   HolderNameTextField.requestFocus();
                } else if (e.getKeyCode()==KeyEvent.VK_ENTER||e.getKeyCode()==KeyEvent.VK_DOWN) {
                    EmailTestField.requestFocus();
                }

            }
        });

        AddAccount.setBounds(700, 650, 250, 50);
        AddAccount.setFont(font);
        AddAccount.setText("Add Account");
        AddAccount.setBackground(background);
        AddAccount.setForeground(foreground);
        AddAccount.setBorder(BorderFactory.createLineBorder(background, 2, false));
        AddAccount.setFocusable(false);

        AddAccount.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                AddAccount.setBackground(foreground);
                AddAccount.setForeground(background);
                AddAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                AddAccount.setBackground(background);
                AddAccount.setForeground(foreground);
                AddAccount.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            @Override
            public void mouseClicked(MouseEvent e) {



                if(!((CnicTextField.getText().equals("")) || (AccountNumberTextField.getText().equals("")) || (InitialDepositTextField.getText().equals("")) || (EmailTestField.getText().equals("")) || (HolderNameTextField.getText().equals(""))))
                {
                    if(CnicTextField.getText().length() != 13 ) {

                        JOptionPane.showMessageDialog(frame,"Enter 13 Digits CNIC!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                        CnicTextField.requestFocus();

                    }
                    else if (AccountNumberTextField.getText().length()!=5){
                        JOptionPane.showMessageDialog(frame,"Enter 5 digit Account number!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                        AccountNumberTextField.requestFocus();
                    } else if (HolderNameTextField.getText().length() <3) {
                        JOptionPane.showMessageDialog(frame,"Name must be greater than 3 character ","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                        HolderNameTextField.requestFocus();
                    }
                    else if(Integer.parseInt(InitialDepositTextField.getText()) < 500)
                    {
                        JOptionPane.showMessageDialog(frame,"Minimum 500 intial deposit","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                        InitialDepositTextField.setText("");
                        InitialDepositTextField.requestFocus();
                    }
                    else {


                        AddAccountToDatabase();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Enter Complete Information!","Incomplete Information Error",JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });

        BackButton.setBounds(500, 650, 150, 50);
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


    void AddAccountToDatabase()
    {

        String[] Data={AccountNumberTextField.getText(),HolderNameTextField.getText(),InitialDepositTextField.getText()};
        int AccNo=Integer.parseInt(Data[0]);
        int Bal=Integer.parseInt(Data[2]);
//        long nic =Long.parseLong( CnicTextField.getText());
        BigInteger cnic = new BigInteger(CnicTextField.getText());
        String name=String.valueOf(HolderNameTextField.getText());
        String address = String.valueOf(EmailTestField.getText());

        String gender;
        Long niccc = Long.parseLong(CnicTextField.getText());
        if(niccc % 2 == 0) {
            gender = "Female";
        }
        else{
            gender = "Male";
        }



        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();

            String insertSql = "INSERT INTO Bank (AccountNo,Name,Cnic,Gender,Balance,Address) VALUES ("+AccNo+",'"+name+"', "+cnic+" , '"+gender+"',"+Bal+" , '"+address+"')";
            statement.executeUpdate(insertSql);



            String Email= EmailTestField.getText();
//
            VerifyEmail verifyEmail = new VerifyEmail();




            if(!(verifyEmail.isAddressValid(Email)))
            {


                JOptionPane.showMessageDialog(frame,"Email Doesn't Exist","Verifying Email Error",JOptionPane.INFORMATION_MESSAGE);
                EmailTestField.setText("");
                String deleteSql = "DELETE FROM Bank WHERE AccountNo =" +AccNo ;
                statement.executeUpdate(deleteSql);

                return;

            }



            GMailSender gMailSender = new GMailSender();
            String to = address;
            String from = "udqbank@gmail.com";
            String subject = "Account Creation";
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
            Calendar cal = Calendar.getInstance();
            String time = sdf.format(cal.getTime());
            String date = sdf2.format(cal.getTime());

            String text = "Hey "+ name + "\nYour Account is Succefully Created on : "+time+ " " + date+"and Account Number is : "+AccNo + "\nInitial Deposit is Rs: "+Bal+"\nThanks For Choosing UDQ BANK";
            gMailSender.sendEmail(to, from, subject, text);

            EmailTestField.setText("");
            AccountNumberTextField.setText("");
            InitialDepositTextField.setText("");
            HolderNameTextField.setText("");
            CnicTextField.setText("");
            CnicTextField.requestFocus();

//            loadingframe.dispose();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(frame,"Account Created Successfully!","Account Creation",JOptionPane.INFORMATION_MESSAGE);
            connection.close();
        }
        catch (Exception e)
        {


            JOptionPane.showMessageDialog(frame,"Account Already Exists!","Existing Account Error",JOptionPane.INFORMATION_MESSAGE);
            CnicTextField.setText("");
            AccountNumberTextField.setText("");

        }
    }



    }


