import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import javax.security.auth.login.AccountNotFoundException;
import javax.swing.*;
import java.util.Arrays;
import java.util.Properties;

public class GMailSender {
    public boolean sendEmail(String to, String from ,String subject, String text)
    {
        boolean flag = false;
        boolean isValid=false;
        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.host","smtp.gmail.com");

        String username="udqbank";
        String password="wuflnvjpyovpvard";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }

        });

        try {

            Message message = new MimeMessage(session);

            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);


//                Transport.send(message);


            try {
                Transport.send(message);
                flag=true;
            } catch (SendFailedException e) {
                Address[] invalid = e.getValidUnsentAddresses();
                System.out.println("Invalid email address(es) not found: " + Arrays.toString(invalid));
            }







        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Email Not Sent!!","Sending Code",JOptionPane.INFORMATION_MESSAGE);

        }

        return  flag;
    }
}

