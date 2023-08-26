import org.apache.commons.dbcp2.BasicDataSource;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class CheckAccountDetail {



    Color background;
    Color foreground;

    JFrame frame = new JFrame();

    JLabel CnicLabel = new JLabel();

    JLabel AccountNumber = new JLabel();

    JLabel GenderLabael = new JLabel();

    JLabel BalanceLabel = new JLabel();

    JLabel AddressLabel = new JLabel();


    JTextField AccountNumberTextField = new JTextField();

    JTextField CnicTextField = new JTextField();

    JTextField AccountHolderNameTextField = new JTextField();

    JTextField GenderTextField = new JTextField();

    JTextField BalanceTextField = new JTextField();

    JTextField AddressTextField = new JTextField();

    JLabel AccountHolder = new JLabel();

    JLabel SearchAccountLabel = new JLabel();

    JTextField SearchAccountTextField = new JTextField();
    JButton BackButton = new JButton();
    JButton RefreshButton = new JButton();


    JTable Table = new JTable();

    DefaultTableModel model=new DefaultTableModel();

    JScrollPane Scroll;



    public CheckAccountDetail(String temp1, String temp2, String temp3, Color Dark, Color textcolor,Font font)
    {


        ThemeCheck(temp1, temp2, temp3,Dark,textcolor,font);

        frame.add(CnicTextField);
        frame.add(CnicLabel);
        frame.add(AccountHolderNameTextField);
        frame.add(AccountHolder);
        frame.add(AccountNumber);
        frame.add(AccountNumberTextField);
        frame.add(BackButton);
        frame.add(RefreshButton);
        frame.add(GenderLabael);
        frame.add(BalanceLabel);
        frame.add(AddressLabel);
        frame.add(GenderTextField);
        frame.add(BalanceTextField);
        frame.add(AddressTextField);
        frame.add(SearchAccountTextField);
        frame.add(SearchAccountLabel);
        frame.add(Scroll);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800,900);
        frame.setLayout(null);
        frame.setTitle("Transaction Detail Panel");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);





        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bank");

            while (resultSet.next())
            {
                String []data={
                        String.valueOf(resultSet.getInt(1)),
                        resultSet.getString(2),
                        String.valueOf(resultSet.getLong(3)),
                        resultSet.getString(4),
                        String.valueOf(resultSet.getInt(5)),
                        resultSet.getString(6),
                };
                if(resultSet.getInt(1) == 999999){
                    break;
                }
                model.addRow(data);
            }
            connection.close();



        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


        frame.setVisible(true);

    }



    void ThemeCheck(String temp1, String temp2, String temp3,Color Dark,Color textcolor,Font font)
    {

        background=Dark;
        foreground=textcolor;

        DisplayTransactionDetail(temp1, temp2, temp3,font);

    }


    void DisplayTransactionDetail(String temp1, String temp2, String temp3,Font font)
    {

        frame.getContentPane().setBackground(background);
        frame.getContentPane().setForeground(foreground);

        SearchAccountLabel.setBounds(100, 100, 230, 50);
        SearchAccountLabel.setText("Search:");
        SearchAccountLabel.setFont(font);
        SearchAccountLabel.setForeground(foreground);

        SearchAccountTextField.setBounds(300, 100, 300, 50);
        SearchAccountTextField.setHorizontalAlignment(JLabel.CENTER);
        SearchAccountTextField.setFont(font);
        SearchAccountTextField.setForeground(foreground);
        SearchAccountTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        SearchAccountTextField.setBackground(background);

        SearchAccountTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int check=0;
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    for(int i=0;i<Table.getRowCount();i++)
                    {
                        if(( SearchAccountTextField.getText().equals(String.valueOf(Table.getValueAt(i,0))) )|| ( SearchAccountTextField.getText().equals(String.valueOf(Table.getValueAt(i,2))) ))
                        {

                            AccountNumberTextField.setText(model.getValueAt(i,0).toString());
                            AccountHolderNameTextField.setText(model.getValueAt(i,1).toString());
                            CnicTextField.setText(model.getValueAt(i,2).toString());
                            GenderTextField.setText(model.getValueAt(i,3).toString());
                            BalanceTextField.setText(model.getValueAt(i,4).toString());
                            AddressTextField.setText(model.getValueAt(i,5).toString());
                            SearchAccountTextField.setText("");
                            check=1;
                            break;
                        }

                    }

                    if(check==0)
                    {
                        JOptionPane.showMessageDialog(frame,"Account doesn't exist","Amount field error!",JOptionPane.INFORMATION_MESSAGE);
                        SearchAccountTextField.setText("");

                    }


                }
            }
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER))) {

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame,"Enter only number","Amount field error!",JOptionPane.INFORMATION_MESSAGE);
                    e.consume();
                }
            }
        });



        AccountNumber.setBounds(100, 190, 230, 50);
        AccountNumber.setText("Account No:");
        AccountNumber.setFont(font);
        AccountNumber.setForeground(foreground);

        AccountNumberTextField.setBounds(300, 190, 300, 50);
        AccountNumberTextField.setHorizontalAlignment(JLabel.CENTER);
        AccountNumberTextField.setFont(font);
        AccountNumberTextField.setForeground(foreground);
        AccountNumberTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountNumberTextField.setBackground(background);
        AccountNumberTextField.setEditable(false);



        AccountHolder.setBounds(100, 290, 230, 50);
        AccountHolder.setText("Name:");
        AccountHolder.setFont(font);
        AccountHolder.setForeground(foreground);

        AccountHolderNameTextField.setBounds(300, 290, 300, 50);
        AccountHolderNameTextField.setHorizontalAlignment(JLabel.CENTER);
        AccountHolderNameTextField.setFont(font);
        AccountHolderNameTextField.setForeground(foreground);
        AccountHolderNameTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AccountHolderNameTextField.setBackground(background);
        AccountHolderNameTextField.setEditable(false);





        CnicLabel.setBounds(100, 390, 230, 50);
        CnicLabel.setText("Cnic:");
        CnicLabel.setFont(font);
        CnicLabel.setForeground(foreground);

        CnicTextField.setBounds(300, 390, 300, 50);
        CnicTextField.setHorizontalAlignment(JLabel.CENTER);
        CnicTextField.setFont(font);
        CnicTextField.setForeground(foreground);
        CnicTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        CnicTextField.setBackground(background);
        CnicTextField.setEditable(false);



        GenderLabael.setBounds(100, 490, 230, 50);
        GenderLabael.setText("Gender:");
        GenderLabael.setFont(font);
        GenderLabael.setForeground(foreground);

        GenderTextField.setBounds(300, 490, 300, 50);
        GenderTextField.setHorizontalAlignment(JLabel.CENTER);
        GenderTextField.setFont(font);
        GenderTextField.setForeground(foreground);
        GenderTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        GenderTextField.setBackground(background);
        GenderTextField.setEditable(false);

        BalanceLabel.setBounds(100, 590, 230, 50);
        BalanceLabel.setText("Baalance:");
        BalanceLabel.setFont(font);
        BalanceLabel.setForeground(foreground);

        BalanceTextField.setBounds(300, 590, 300, 50);
        BalanceTextField.setHorizontalAlignment(JLabel.CENTER);
        BalanceTextField.setFont(font);
        BalanceTextField.setForeground(foreground);
        BalanceTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        BalanceTextField.setBackground(background);
        BalanceTextField.setEditable(false);

        AddressLabel.setBounds(100, 690, 230, 50);
        AddressLabel.setText("Address:");
        AddressLabel.setFont(font);
        AddressLabel.setForeground(foreground);

        AddressTextField.setBounds(300, 690, 550, 50);
        AddressTextField.setHorizontalAlignment(JLabel.CENTER);
        AddressTextField.setFont(font);
        AddressTextField.setForeground(foreground);
        AddressTextField.setBorder(BorderFactory.createLineBorder(foreground, 2, true));
        AddressTextField.setBackground(background);
        AddressTextField.setEditable(false);



        BackButton.setBounds(0, 800, 150, 50);
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

        RefreshButton.setBounds(1650, 800, 150, 50);
        RefreshButton.setText("Refresh");
        RefreshButton.setFont(font);
        RefreshButton.setBackground(background);
        RefreshButton.setForeground(foreground);
        RefreshButton.setBorder(BorderFactory.createLineBorder(background, 2, false));
        RefreshButton.setFocusable(false);

        RefreshButton.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {
                RefreshButton.setBackground(foreground);
                RefreshButton.setForeground(background);
                RefreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent evt) {
                RefreshButton.setBackground(background);
                RefreshButton.setForeground(foreground);
                RefreshButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(MouseEvent e) {

                if(e.getSource()==RefreshButton)
                {

                    frame.dispose();
                    new CheckAccountDetail(temp1,temp2,temp3,frame.getContentPane().getBackground(),frame.getContentPane().getForeground(),font);
                }
            }

        });



        DisplayTable();





    }


    void DisplayTable()
    {



        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)Table.getDefaultRenderer(Object.class);
        renderer.setHorizontalAlignment( SwingConstants.CENTER );

        String[] ColumnNames={"ID","NAME","CNIC","GENDER","AMOUNT","ADDRESS"};


        Table.setBackground(background);
        Table.setForeground(foreground);
        Table.getTableHeader().setBackground(foreground);
        Table.getTableHeader().setForeground(background);
        Table.getTableHeader().setFont(new Font(Font.SERIF,Font.BOLD,20));
        Table.setBorder(BorderFactory.createLineBorder(foreground));
        Table.setGridColor(foreground);
        Table.setSelectionBackground(foreground);
        Table.setSelectionForeground(background);
        Table.setDefaultEditor(Object.class,null);





        Table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i=Table.getSelectedRow();

                AccountNumberTextField.setText(model.getValueAt(i,0).toString());
                AccountHolderNameTextField.setText(model.getValueAt(i,1).toString());
                CnicTextField.setText(model.getValueAt(i,2).toString());
                GenderTextField.setText(model.getValueAt(i,3).toString());
                BalanceTextField.setText(model.getValueAt(i,4).toString());
                AddressTextField.setText(model.getValueAt(i,5).toString());



            }

        });


        Scroll=new JScrollPane();
        Scroll.setViewportView(Table);
        Scroll.setBounds(900,100,800,550);
        Scroll.getViewport().setBackground(background);
        Scroll.setBorder(BorderFactory.createLineBorder(foreground));


        Scroll.setOpaque(true);

        model=(DefaultTableModel)Table.getModel();
        model.setColumnIdentifiers(ColumnNames);



        Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int i = Table.getSelectedRow();
                AccountNumberTextField.setText(model.getValueAt(i,0).toString());
                AccountHolderNameTextField.setText(model.getValueAt(i,1).toString());
                CnicTextField.setText(model.getValueAt(i,2).toString());
                GenderTextField.setText(model.getValueAt(i,3).toString());
                BalanceTextField.setText(model.getValueAt(i,4).toString());
                AddressTextField.setText(model.getValueAt(i,5).toString());
            }
        });



    }



}
