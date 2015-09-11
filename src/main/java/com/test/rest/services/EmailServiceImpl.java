package com.test.rest.services;

import org.springframework.stereotype.Service;

import com.test.rest.utils.email.EmailSender;

@Service
public class EmailServiceImpl implements EmailService {

	private EmailSender emailSender;
	

	public EmailServiceImpl(){
		
	}
	
	public void sendNotification(String email, String message) {
		emailSender.sendMessage(email, message, "Notification mail");
	}

	public void sendConfirmation(String email, String link) {
		String message = "Your link for confirm registration: " + link;
		emailSender.sendMessage(email, message, "Confirm registration ");
	}
	
	public EmailSender getEmailSender() {
		return emailSender;
	}

	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}

}
