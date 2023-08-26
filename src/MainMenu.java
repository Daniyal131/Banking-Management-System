import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainMenu {

    JFrame frame=new JFrame();

    JButton TransactionButton =new JButton();
    JButton CreateAccountButton =new JButton();
    JButton CheckDetailButton =new JButton();

    JButton LogoutButton =new JButton();

    JButton DeleteAccountButton = new JButton();

    JButton EditAccountButton = new JButton();



          MainMenu(String temp1, String temp2, String temp3,Color background,Color foreground,Font font){



              PanelOptions(temp1,temp2,temp3,background,foreground,font);

              frame.add(TransactionButton);
              frame.add(CreateAccountButton);
              frame.add(CheckDetailButton);
              frame.add(LogoutButton);
              frame.add(DeleteAccountButton);
              frame.add(EditAccountButton);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.setSize(1280,720);
              frame.setLayout(null);
              frame.setTitle("Admin Panel");
              frame.setResizable(false);
              frame.setLocationRelativeTo(null);

              frame.setVisible(true);

         }



    void PanelOptions(String temp1, String temp2, String temp3,Color background,Color foreground,Font font)
         {

             frame.getContentPane().setBackground(background);
             frame.getContentPane().setForeground(foreground);

             TransactionButton.setBounds(550,100,250,50);
             TransactionButton.setFont(font);
             TransactionButton.setText("Transaction");
             TransactionButton.setForeground(foreground);
             TransactionButton.setBackground(background);
             TransactionButton.setBorder(BorderFactory.createLineBorder(background));
             TransactionButton.setFocusable(false);

             TransactionButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     TransactionButton.setBackground(foreground);
                     TransactionButton.setForeground(background);
                     TransactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     TransactionButton.setBackground(background);
                     TransactionButton.setForeground(foreground);
                     TransactionButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }


                 public void mouseClicked(MouseEvent e) {
                     frame.dispose();
                     try {
                         frame.dispose();
                         new Transaction(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                     } catch (IOException ex) {
                         JOptionPane.showMessageDialog(null,"file error!");
                     }
                 }
             });

             CreateAccountButton.setBounds(550,200,300,50);
             CreateAccountButton.setFont(font);
             CreateAccountButton.setText("Create Account");
             CreateAccountButton.setForeground(foreground);
             CreateAccountButton.setBackground(background);
             CreateAccountButton.setBorder(BorderFactory.createLineBorder(background));
             CreateAccountButton.setFocusable(false);

             CreateAccountButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     CreateAccountButton.setBackground(foreground);
                     CreateAccountButton.setForeground(background);
                     CreateAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     CreateAccountButton.setBackground(background);
                     CreateAccountButton.setForeground(foreground);
                     CreateAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }


                 public void mouseClicked(MouseEvent e) {
                     frame.dispose();
                     new CreateAccount(temp1, temp2, temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                 }
             });

             CheckDetailButton.setBounds(550,400,250,50);
             CheckDetailButton.setFont(font);
             CheckDetailButton.setText("Check Detail");
             CheckDetailButton.setForeground(foreground);
             CheckDetailButton.setBackground(background);
             CheckDetailButton.setBorder(BorderFactory.createLineBorder(background));
             CheckDetailButton.setFocusable(false);

             CheckDetailButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     CheckDetailButton.setBackground(foreground);
                     CheckDetailButton.setForeground(background);
                     CheckDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     CheckDetailButton.setBackground(background);
                     CheckDetailButton.setForeground(foreground);
                     CheckDetailButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }

                 public void mousePressed(MouseEvent e) {
                     frame.dispose();
                     new CheckAccountDetail(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

                 }
             });

             DeleteAccountButton.setBounds(550,300,300,50);
             DeleteAccountButton.setFont(font);
             DeleteAccountButton.setText("Delete Account");
             DeleteAccountButton.setForeground(foreground);
             DeleteAccountButton.setBackground(background);
             DeleteAccountButton.setBorder(BorderFactory.createLineBorder(background));
             DeleteAccountButton.setFocusable(false);

             DeleteAccountButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     DeleteAccountButton.setBackground(foreground);
                     DeleteAccountButton.setForeground(background);
                     DeleteAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     DeleteAccountButton.setBackground(background);
                     DeleteAccountButton.setForeground(foreground);
                     DeleteAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }

                 public void mousePressed(MouseEvent e) {

                     frame.dispose();
                     new DeleteAccount(temp1, temp2, temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

                 }
             });

             EditAccountButton.setBounds(550,500,250,50);
             EditAccountButton.setFont(font);
             EditAccountButton.setText("Edit Account");
             EditAccountButton.setForeground(foreground);
             EditAccountButton.setBackground(background);
             EditAccountButton.setBorder(BorderFactory.createLineBorder(background));
             EditAccountButton.setFocusable(false);

             EditAccountButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     EditAccountButton.setBackground(foreground);
                     EditAccountButton.setForeground(background);
                     EditAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     EditAccountButton.setBackground(background);
                     EditAccountButton.setForeground(foreground);
                     EditAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }

                 public void mousePressed(MouseEvent e) {

                     frame.dispose();
                     new EditAccountInfo(temp1, temp2, temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

                 }
             });

             LogoutButton.setBounds(5,620,120,50);
             LogoutButton.setFont(font);
             LogoutButton.setText("Logout");
             LogoutButton.setForeground(foreground);
             LogoutButton.setBackground(background);
             LogoutButton.setBorder(BorderFactory.createLineBorder(background));
             LogoutButton.setFocusable(false);

             LogoutButton.addMouseListener(new MouseAdapter() {  //change cursor on mouse hover
                 public void mouseEntered(MouseEvent evt) {

                     LogoutButton.setBackground(foreground);
                     LogoutButton.setForeground(background);
                     LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                 }

                 public void mouseExited(MouseEvent evt) {

                     LogoutButton.setBackground(background);
                     LogoutButton.setForeground(foreground);
                     LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                 }


                 public void mouseClicked(MouseEvent e) {
                     IdAndPasswords idandpasswords = new IdAndPasswords();
                     frame.dispose();
                      new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

                 }
             });


         }


}
