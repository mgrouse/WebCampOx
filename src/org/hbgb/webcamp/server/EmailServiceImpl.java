/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 * com.google.gwt.user.server.rpc.RemoteServiceServlet javax.mail.Address
 * javax.mail.Authenticator javax.mail.Message javax.mail.Message$RecipientType
 * javax.mail.Session javax.mail.Transport javax.mail.internet.InternetAddress
 * javax.mail.internet.MimeMessage
 */
package org.hbgb.webcamp.server;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hbgb.webcamp.client.async.EmailService;
import org.hbgb.webcamp.shared.Application;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class EmailServiceImpl extends RemoteServiceServlet implements EmailService
{
	@Override
	public String sendApplicationRecievedEmail(String key)
	{
		ApplicationServiceImpl appServ = new ApplicationServiceImpl();
		Application app = appServ.getApplication(key);

		// first to the Lead "michael.grouse@gmail.com"
		// sendMail(getRegistrationLeadAddressAsText(), "HeeBee application
		// received!", getNotificationEmailBody());
		sendMail("michael.grouse@gmail.com", "HeeBee application received!", getNotificationEmailBody());

		// then to the camper
		return sendMail(app.getEmail(), "Your HeeBee application was received!", getApplicationEmailBody());
	}

	private String sendMail(String to, String subject, String message)
	{
		String output = "Success";
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, (Authenticator) null);
		try
		{
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(this.getWebmasterAddress());
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			msg.setReplyTo(new InternetAddress[] { this.getRegistrationLeadAddress() });
			Transport.send(msg);
			return output;
		}
		catch (Exception e)
		{
			return e.toString();
		}
	}

	/**
	 * @return
	 */
	private String getNotificationEmailBody()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("A new application has been created.\n");
		sb.append("<br><br>");
		sb.append("Look at it in <a href=\"http://www.hbgbwebcamp.appspot.com/#admin\">Admin Land</a>.");
		return sb.toString();
	}

	private String getApplicationEmailBody()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Thank you for applying to be part of the HeeBee camp.\n");
		sb.append("If you don't hear from us soon, email ");
		sb.append(getRegistrationLeadAddressAsText());
		sb.append("\nPlease don't reply to this email address.\n");
		sb.append("Meet the rest of us by joining the HeeBeeGeeBee Healers Facebook Group at: ");
		sb.append("https://www.facebook.com/groups/23767999265/?ref=bookmarks\n");
		sb.append("\n");
		sb.append("This year's co-leads, \n");
		sb.append("Quiggles and Dragonheart\n");
		return sb.toString();
	}

	private InternetAddress getWebmasterAddress() throws Exception
	{
		return new InternetAddress("michael.grouse@gmail.com", "Scarab");
	}

	private InternetAddress getRegistrationLeadAddress() throws Exception
	{
		return new InternetAddress("shanalory@hotmail.com", "Quiggles");
	}

	private String getRegistrationLeadAddressAsText()
	{
		return "shanalory@hotmail.com";
	}
}
