import javax.swing.*;
import java.awt.*;


public class intro {
    JFrame frame = new JFrame("Frame");
    JLabel welcome=new JLabel("WELCOME TO");
    JLabel bank=new JLabel("UDQ BANK");

    Icon imgIcon = new ImageIcon(this.getClass().getResource("loading.gif"));
    JLabel loading = new JLabel(imgIcon);
    public intro()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(welcome);
        frame.add(bank);
        frame.add(loading);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setTitle("Login Page");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        loading.setBounds(450, 500, 500, 100);
        frame.getContentPane().add(loading);
        frame.setVisible(true);
      welcome.setBounds(520,100,300,300);
      welcome.setFont(new Font("Serif", Font.BOLD, 40));
        bank.setBounds(550,200,300,300);
        bank.setFont(new Font("Serif", Font.BOLD, 40));

      for(int i=1;i<92999992;i++)
      {
          for (int j=1;j<99;j++){
              for (int k=1;k<99;k++){

              }

          }
      }
      end();
    }

    public void end()
    {
frame.dispose();
    }

}


