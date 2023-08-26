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
import java.io.*;
import java.sql.*;
import java.sql.ResultSet;

public class Transaction {


    JFrame frame = new JFrame();

    JLabel AccountNo = new JLabel();

    JTextField AccountNoField = new JTextField();

   JButton BackButton=new JButton();

   JButton EnterButton = new JButton();


    Transaction(String temp1, String temp2, String temp3,Color Dark,Color foreground,Font font) throws IOException {

        TransactionMethod(temp1,temp2,temp3,Dark,foreground,font);



        frame.add(AccountNo);
        frame.add(AccountNoField);
        frame.add(BackButton);
        frame.add(EnterButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setTitle("Transaction Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);


    }

    void TransactionMethod(String temp1, String temp2, String temp3,Color background, Color foreground,Font font)  {




        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);


        AccountNo.setBounds(400, 300, 220, 50);
        AccountNo.setText("Account Number:");
        AccountNo.setFont(font);
        AccountNo.setForeground(foreground);

        AccountNoField.setBounds(630, 300, 300, 50);
        AccountNoField.setFont(font);
        AccountNoField.setHorizontalAlignment(JTextField.CENTER);
        AccountNoField.setForeground(foreground);
        AccountNoField.setBackground(background);
        AccountNoField.setSelectionColor(foreground);
        AccountNoField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNoField.setCaretColor(foreground);



        AccountNoField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Enter a number!","Invalid Input",JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }

            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    if(AccountNoField.getText().equals("") )
                    {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(frame,"Account Number Field is Empty!","Account Number field error!",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        EnterToTransactionPanel(temp2,temp3,font);
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
        ((AbstractDocument) AccountNoField.getDocument()).setDocumentFilter(Filter);

        BackButton.setBounds(0, 625, 150, 50);
        BackButton.setText("Back");
        BackButton.setFont(font);
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

                if(e.getSource()==BackButton)
                {
                    frame.dispose();
                     new MainMenu(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                }
            }
        });

        EnterButton.setBounds(1100, 625, 150, 50);
        EnterButton.setText("Continue");
        EnterButton.setFont(font);
        EnterButton.setBackground(background);
        EnterButton.setForeground(foreground);
        EnterButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        EnterButton.setFocusable(false);

        EnterButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                EnterButton.setBackground(foreground);
                EnterButton.setForeground(background);
                EnterButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {
                EnterButton.setBackground(background);
                EnterButton.setForeground(foreground);
                EnterButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            @Override
            public void mouseClicked(MouseEvent e) {


                    if(AccountNoField.getText().equals("") )
                    {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(frame,"Account Number Field is Empty!","Account Number field error!",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {

                        EnterToTransactionPanel(temp2,temp3,font);
                    }

            }

        });


    }

    void EnterToTransactionPanel(String temp2, String temp3,Font font)
    {


        try {

            int check=0;
            String temp1 = AccountNoField.getText();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bank");
            int accountQasim = Integer.parseInt(temp1);
            while(resultSet.next()){
                if(resultSet.getInt(1) == accountQasim) {
                    temp2 = resultSet.getString(2);
                    temp3 = String.valueOf(resultSet.getInt(5));
                    check=1;
                }
            }


            if(check==1)
            {
                frame.dispose();
                new TransactionDetail(temp1,  temp2,  temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
            }
            else
            {
                JOptionPane.showMessageDialog(frame,"Account Doesn't Exist!" ,"Account error!",JOptionPane.INFORMATION_MESSAGE);
                AccountNoField.setText("");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }







}
