import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.HashMap;


public class LoginPage  {

    boolean AlreadyExecuted=false;
    JFrame frame = new JFrame();

    JButton LoginButton = new JButton("Login");

    JMenuBar menuBar = new JMenuBar();

    JMenuItem exit = new JMenuItem();
    JMenuItem TextColor = new JMenuItem();
    JMenuItem BackgroundColor = new JMenuItem();

    JMenu MonospaceMenu = new JMenu("Monospace");
    JMenuItem Monospace_PlainItem = new JMenuItem("Monospace Plain");
    JMenuItem Monospace_ItalicItem = new JMenuItem("Monospace Italic");
    JMenuItem Monospace_BoldItem = new JMenuItem("Monospace Bold");


    JMenu SansSerifMenu = new JMenu("SansSerif");
    JMenuItem SansSerif_PlainItem = new JMenuItem("SansSerif Plain");
    JMenuItem SansSerif_BoldItem = new JMenuItem("SansSerif Bold");
    JMenuItem SansSerif_ItalicItem = new JMenuItem("SansSerif Italic");


    JMenu SerifMenu = new JMenu("Serif");
    JMenuItem Serif_PlainItem = new JMenuItem("Serif Plain");
    JMenuItem Serif_BoldItem = new JMenuItem("Serif Bold");
    JMenuItem Serif_ItalicItem = new JMenuItem("Serif Italic");







    JMenuItem StyleItem = new JMenuItem();
    JMenu FontMenu = new JMenu();


    JMenu FileMenu = new JMenu("File");
    JMenu ViewMenu = new JMenu("View");

    JMenu Font_StyleMenu = new JMenu("Font And Style");

    JMenu ThemeMenu = new JMenu();



    JButton updatePassword = new JButton("Update Password");

    JLabel UserLabel = new JLabel("Username:");

    JLabel PasswordLabel = new JLabel("Password:");

    JLabel Message = new JLabel();
    
    JPasswordField PasswordField = new JPasswordField();
    JTextField UserIdField = new JTextField();



    HashMap<String,String> loginInfo;
    LoginPage(HashMap<String,String> loginInfoOR,String temp1, String temp2, String temp3,Color backgroundcolor,Color textcolor,Font font){


        loginInfo = loginInfoOR;


        CheckPanelColor(backgroundcolor,textcolor);
        Theme(temp1, temp2, temp3,font);


        frame.add(UserLabel);
        frame.add(PasswordLabel);
        frame.add(UserIdField);
        frame.add(PasswordField);
        frame.add(LoginButton);
        frame.add(updatePassword);
        frame.add(Message);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setTitle("Login Page");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);



    }



    void CheckPanelColor(Color backgroundcolor, Color textcolor)
    {


        SetBackgroundColor(backgroundcolor);
        SetTextColor(textcolor);

    }



    void SetTextColor(Color textcolor)
    {
        frame.getContentPane().setForeground(textcolor);

        FileMenu.setForeground(textcolor);
        ViewMenu.setForeground(textcolor);
        exit.setForeground(textcolor);
        TextColor.setForeground(textcolor);
        BackgroundColor.setForeground(textcolor);

        UserLabel.setForeground(textcolor);
        PasswordLabel.setForeground(textcolor);

        UserIdField.setForeground(textcolor);
        UserIdField.setSelectionColor(textcolor);
        UserIdField.setBorder(BorderFactory.createLineBorder(textcolor, 2, true));
        UserIdField.setCaretColor(textcolor);

        PasswordField.setForeground(textcolor);
        PasswordField.setSelectionColor(textcolor);
        PasswordField.setBorder(BorderFactory.createLineBorder(textcolor, 2, true));
        PasswordField.setCaretColor(textcolor);

//        PasswordField.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                Image cursorImage = Toolkit.getDefaultToolkit().getImage("cursor6.png");
//                Point cursorHotSpot = new Point(0,0);
//                Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, cursorHotSpot, "cursor");
//                PasswordField.setCursor(customCursor);
//            }
//
////        });
//
//        Image cursorImage = Toolkit.getDefaultToolkit().getImage("cursor.png");
//        Point cursorHotSpot = new Point(0,0);
//        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, cursorHotSpot, "cursor");
//        frame.setCursor(customCursor);

        LoginButton.setForeground(textcolor);
        LoginButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {

                LoginButton.setBackground(textcolor);
                LoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//                Image cursorImage = Toolkit.getDefaultToolkit().getImage("cursor5.png");
//                Point cursorHotSpot = new Point(0,0);
////                Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, cursorHotSpot, "cursor");
//                LoginButton.setCursor(customCursor);
            }

            public void mouseExited(MouseEvent evt) {

                LoginButton.setForeground(textcolor);
            }



        });

        updatePassword.setForeground(textcolor);
        updatePassword.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {

                updatePassword.setBackground(textcolor);

                updatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {


                updatePassword.setForeground(textcolor);
                updatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }



        });



    }
    void  SetBackgroundColor(Color backgroundcolor)
    {
        frame.getContentPane().setBackground(backgroundcolor);

        menuBar.setBackground(backgroundcolor);

        FileMenu.setBackground(backgroundcolor);

        ViewMenu.setBackground(backgroundcolor);

        exit.setBackground(backgroundcolor);

        TextColor.setBackground(backgroundcolor);

        BackgroundColor.setBackground(backgroundcolor);


        UserIdField.setBackground(backgroundcolor);

        PasswordField.setBackground(backgroundcolor);

        LoginButton.setBackground(backgroundcolor);
        LoginButton.setBorder(BorderFactory.createLineBorder(backgroundcolor, 2, false));

        LoginButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {


                LoginButton.setForeground(backgroundcolor);


            }

            public void mouseExited(MouseEvent evt) {

                LoginButton.setBackground(backgroundcolor);

            }



        });

        updatePassword.setBackground(backgroundcolor);
        updatePassword.setBorder(BorderFactory.createLineBorder(backgroundcolor, 2, false));

        updatePassword.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {


                updatePassword.setForeground(backgroundcolor);
                updatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {

                updatePassword.setBackground(backgroundcolor);
                updatePassword.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }



        });


    }

    void Theme (String temp1, String temp2, String temp3,Font font)
    {


        int check=0;

        KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);


        menuBar.add(FileMenu);
        menuBar.add(ViewMenu);
        exit.setText("exit");
        exit.setAccelerator(keyStrokeToOpen);


        TextColor.setText("Text Color");
        BackgroundColor.setText("Background Color");
        ThemeMenu.setText("Theme");
        FontMenu.setText("Font");
        StyleItem.setText("Style");

        FileMenu.add(exit);

        ViewMenu.add(ThemeMenu);
        ThemeMenu.add(TextColor);
        ThemeMenu.add(BackgroundColor);

        ViewMenu.add(Font_StyleMenu);

        Font_StyleMenu.add(StyleItem);

        Font_StyleMenu.add(FontMenu);

        FontMenu.add(SansSerifMenu);
        SansSerifMenu.add(SansSerif_BoldItem);
        SansSerifMenu.add(SansSerif_PlainItem);
        SansSerifMenu.add(SansSerif_ItalicItem);


        FontMenu.add(SerifMenu);
        SerifMenu.add(Serif_BoldItem);
        SerifMenu.add(Serif_PlainItem);
        SerifMenu.add(Serif_ItalicItem);

        FontMenu.add(MonospaceMenu);
        MonospaceMenu.add(Monospace_BoldItem);
        MonospaceMenu.add(Monospace_PlainItem);
        MonospaceMenu.add(Monospace_ItalicItem);

        checkFont(temp1,temp2, temp3);

        BackgroundColor.addActionListener(e -> {

            Color BackgroundColor1 =JColorChooser.showDialog(null,"Choose Background Color",Color.white);
            SetBackgroundColor(BackgroundColor1);

        });

        TextColor.addActionListener(e -> {

            Color TextColor1 =JColorChooser.showDialog(null,"Choose Text Color",Color.BLACK);
            SetTextColor(TextColor1);

        });


        exit.addActionListener(e -> System.exit(0));


        UserLabel.setBounds(430, 200, 200, 50);
        UserLabel.setFont(font);


        PasswordLabel.setBounds(430, 280, 200, 50);
        PasswordLabel.setFont(font);





        UserIdField.setBounds(600, 200, 200, 50);
        UserIdField.setFont(font);
        UserIdField.setHorizontalAlignment(JTextField.CENTER);
        UserIdField.requestFocus();
        String len=String.valueOf(UserIdField.getText());


        UserIdField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                UserIdField.setEditable(Character.isLetter(c) || Character.isISOControl(c));

                if(e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_DOWN )
                {
                    PasswordField.requestFocus();
                }

            }

            @Override
            public void keyTyped(KeyEvent e) {
                if(len.length()>15)
                {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Username is More than 15 Characters","Username too long error!",JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }
            }
        });

        PasswordField.setBounds(600, 280, 200, 50);
        PasswordField.setFont(font);
        PasswordField.setHorizontalAlignment(JTextField.CENTER);


        PasswordField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    String UserId = UserIdField.getText();
                    String Password = String.valueOf(PasswordField.getPassword());


                    if(loginInfo.containsKey(UserId))
                    {

                        if(loginInfo.get(UserId).equals(Password) )
                        {

                            if(!AlreadyExecuted && check==0)
                            {
                                frame.dispose();
                                System.out.println(font);
                                new MainMenu(temp1, temp2, temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                                AlreadyExecuted=true;
                            }

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Incorrect Password!");
                            keyPressed(null);

                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect Username!");
                        keyPressed(null);

                    }
                }
                if( e.getKeyCode()==KeyEvent.VK_UP)
                {
                    UserIdField.requestFocus();
                }
            }
        });



        LoginButton.setBounds(430, 350, 150, 50);
        LoginButton.setFont(font);
        LoginButton.setFocusable(false);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==LoginButton )
                {

                    String UserId = UserIdField.getText();
                    String Password = String.valueOf(PasswordField.getPassword());


                    if(loginInfo.containsKey(UserId))
                    {

                        if(loginInfo.get(UserId).equals(Password) )
                        {
                            if(!AlreadyExecuted && check==0)
                            {
                                frame.dispose();
                                new MainMenu(temp1, temp2, temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                                AlreadyExecuted=true;


                            }


                        }
                        else
                        {

                            JOptionPane.showMessageDialog(null,"Incorrect Password!");
                            try {

                                actionPerformed(null);
                            }
                            catch (Exception j)
                            {
                                System.out.println("Exception");

                            }

                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect Username!");
                        try {

                            actionPerformed(null);
                        }
                        catch (Exception j)
                        {
                            System.out.println("Exception");

                        }

                    }
                }
            }
        });


        updatePassword.setBounds(630, 350, 300, 50);
        updatePassword.setFont(font);
        updatePassword.setFocusable(false);


        updatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==updatePassword )
                {

                    String UserId = UserIdField.getText();
                    String Password = String.valueOf(PasswordField.getPassword());


                    if(loginInfo.containsKey(UserId))
                    {

                        if(loginInfo.get(UserId).equals(Password) )
                        {
                            if(!AlreadyExecuted && check==0)
                            {
                                frame.dispose();
                            new ChangePassword(temp1,  temp2,  temp3,UserId,Password,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

                                AlreadyExecuted=true;


                            }


                        }
                        else
                        {

                            JOptionPane.showMessageDialog(null,"Incorrect Password!");
                            try {

                                actionPerformed(null);
                            }
                            catch (Exception j)
                            {
                                System.out.println("Exception");

                            }

                        }

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect Username!");
                        try {

                            actionPerformed(null);
                        }
                        catch (Exception j)
                        {
                            System.out.println("Exception");

                        }

                    }
                }
            }
        });








    }
    void checkFont(String temp1, String temp2, String temp3)
    {
//        PasswordField.setBounds(600, 280, 200, 50);
//        UserIdField.setBounds(600, 200, 200, 50);
//        PasswordLabel.setBounds(430, 280, 150, 50);
//        UserLabel.setBounds(430, 200, 150, 50);

        Serif_PlainItem.addActionListener(e -> {

            int style =Font.PLAIN;
            String fontname= Font.SERIF;

           Font font = new Font(fontname, style, 30);

//           Theme(temp1, temp2, temp3, font);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        Serif_BoldItem.addActionListener(e -> {

            int style =Font.BOLD;
            String fontname= Font.SERIF;

            Font font = new Font(fontname, style, 30);

//            Theme(temp1, temp2, temp3, font);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        Serif_ItalicItem.addActionListener(e -> {

            int style =Font.ITALIC;
            String fontname= Font.SERIF;

            Font font = new Font(fontname, style, 30);

//            Theme(temp1, temp2, temp3, font);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        Monospace_PlainItem.addActionListener(e -> {

            int style =Font.PLAIN;
            String fontname= Font.MONOSPACED;

            Font font = new Font(fontname, style, 30);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        Monospace_BoldItem.addActionListener(e -> {

            int style =Font.BOLD;
            String fontname= Font.MONOSPACED;

            Font font = new Font(fontname, style, 30);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        Monospace_ItalicItem.addActionListener(e -> {

            int style =Font.ITALIC;
            String fontname= Font.MONOSPACED;

            Font font = new Font(fontname, style, 30);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });


        SansSerif_PlainItem.addActionListener(e -> {

            int style =Font.PLAIN;
            String fontname= Font.SANS_SERIF;

            Font font = new Font(fontname, style, 30);

//            Theme(temp1, temp2, temp3, font);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        SansSerif_BoldItem.addActionListener(e -> {

            int style =Font.BOLD;
            String fontname= Font.SANS_SERIF;

            Font font = new Font(fontname, style, 30);

//            Theme(temp1, temp2, temp3, font);
            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });

        SansSerif_ItalicItem.addActionListener(e -> {

            int style =Font.ITALIC;
            String fontname= Font.SANS_SERIF;

            Font font = new Font(fontname, style, 30);

            IdAndPasswords idandpasswords = new IdAndPasswords();
            frame.dispose();
            new LoginPage(idandpasswords.getLoginInfo(),temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);

        });


    }

}

