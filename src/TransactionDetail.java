import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;


public class TransactionDetail {

    JFrame frame = new JFrame();

    JLabel BalanceLabel = new JLabel();

    JLabel AccountNumber = new JLabel();

    JLabel AccountNumberLabel = new JLabel();

    JLabel BalanceAmountLabel = new JLabel();

    JLabel AccountHolderName = new JLabel();

    JLabel AccountHolder = new JLabel();
    JButton BackButton = new JButton();

    JLabel EnterAmountLabel = new JLabel();

    JTextField EnterAmountTextField = new JTextField();


    JButton CreditButton = new JButton();

    JButton DebitButton = new JButton();



   public TransactionDetail(String temp1, String temp2, String temp3,Color Dark,Color foreground,Font font)
    {

        DisplayTransactionDetail(temp1, temp2, temp3,Dark,foreground,font);  //calling the display method

        frame.add(BalanceAmountLabel);
        frame.add(BalanceLabel);
        frame.add(EnterAmountLabel);
        frame.add(EnterAmountTextField);
        frame.add(CreditButton);
        frame.add(DebitButton);
        frame.add(AccountHolderName);
        frame.add(AccountHolder);
        frame.add(AccountNumber);
        frame.add(AccountNumberLabel);
        frame.add(BackButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setTitle("Transaction Detail Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);  //always opens the new frame with centre alignment relative to the monitor screen

        frame.setVisible(true);

    }



    void DisplayTransactionDetail(String temp1, String temp2, String temp3,Color background,Color foreground,Font font)
    {

        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);

        AccountNumber.setBounds(400, 100, 230, 50);
        AccountNumber.setText("Account Number:");
        AccountNumber.setFont(font);
        AccountNumber.setForeground(foreground);

        AccountNumberLabel.setBounds(650, 100, 300, 50);
        AccountNumberLabel.setText(temp1);
        AccountNumberLabel.setHorizontalAlignment(JLabel.CENTER);
        AccountNumberLabel.setFont(font);
        AccountNumberLabel.setForeground(foreground);
        AccountNumberLabel.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNumberLabel.setBackground(background);

        AccountHolder.setBounds(400, 200, 230, 50);
        AccountHolder.setText("Holder's Name:");
        AccountHolder.setFont(font);
        AccountHolder.setForeground(foreground);

        AccountHolderName.setBounds(650, 200, 300, 50);
        AccountHolderName.setText(temp2);
        AccountHolderName.setHorizontalAlignment(JLabel.CENTER);
        AccountHolderName.setFont(font);
        AccountHolderName.setForeground(foreground);
        AccountHolderName.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountHolderName.setBackground(background);

        BalanceLabel.setBounds(400, 300, 230, 50);
        BalanceLabel.setText("Your Balance Is:");
        BalanceLabel.setFont(font);
        BalanceLabel.setForeground(foreground);

        BalanceAmountLabel.setBounds(650, 300, 300, 50);
        BalanceAmountLabel.setText(temp3);
        BalanceAmountLabel.setHorizontalAlignment(JLabel.CENTER);
        BalanceAmountLabel.setFont(font);
        BalanceAmountLabel.setForeground(foreground);
        BalanceAmountLabel.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        BalanceAmountLabel.setBackground(background);

        EnterAmountLabel.setBounds(400, 400, 200, 50);
        EnterAmountLabel.setText("Enter Amount:");
        EnterAmountLabel.setFont(font);
        EnterAmountLabel.setForeground(foreground);
        EnterAmountLabel.setBackground(background);

        EnterAmountTextField.setBounds(650, 400, 300, 50);
        EnterAmountTextField.setFont(font);
        EnterAmountTextField.setHorizontalAlignment(JTextField.CENTER);
        EnterAmountTextField.setForeground(foreground);
        EnterAmountTextField.setBackground(background);
        EnterAmountTextField.setSelectionColor(foreground);
        EnterAmountTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        EnterAmountTextField.setCaretColor(foreground);

        EnterAmountTextField.addKeyListener(new KeyAdapter() {   // Key listener used for overseeing all the keyboard related actions
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)  )) {

                    if(!(c=='.'))
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Number!");

                    }
                    e.consume();
                }
            }
        });


        CreditButton.setBounds(500, 500, 150, 50);
        CreditButton.setFont(font);
        CreditButton.setText("Credit");
        CreditButton.setBackground(background);
        CreditButton.setForeground(foreground);
        CreditButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        CreditButton.setFocusable(false);

        CreditButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {  //Change cursor on hover
                CreditButton.setBackground(foreground);
                CreditButton.setForeground(background);
                CreditButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {  //Change cursor on hover
                CreditButton.setBackground(background);
                CreditButton.setForeground(foreground);
                CreditButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }


            public void mouseClicked(MouseEvent e) {  //performs functionality when credit button is clicked
                if(!(EnterAmountTextField.getText().equals("")))
                {
                    if (Integer.parseInt(EnterAmountTextField.getText()) < 500)
                    {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(frame,"Amount must be atleast 500!","Amount field error!",JOptionPane.INFORMATION_MESSAGE);
                        EnterAmountTextField.setText("");
                    }
                   else {
                        int Check=0;
                        String CreditAmount=EnterAmountTextField.getText();
                        frame.dispose();
                        try {
                            new AfterCrediting(temp1,temp2,temp3,CreditAmount,Check,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Amount Field is Empty!","Amount field error!",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        DebitButton.setBounds(700, 500, 150, 50);
        DebitButton.setFont(font);
        DebitButton.setText("Debit");
        DebitButton.setBackground(background);
        DebitButton.setForeground(foreground);
        DebitButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        DebitButton.setFocusable(false);

        DebitButton.addMouseListener(new MouseAdapter() {   //Change cursor on hover
            public void mouseEntered(MouseEvent evt) {
                DebitButton.setBackground(foreground);
                DebitButton.setForeground(background);
                DebitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            public void mouseExited(MouseEvent evt) {  //Change cursor on hover
                DebitButton.setBackground(background);
                DebitButton.setForeground(foreground);
                DebitButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            @Override
            public void mouseClicked(MouseEvent e) {  //performs functionality when debit button is clicked

                if(!(EnterAmountTextField.getText().equals("")))
                {
                    int Check=1;
                    String CreditAmount=EnterAmountTextField.getText();
                    if(Integer.parseInt(CreditAmount) >=Integer.parseInt(temp3)) {
                        JOptionPane.showMessageDialog(frame,"Insufficient Balance!","Low Balance!",JOptionPane.INFORMATION_MESSAGE);
                        EnterAmountTextField.setText("");
                    }
                    else{
                        frame.dispose();
                        try {
                            new AfterCrediting(temp1, temp2, temp3, CreditAmount, Check, frame.getContentPane().getBackground(), frame.getContentPane().getForeground(),font);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
                else
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Amount Field is Empty!","Amount field error!",JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });

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

            public void mouseExited(MouseEvent evt) {   //change cursor on hover
                BackButton.setBackground(background);
                BackButton.setForeground(foreground);
                BackButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            }

            public void mouseClicked(MouseEvent e) { //performs functionality when back button is clicked

                if(e.getSource()==BackButton)
                {
                    frame.dispose();
                    try {
                        new Transaction(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

    }

}
