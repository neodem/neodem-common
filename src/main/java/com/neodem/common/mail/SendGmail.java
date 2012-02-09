
package com.neodem.common.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

/**
 * uses java mail to send to gmail
 * @author Vince
 *
 */
public class SendGmail {

	private String password;
	private String username;
	private static final String GMAIL = "smtp.gmail.com";

	/**
	 * 
	 * @param username (w/o the gmail.com part)
	 * @param password
	 */
	public SendGmail(String username, String password) {
		this.username = username;
		this.password = password;

		Properties props = System.getProperties();
		props.put("mail.smtps.host", GMAIL);
		props.put("mail.smtps.auth", "true");
	}

	public void send(String to, String subject, String message) {
		try {

			/*
			 * Initialize the JavaMail Session.
			 */
			Properties props = System.getProperties();

			// Get a Session object
			Session session = Session.getInstance(props, null);

			/*
			 * Construct the message and send it.
			 */
			Message msg = new MimeMessage(session);
			msg.setFrom();
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(subject);
			msg.setText(message);
			msg.setHeader("X-Mailer", "smtpsend");
			msg.setSentDate(new Date());

			SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
			try {
				t.connect(GMAIL, username, password);
				t.sendMessage(msg, msg.getAllRecipients());
			} finally {
				t.close();
			}

			System.out.println("\nMail was sent successfully.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
