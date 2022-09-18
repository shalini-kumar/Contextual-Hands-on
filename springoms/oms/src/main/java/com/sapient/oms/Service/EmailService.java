package com.sapient.oms.Service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sapient.oms.Entity.Customer;

public class EmailService {

    public String sendmail(String subject, String body,String email) {
        if(email == null) {
            return "Mail not sent";
        }
        String sender = "shalini.sa2k@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shalini.sa2k@gmail.com", "goekfbzaafpcbvvv");
            }
        });

        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(sender);

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject(subject);

            message.setText(body);
           
            Transport.send(message);
            return "Mail sent successfully";
        } catch (MessagingException mex) {
            return "Mail not sent";
        }
    }

    public void sendmail(String recipient, Customer customer) {
    }
}