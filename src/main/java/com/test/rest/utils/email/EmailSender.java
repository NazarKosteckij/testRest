package com.test.rest.utils.email;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
	
	private String username;
	private String password;
	
	private Session session;

	private Properties properties;

	public void init(){
		session = Session.getInstance(properties,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Sends mail to user
	 * @param email address of user
	 * @param messageItem
	 * @param subject (title)
	 */
	public void sendMessage(String email, String messageItem, String subject) {
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(messageItem);
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			//TODO: create own exception and handle it
			throw new RuntimeException(e);
		}
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
