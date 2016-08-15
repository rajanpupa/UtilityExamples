package email.tutorialpoint;

import java.util.Properties;

import sun.rmi.transport.Transport;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/*
 * Need to download the javax.mail api
 * https://java.net/projects/javamail/pages/Home
 */
public class SendEmail
{
   public static void main(String [] args)
   {    
      // Recipient's email ID needs to be mentioned.
      String to = "rajanpupa@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "rajanpupa@localhost.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
//      Session session = Session.getDefaultInstance(properties);
//
//      try{
//         // Create a default MimeMessage object.
//         MimeMessage message = new MimeMessage(session);
//
//         // Set From: header field of the header.
//         message.setFrom(new InternetAddress(from));
//
//         // Set To: header field of the header.
//         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//         // Set Subject: header field
//         message.setSubject("This is the Subject Line!");
//
//         // Now set the actual message
//         message.setText("This is actual message");
//
//         // Send message
//         Transport.send(message);
//         System.out.println("Sent message successfully....");
//      }catch (MessagingException mex) {
//         mex.printStackTrace();
//      }
   }
}
