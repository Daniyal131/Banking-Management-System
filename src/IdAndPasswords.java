import java.sql.*;
import java.sql.ResultSet;
import java.util.HashMap;

public class IdAndPasswords {








    HashMap<String,String> LoginInfo = new HashMap<>();
    IdAndPasswords()
    {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592825" , "sql12592825" , "w1EcNIGR4q");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Bank");
            while (resultSet.next())
            {
                String []data={
                        String.valueOf(resultSet.getInt(1)),
                        String.valueOf(resultSet.getLong(3)),

                };
                if (data[0].equals("999999")){
                    LoginInfo.put("q",data[1]);
                    break;
                }

            }

            connection.close();


        } catch (Exception e) {
//            LoginInfo.put("q","q");
            System.out.println(e);
        }




    }

    protected HashMap getLoginInfo() {
        return LoginInfo;
    }
}

