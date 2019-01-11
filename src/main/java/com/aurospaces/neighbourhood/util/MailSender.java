package com.aurospaces.neighbourhood.util;


import java.io.*;
import java.util.*;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
 
/**
 * A utility class for sending e-mail message with attachment.
 * @author www.codejava.net
 *
 */
public class MailSender {
    /**
     * Sends an e-mail message from a SMTP host with a list of attached files.
     * @param objContext2 
     * @throws IOException 
     *
     */
    public static void sendEmailWithAttachment(String toAddress,
            String subject, String message, List<File> attachedFiles, ServletContext objContext2)
                    throws AddressException, MessagingException, IOException {
    	InputStream input = null;
   	 Properties properties = new Properties();
   	 String propertiespath = objContext2.getRealPath("Resources" +File.separator+"DataBase.properties");
			input = new FileInputStream(propertiespath);
			// load a properties file
			properties.load(input);
		final String username = properties.getProperty("usermail");
		final String password= properties.getProperty("mailpassword");
		String host= properties.getProperty("host");
		String port= properties.getProperty("port");
       // sets SMTP server properties
      
       properties.put("mail.smtp.host",host);
       properties.put("mail.smtp.port",port);
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.user",username);
       properties.put("mail.password",password);

       // creates a new session with an authenticator
       Authenticator auth = new Authenticator() {
           public PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username,password);
           }
       };
       Session session = Session.getInstance(properties, auth);

       // creates a new e-mail message
       Message msg = new MimeMessage(session);

       msg.setFrom(new InternetAddress(username));
       InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
       msg.setRecipients(Message.RecipientType.TO, toAddresses);
       msg.setSubject(subject);
       msg.setSentDate(new Date());

       // creates message part
       MimeBodyPart messageBodyPart = new MimeBodyPart();
       messageBodyPart.setContent(message, "text/html");

       // creates multi-part
       Multipart multipart = new MimeMultipart();
       multipart.addBodyPart(messageBodyPart);

       // adds attachments
       if (attachedFiles != null && attachedFiles.size() > 0) {
           for (File aFile : attachedFiles) {
               MimeBodyPart attachPart = new MimeBodyPart();

               try {
                   attachPart.attachFile(aFile);
               } catch (IOException ex) {
                   ex.printStackTrace();
               }

               multipart.addBodyPart(attachPart);
           }
       }

       // sets the multi-part as e-mail's content
       msg.setContent(multipart);

       // sends the e-mail
       Transport.send(msg);
   }
    
//   public static void main(String [] a)throws Exception
//   {
////       List l=new ArrayList();
////       File f1=new File("c:\\Users\\admin\\Desktop\\collegescript.js");
////       File f2=new File("C:\\Users\\admin\\Desktop\\angular.min.js");
////       l.add(f1);
////       l.add(f2);
//       sendEmailWithAttachment("prudhvi.spring@gmail.com","Registration success","message",l);
//   }
}