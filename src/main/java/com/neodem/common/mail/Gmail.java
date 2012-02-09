package com.neodem.common.mail;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Gmail {

	private static final String ACCOUNT = "account";
	private static final String PW = "pass";
	private static final String GMAIL = "smtp.gmail.com";
	private String password;
	private String from;

	public static void main(String[] args) {
		Gmail g = new Gmail(ACCOUNT, PW);
		try {
			g.send(ACCOUNT + "@gmail.com", "subject", "text");
			System.out.println("message sent");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Gmail(String mGmailUsername, String mGmailPassword) {
		this.password = mGmailPassword;
		from = mGmailUsername + "@gmail.com";
	}

	public void send(String to, String subject, String text) throws IOException {
		// SMTPClient client = new SMTPClient("UTF-8");
		// client.setDefaultTimeout(60 * 1000);
		//
		// client.setRequireStartTLS(true); // requires STARTTLS
		// client.setUseAuth(true); // use SMTP AUTH
		//
		// client.connect(GMAIL, 587);
		// checkReply(client);
		//
		// client.login("localhost", from, password);
		// checkReply(client);
		//
		// client.setSender(from);
		// checkReply(client);
		// client.addRecipient(to);
		// checkReply(client);
		//
		// Writer writer = client.sendMessageData();
		//
		// if (writer != null) {
		// SimpleSMTPHeader header = new SimpleSMTPHeader(from, to, subject);
		// writer.write(header.toString());
		// writer.write(text);
		// writer.close();
		// client.completePendingCommand();
		// checkReply(client);
		// }
		//
		// client.logout();
		// client.disconnect();
	}

	private void checkReply(SMTPClient sc) throws IOException {
		if (SMTPReply.isNegativeTransient(sc.getReplyCode())) {
			sc.disconnect();
			throw new IOException("Transient SMTP error " + sc.getReplyCode());
		} else if (SMTPReply.isNegativePermanent(sc.getReplyCode())) {
			sc.disconnect();
			throw new IOException("Permanent SMTP error " + sc.getReplyCode());
		}
	}
}
