/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import userinterface.Registration;

/**
 *
 * @author nbabu
 */
public class Mail {
    private String recepient;
    private String code;
    public Mail(String recepient, String code)
    {
      this.recepient = recepient;
      this.code = code;
    }
    public Message prepareMessage(Session session, String fromMail, String recepient, String code)
    {      
        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("One Time Password");
            message.setText("Your OTP to successfully register is " + code + ".");
            return message;
        } 
        catch (Exception ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void sendMail()
    {
      Properties properties = new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      
      String fromMail = "paymentappaed@gmail.com";
      String password = "dppzgjmxqahmrenu";
      Session session = Session.getInstance(properties, new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
          return new PasswordAuthentication(fromMail, password);
        }
      });
      Message message = prepareMessage(session, fromMail, recepient, code);
        try 
        {
            Transport.send(message);
        } 
        catch (MessagingException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Message prepareMessage(Session session, String fromMail, String recepient, String msg, int a)
    {      
        try 
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Ticket booked");
            message.setText(msg);
            return message;
        } 
        catch (Exception ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void sendMail(String recepient, String msg)
    {
      Properties properties = new Properties();
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.port", "587");
      
      String fromMail = "paymentappaed@gmail.com";
      String password = "dppzgjmxqahmrenu";
      Session session = Session.getInstance(properties, new Authenticator(){
        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
          return new PasswordAuthentication(fromMail, password);
        }
      });
      Message message = prepareMessage(session, fromMail, recepient, msg, 1);
        try 
        {
            Transport.send(message);
        } 
        catch (MessagingException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
