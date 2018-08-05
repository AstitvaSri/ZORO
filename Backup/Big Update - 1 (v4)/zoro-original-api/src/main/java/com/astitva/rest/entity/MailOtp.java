package com.astitva.rest.entity;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MailOtp {
	

public String mailOtpNow(String destinationEmail) {
	final String fromEmail = "zoro.junas@gmail.com"; //requires valid gmail id
	final String password = "$junasZORO"; // correct password for gmail id
	final String toEmail = destinationEmail; // can be any email id 
	
	System.out.println("SSLEmail Start");
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
	props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
	props.put("mail.smtp.socketFactory.class",
			"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
	props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
	props.put("mail.smtp.port", "465"); //SMTP Port
	
	Authenticator auth = new Authenticator() {
		//override the getPasswordAuthentication method
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(fromEmail, password);
		}
	};
	
	Session session = Session.getDefaultInstance(props, auth);
	System.out.println("Session created");
	String otp=getSaltString();
	String msgInEmail="Hi there, we're glad that you are getting started with ZORO.\n\nPlease verify your Email with the following OTP(One Time Password) : ";
        EmailUtil.sendEmail(session, toEmail,"ZORO - Verification", msgInEmail+otp);

      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");

     //   EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
        
        return otp;
}


//GENERATING OTP
protected String getSaltString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 6) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;

}


}


class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String toEmail, String subject, String body){
		try
	    {
	      MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");

	      msg.setFrom(new InternetAddress("zoro.junas@gmail.com", "ZORO"));

	      msg.setReplyTo(InternetAddress.parse("zoro.junas@gmail.com", false));

	      msg.setSubject(subject, "UTF-8");

	      msg.setText(body, "UTF-8");

	      msg.setSentDate(new Date());

	      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      System.out.println("Message is ready");
    	  Transport.send(msg);  

	      System.out.println("EMail Sent Successfully!!");
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
