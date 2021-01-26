package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;

import javax.mail.internet.*;

public class Mails {
	
	public static Mails instance;
	
	private Properties props;
	
	public static Mails getInstance(){
		if (instance==null){
			instance=new Mails();
		}
		return instance;
	}
	
	private Mails() {
		
	InputStream inputStream=getClass().getClassLoader().getResourceAsStream("MailsPropiedades");
	try {
			
		props = new Properties();
			props.load(inputStream);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void send(String to, String subject, String body,String url){

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(props.getProperty("mail.username"), props.getProperty("mail.password"));
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setDataHandler(new DataHandler(new FileDataSource(url)));
			message.setSubject(subject);
			message.setText(body);
			

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}